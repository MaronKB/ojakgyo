document.addEventListener("DOMContentLoaded", function () {
    const categoryButtons = document.querySelectorAll(".category-btn");
    const postRows = document.querySelectorAll("#postList tr");

    categoryButtons.forEach(button => {
        button.addEventListener("click", function() {
            const selectedCategory = this.getAttribute("data-category");

            categoryButtons.forEach(btn => btn.classList.remove("active"));
            this.classList.add("active");

            postRows.forEach(row => {
                const postCategory = row.getAttribute("data-category");

                if (selectedCategory === "전체" || selectedCategory === postCategory) {
                    row.style.display = "";
                } else {
                    row.style.display = "none";
                }
            });
        });
    });

    document.querySelector('.category-btn[data-category="전체"]').click();
});