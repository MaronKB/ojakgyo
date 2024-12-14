document.addEventListener("DOMContentLoaded", function () {
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
            } else {
                alert("데이터를 가져오는 중 오류가 발생했습니다.");
            }
        };

        xhr.onerror = function () {
            alert("네트워크 오류가 발생했습니다.");
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
});
