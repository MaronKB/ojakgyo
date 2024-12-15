let adsList = {valid: [], invalid: []};
let validPage = 1;
let invalidPage = 1;

const getAdsListByValid = async (valid) => {
    try {
        const response = await fetch(`/api/ads/${valid}`);
        return await response.json();
    } catch (error) {
        console.error(error);
    }
}

const getAdsList = async () => {
    const valid = await getAdsListByValid("Y");
    const invalid = await getAdsListByValid("N");

    console.log(valid);
    return {valid, invalid};
}

const setAdsList = async () => {
    adsList = await getAdsList();
}

const createAdsList = async () => {
    const createAdList = (type, list) => {
        const page = type === "valid" ? validPage : invalidPage;
        const pageList = list.slice((page - 1) * 10, page * 10);
        if (pageList.length <= 10) {
            for (let i = pageList.length; i < 10; i++) {
                pageList.push({id: 0, title: "", expDate: ""});
            }
        }
        createPagination(type);

        return pageList.map((ad) => {
            const li = document.createElement("li");
            li.classList.add("ad");

            if (ad.id === 0) return li;

            const input = document.createElement("input");
            input.type = "checkbox";
            input.value = ad.id;
            input.id = "ad-" + ad.id;
            input.classList.add("ad-checkbox");

            const label = document.createElement("label");
            label.htmlFor = "ad-" + ad.id;

            const content = document.createElement("span");
            content.classList.add("ad-content");

            const title = document.createElement("span");
            title.classList.add("ad-title");
            title.textContent = ad.title;

            const expireDate = document.createElement("span");
            expireDate.classList.add("ad-expires-in");
            expireDate.textContent = (ad.expDate) ? "~ " + ad.expDate : "만료일자 지정되지 않음";

            const buttons = document.createElement("span");
            buttons.classList.add("ad-buttons");

            const editButton = document.createElement("a");
            editButton.classList.add("ad-edit");
            editButton.innerHTML = "<i class=\"fa-solid fa-pen-to-square\"></i>";
            editButton.onclick = (ev) => {
                ev.preventDefault();
                openAdModal(ad);
            }

            const deleteButton = document.createElement("a");
            deleteButton.classList.add("ad-delete");
            deleteButton.innerHTML = "<i class=\"fa-solid fa-trash\"></i>";
            deleteButton.onclick = () => {
                deleteAd(ad.id);
            }

            content.appendChild(title);
            content.appendChild(expireDate);
            buttons.appendChild(editButton);
            buttons.appendChild(deleteButton);
            label.appendChild(content);
            label.appendChild(buttons);
            li.appendChild(input);
            li.appendChild(label);

            return li;
        });
    }
    const validAdsList = createAdList("valid", adsList.valid);
    const invalidAdsList = createAdList("invalid", adsList.invalid);

    const validAds = document.getElementById("ads-enabled");
    const invalidAds = document.getElementById("ads-disabled");

    validAds.replaceChildren(...validAdsList);
    invalidAds.replaceChildren(...invalidAdsList);
}

const setPage = async (type, bool) => {
    if (type === "valid") {
        validPage = (bool) ? validPage + 1 : validPage - 1;
    } else if (type === "invalid") {
        invalidPage = (bool) ? invalidPage + 1 : invalidPage - 1;
    }
    await renderAdsList(type, page);
}

const renderAdsList = async (type, page) => {
    if (type === "valid") {
        validPage = page;
    } else if (type === "invalid") {
        invalidPage = page;
    }
    await createAdsList();
    await createPagination(type);
}

const createPagination = async (type) => {
    const arr = [];
    const page = type === "valid" ? validPage : invalidPage;
    const totalPage = Math.ceil(adsList[type].length / 10);
    const firstPageOfBlock = Math.floor((Number(page) - 1) / 5) * 5 + 1;
    for (let i = firstPageOfBlock; i < firstPageOfBlock + 5; i++) {
        const pageElement = document.createElement("a");
        pageElement.textContent = i.toString();
        pageElement.addEventListener("click", () => {
            if (type === "valid") {
                validPage = i;
            } else if (type === "invalid") {
                invalidPage = i;
            }
            renderAdsList(type, i);
        });
        if (i === page) {
            pageElement.className = "active";
        }
        if (i > totalPage) {
            pageElement.classList.add("disabled");
        }
        arr.push(pageElement);
    }
    const pagination = document.getElementById(`ads-${type}-pagination`);
    pagination.replaceChildren(...arr);
}

const insertAd = async () => {
    const ad = {
        title: "새 광고",
        category: "전체",
        expDate: null,
        isValid: "N"
    }
    try {
        const response = await fetch("/api/ad", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(ad)
        });
        if (response.ok) {
            await setAdsList();
            await createAdsList();
        }
    } catch (error) {
        console.error(error);
    }
}

const deleteAd = async (id) => {
    try {
        const response = await fetch(`/api/ad/${id}`, {
            method: "DELETE"
        });
        if (response.ok) {
            await setAdsList();
            await createAdsList();
        }
    } catch (error) {
        console.error(error);
    }
    closeAdModal();
}

const moveAd = async (id, valid) => {
    try {
        console.log(valid);
        await fetch(`/api/ad/${id}`, {
            method: "PATCH",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({isValid : valid}),
        });
    } catch (error) {
        console.error(error);
    }
}

const moveAds = async (valid) => {
    const ads = document.querySelectorAll(".ad-checkbox:checked");
    await Promise.all([...ads].map(async (ad) => {
        await moveAd(ad.value, valid);
    }));
    await setAdsList();
    await createAdsList();
}

const openAdModal = (ad) => {
    const modal = document.getElementById("ad-modal-container");
    const id = document.getElementById("ad-modal-id");
    id.value = ad.id;
    const title = document.getElementById("ad-modal-title");
    title.value = ad.title;
    const expireDate = document.getElementById("ad-modal-end");
    expireDate.value = ad.expDate.split(" ")[0];
    const isValid = document.getElementById(`ad-modal-${(ad.isValid === 'Y') ? "enable" : "disable"}`);
    isValid.checked = true;

    modal.classList.add("open");
}

const closeAdModal = () => {
    const modal = document.getElementById("ad-modal-container");
    modal.classList.remove("open");
}

const init = async () => {
    await setAdsList();
    await createAdsList();
    await createPagination("valid");
    await createPagination("invalid");
}

window.onload = init;