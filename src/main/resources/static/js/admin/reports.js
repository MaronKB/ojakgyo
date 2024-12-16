let category = "전체";
let page = 1;
let totalPages = 1;

const activateCategory = async (ev) => {
    const categoryButtons = document.querySelectorAll(".category-button");
    categoryButtons.forEach(c => c.classList.remove("active"));

    const categoryButton = ev.target;
    categoryButton.classList.add("active");
    category = categoryButton.textContent;

    await getPostList();
    await createPagination();
}

const getPostList = async () => {
    let url = `/api/post/reported/${category}?page=${page}`;
    const result = await fetch(url, {
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    }).then(response => response.json());

    const { totalPage, posts } = result;

    totalPages = totalPage;

    if (posts.length < 15) {
        const length = 15 - posts.length;
        for (let i = 0; i < length; i++) {
            posts.push({});
        }
    }

    const docs = posts.map(post => {
        const { postId, title, authorNickname, regDate, viewCount, voteCount } = post;
        const li = document.createElement("li");
        li.classList.add("post-item");

        if (postId === undefined) {
            li.classList.add("empty");
            return li;
        }

        li.onclick = () => {
            location.href = `/community/v/${postId}`;
        }

        const index = document.createElement("span");
        index.classList.add("post-index");
        index.textContent = postId;

        const titleSpan = document.createElement("span");
        titleSpan.classList.add("post-title");
        titleSpan.textContent = title;

        const writerSpan = document.createElement("span");
        writerSpan.classList.add("post-writer");
        writerSpan.textContent = authorNickname;

        const treatSpan = document.createElement("span");
        treatSpan.classList.add("post-treat");

        const editButton = document.createElement("button");
        editButton.classList.add("post-edit");
        editButton.innerHTML = "<i class=\"fa-solid fa-pen-to-square\"></i>";
        editButton.onclick = (ev) => {
            ev.stopPropagation();
            location.href = `/community/edit/${postId}`;
        }

        const deleteButton = document.createElement("button");
        deleteButton.classList.add("post-delete");
        deleteButton.innerHTML = "<i class=\"fa-solid fa-trash\"></i>";
        deleteButton.onclick = async (ev) => {
            ev.stopPropagation();
            if (!confirm("정말 삭제하시겠습니까?")) return;
            const response = await fetch(`/api/post/delete/${postId}`, {
                method: "DELETE",
                headers: {
                    "Content-Type": "application/json"
                }
            }).then(response => response.text());

            console.log(response);
            if (response === "-1") {
                alert("삭제되었습니다.");
                await getPostList();
                await createPagination();
            } else {
                alert("삭제에 실패했습니다. 다시 시도해주세요.");
            }
        }

        treatSpan.append(editButton, deleteButton);
        li.append(index, titleSpan, writerSpan, treatSpan);

        return li;
    });

    const postBody = document.querySelector("#post-body");
    postBody.replaceChildren(...docs);
}

const searchPost = async () => {
    const searchType = document.querySelector("#search-type");
    const searchKeyword = document.querySelector("#search-value");
    await getPostList(searchType.value, searchKeyword.value);
    await createPagination();
    searchType.value = "title";
    searchKeyword.value = "";
}

const createPagination = async () => {
    const currentBlock = Math.ceil(page / 10);
    const start = (currentBlock - 1) * 10 + 1;
    const arr = [];
    for (let i = start; i < start + 10; i++) {
        const pageButton = document.createElement("a");
        pageButton.classList.add("post-page-button");
        if (i === page) {
            pageButton.classList.add("active");
        }
        if (i > totalPages) {
            pageButton.classList.add("disabled");
        }
        pageButton.textContent = i.toString();
        pageButton.onclick = async () => {
            page = i;
            await getPostList();
            await createPagination();
        };
        arr.push(pageButton);
    }
    const pagination = document.querySelector("#post-page");
    pagination.replaceChildren(...arr);
}

const init = async () => {
    const categoryButtons = document.querySelectorAll(".category-button");
    categoryButtons.forEach(categoryButton => {
        categoryButton.onclick = (ev) => activateCategory(ev);
    });

    await getPostList();
    await createPagination();
}

window.onload = init;