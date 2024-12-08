document.addEventListener("DOMContentLoaded", function () {

    const categoryButtons = document.querySelectorAll(".category-buttons .btn");
    const tableBody = document.querySelector(".table body");

    categoryButtons.forEach(button => {
        button.addEventListener("click", function () {

            categoryButtons.forEach(btn => btn.classList.remove("active"));

            this.classList.add("active");

            const selectedCategory = this.dataset.category;

            fetch(`/post/listPostByCategory.do?category=${encodeURIComponent(selectedCategory)}`)
                .then(response => {
                    if (!response.ok) {
                        throw new Error("Network response was not ok");
                    }
                    return response.json();
                })
                .then(data => {
                    updateTable(data); // 받은 데이터로 테이블 업데이트
                })
                .catch(error => console.error("Error fetching data:", error));
        });
    });

    function updateTable(posts) {
        tableBody.innerHTML = "";

        if (posts.length === 0) {
            tableBody.innerHTML = "<tr><td colspan='6'>게시글이 없습니다.</td></tr>";
            return;
        }

        posts.forEach(post => {
            const row = document.createElement("tr");
            row.innerHTML = `
                <td>${post.post_id}</td>
                <td>${post.post_title}</td>
                <td>${post.post_author_nickname}</td>
                <td>${post.post_reg_date}</td>
                <td>${post.post_view_count}</td>
                <td>${post.post_vote_count}</td>
            `;
            tableBody.appendChild(row);
        });
    }

    fetch(`/post/listPostByCategory.do?category=전체`)
        .then(response => response.json())
        .then(data => updateTable(data))
        .catch(error => console.error("Error fetching initial data:", error));

    console.log("Selected Category:", selectedCategory);ㅌ

});