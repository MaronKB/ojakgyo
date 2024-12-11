const getJusoFromAccount = (target) => {
    const targetHtml = document.querySelector(`#${target}-value`);
}
class Juso {
    constructor(target) {
        this.target = target;
        this.html = null;
        this.page = 1;
        this.total = 0;
        this.itemsOnPage = 5;
    }
    open = () => {
        const jusoContainer = document.createElement("div");
        jusoContainer.className = "juso-container";

        const jusoBox = document.createElement("div");
        jusoBox.className = "juso-box";

        const jusoHeader = document.createElement("header");
        jusoHeader.className = "juso-header";

        const jusoTitle = document.createElement("h3");
        jusoTitle.textContent = "주소검색";

        const jusoClose = document.createElement("a");
        jusoClose.className = "juso-close";
        jusoClose.innerHTML = "<i class=\"fa-solid fa-xmark\"></i>";
        jusoClose.addEventListener("click", this.close);

        const jusoBody = document.createElement("div");
        jusoBody.className = "juso-body";

        const jusoSearch = document.createElement("form");
        jusoSearch.className = "juso-search";
        jusoSearch.addEventListener("submit", (e) => {
            e.preventDefault();
            this.getAddr();
        });

        const jusoInput = document.createElement("input");
        jusoInput.type = "text";
        jusoInput.name = "keyword";
        jusoInput.placeholder = "도로명, 건물명 또는 지번을 입력하세요.";
        jusoInput.addEventListener("keydown", this.onEnter);

        const jusoButton = document.createElement("button");
        jusoButton.type = "button";
        jusoButton.textContent = "검색";
        jusoButton.addEventListener("click", this.getAddr);

        const jusoContent = document.createElement("div");
        jusoContent.className = "juso-content";

        const jusoList = document.createElement("ul");
        jusoList.className = "juso-list";

        const jusoPagination = document.createElement("div");
        jusoPagination.className = "juso-pagination";

        const leftButton = document.createElement("button");
        leftButton.type = "button";
        leftButton.textContent = "<";
        leftButton.addEventListener("click", () => {
            if (this.page > 1) {
                this.page--;
                this.getAddr();
            }
        });

        const pages = document.createElement("span");
        pages.className = "pages";

        for (let i = 1; i <= 10; i++) {
            const page = document.createElement("button");
            page.type = "button";
            page.textContent = i;
            page.disabled = true;
            pages.append(page);
        }

        const rightButton = document.createElement("button");
        rightButton.type = "button";
        rightButton.textContent = ">";
        rightButton.addEventListener("click", () => {
            if (this.page < this.total) {
                this.page++;
                this.getAddr();
            }
        });

        jusoHeader.append(jusoTitle, jusoClose);
        jusoSearch.append(jusoInput, jusoButton);
        jusoPagination.append(leftButton, pages, rightButton);
        jusoContent.append(jusoList, jusoPagination);
        jusoBody.append(jusoSearch, jusoContent);
        jusoBox.append(jusoHeader, jusoBody);
        jusoContainer.append(jusoBox);

        this.html = jusoContainer;
        document.body.append(jusoContainer);
    }
    close = () => {
        this.html.remove();
    }
    getAddr = () => {
        const form = this.html.querySelector(`.juso-search`);
        if (!this.checkKeyword(form.keyword.value)) {
            return;
        }
        const formData = new FormData(form);
        formData.append("currentPage", this.page);
        formData.append("countPerPage", this.itemsOnPage);
        fetch("/api/juso/getAddr.do", {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded",
            },
            body: new URLSearchParams(formData),
        }).then((response) => response.json()).then((jsonStr) => {
            if (jsonStr.results.common.errorCode !== "0") {
                const {errorCode, errorMessage} = jsonStr.results?.common ?? {errorCode : "unknown", errorMessage : "알 수 없는 오류"};
                alert("Error Code " + errorCode  + " : " + errorMessage);
                return;
            }
            const jusoList = this.html.querySelector(`.juso-list`);
            jusoList.replaceChildren(...this.createList(jsonStr.results.juso));
            this.total = Math.ceil(jsonStr.results.common.totalCount / this.itemsOnPage);
            const pages = this.html.querySelector(`.pages`);
            pages.replaceChildren(...this.createPagination());
        }).catch((err) => {
            alert("에러 : " + err);
            console.error(err);
        });
    }
    createList = (juso) => {
        return juso.map((j) => {
            const {jibunAddr, roadAddr, zipNo} = j;

            const jibunHeader = document.createElement("h4");
            jibunHeader.textContent = "지번주소";

            const jibunValue = document.createElement("span");
            jibunValue.textContent = jibunAddr;

            const jibun = document.createElement("div");
            jibun.className = "jibun";
            jibun.append(jibunHeader, jibunValue);

            const roadHeader = document.createElement("h4");
            roadHeader.textContent = "도로명주소";

            const roadValue = document.createElement("span");
            roadValue.textContent = roadAddr;

            const road = document.createElement("div");
            road.className = "road";
            road.append(roadHeader, roadValue);

            const zipHeader = document.createElement("h4");
            zipHeader.textContent = "우편번호";

            const zipValue = document.createElement("span");
            zipValue.textContent = zipNo;

            const zip = document.createElement("div");
            zip.className = "zip";
            zip.append(zipHeader, zipValue);

            const li = document.createElement("li");
            li.className = "juso-item";
            li.addEventListener("click", () => {
                const targetHtml = document.querySelector(`#${this.target}-value`);
                targetHtml.value = roadAddr;
                this.close();
            });
            li.append(jibun, road, zip);

            return li;
        });
    }

    createPagination = () => {
        const arr = [];
        const firstPageOfBlock = Math.floor((this.page - 1) / 5) * 5 + 1;
        for (let i = firstPageOfBlock; i < firstPageOfBlock + 5; i++) {
            const page = document.createElement("button");
            page.type = "button";
            page.textContent = i;
            page.addEventListener("click", () => {
                this.page = i;
                this.getAddr();
            });
            if (i === this.page) {
                page.className = "active";
            }
            if (i > this.total) {
                page.disabled = true;
            }
            arr.push(page);
        }
        return arr;
    }

    checkKeyword = (value) => {
        if(value.length > 0){
            //특수문자 제거
            const expText = /[%=><]/ ;
            if(expText.test(value) === true){
                alert("특수문자를 입력할 수 없습니다.") ;
                value = value.split(expText).join("");
                return false;
            }

            //특정문자열(sql 예약어의 앞뒤공백포함) 제거
            const sqlArray = ["OR", "SELECT", "INSERT", "DELETE", "UPDATE", "CREATE", "DROP", "EXEC", "UNION",  "FETCH", "DECLARE", "TRUNCATE"];

            let regex;
            for(let i= 0; i < sqlArray.length; i++){
                regex = new RegExp( sqlArray[i] ,"gi") ;

                if (regex.test(value) ) {
                    alert("\"" + sqlArray[i] + "\"와(과) 같은 특정문자로 검색할 수 없습니다.");
                    value = value.replace(regex, "");
                    return false;
                }
            }
        }
        return true ;
    }

    onEnter = () => {
        if (event.keyCode === 13) {
            event.keyCode = 0;
            this.getAddr();
        }
    }
}