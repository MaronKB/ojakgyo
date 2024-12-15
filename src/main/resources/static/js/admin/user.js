document.addEventListener("DOMContentLoaded", function () {

    // 검색기능
    const searchButton = document.getElementById("searchButton");
    const searchCategory = document.getElementById("searchCategory");
    const searchKeyword = document.getElementById("searchKeyword");
    const userTableBody = document.getElementById("userTableBody");

    searchButton.addEventListener("click", function () {
        const category = searchCategory.value;
        const keyword = searchKeyword.value.trim();

        if (!keyword) {
            alert("검색어를 입력해주세요.");
            return;
        }


        const xhr = new XMLHttpRequest();
        xhr.open("GET", `/admin/searchUsers?category=${category}&keyword=${encodeURIComponent(keyword)}`, true);

        xhr.onload = function () {
            if (xhr.status === 200) {
                const users = JSON.parse(xhr.responseText);
                updateTable(users);
            }
        };

        xhr.send();
    });

    function updateTable(users) {
        userTableBody.innerHTML = "";

        if (users.length === 0) {
            const emptyRow = document.createElement("tr");
            emptyRow.innerHTML = "<td colspan='7'>검색된 사용자가 없습니다.</td>";
            userTableBody.appendChild(emptyRow);
        } else {
            users.forEach(user => {
                const row = document.createElement("tr");
                row.innerHTML = `
                    <td><input type="checkbox"></td>
                    <td>${user.user_id}</td>
                    <td>${user.user_nickname}</td>
                    <td>${user.user_email}</td>
                    <td>${user.user_receive_adv}</td>
                    <td>${user.user_reg_date}</td>
                    <td>${user.user_res_date}</td>
                `;
                userTableBody.appendChild(row);
            });
        }
    }


    // 페이지네이션
    const rowsPerPage = 20;
    const paginationContainer = document.querySelector(".pagination");


    const rows = Array.from(userTableBody.getElementsByTagName("tr"));
    const totalRows = rows.length;
    const totalPages = Math.ceil(totalRows / rowsPerPage);


    const createPagination = () => {
        paginationContainer.innerHTML = "";

        const prevButton = document.createElement("button");
        prevButton.textContent = "<";
        prevButton.disabled = true;
        paginationContainer.appendChild(prevButton);

        for (let i = 1; i <= totalPages; i++) {
            const pageButton = document.createElement("button");
            pageButton.textContent = i;
            pageButton.classList.add("page-btn");
            if (i === 1) pageButton.classList.add("active");
            paginationContainer.appendChild(pageButton);

            pageButton.addEventListener("click", () => {
                displayPage(i);
                updatePaginationState(i);
            });
        }

        const nextButton = document.createElement("button");
        nextButton.textContent = ">";
        paginationContainer.appendChild(nextButton);

        nextButton.addEventListener("click", () => {
            const currentPage = getCurrentPage();
            if (currentPage < totalPages) {
                displayPage(currentPage + 1);
                updatePaginationState(currentPage + 1);
            }
        });

        prevButton.addEventListener("click", () => {
            const currentPage = getCurrentPage();
            if (currentPage > 1) {
                displayPage(currentPage - 1);
                updatePaginationState(currentPage - 1);
            }
        });
    };


    const displayPage = (page) => {
        const start = (page - 1) * rowsPerPage;
        const end = start + rowsPerPage;

        rows.forEach((row, index) => {
            if (index >= start && index < end) {
                row.style.display = "";
            } else {
                row.style.display = "none";
            }
        });
    };


    const updatePaginationState = (currentPage) => {
        const pageButtons = paginationContainer.querySelectorAll(".page-btn");
        pageButtons.forEach((btn, index) => {
            btn.classList.remove("active");
            if (index + 1 === currentPage) {
                btn.classList.add("active");
            }
        });

        const prevButton = paginationContainer.querySelector("button:first-child");
        const nextButton = paginationContainer.querySelector("button:last-child");

        prevButton.disabled = currentPage === 1;
        nextButton.disabled = currentPage === totalPages;
    };

    const getCurrentPage = () => {
        const activeButton = paginationContainer.querySelector(".page-btn.active");
        return parseInt(activeButton.textContent, 10);
    };


    const initPagination = () => {
        createPagination();
        displayPage(1);
    };

    initPagination();

});


// 삭제 기능
document.getElementById("delete").onclick = async () => {
    const selectedCheckboxes = document.querySelectorAll("tbody input[type='checkbox']:checked");
    const userIds = Array.from(selectedCheckboxes).map(checkbox => {
        return checkbox.closest("tr").querySelector("td:nth-child(2)").textContent;
    });

    if (userIds.length === 0) {
        alert("삭제할 회원을 선택하세요.");
        return;
    }

    const confirmDelete = confirm("정말 삭제하시겠습니까?");
    if (!confirmDelete) {
        return;
    }

    const response = await fetch("/admin/deleteUsers", {
        method: "POST",
        headers: { "Content-Type": "application/x-www-form-urlencoded" },
        body: new URLSearchParams({ userIds: userIds })
    });

    if (response.ok) {
        alert("회원을 삭제했습니다.");
        location.reload();
    }
};



