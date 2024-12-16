/*
// 사진 첨부 버튼
document.addEventListener("DOMContentLoaded", function() {
    const imageUploadButton = document.getElementById("imageUploadButton")
    const imageInput = document.getElementById("imageInput")
    const contentEditableArea = document.getElementById("contentEditableArea")

    imageUploadButton.addEventListener("click", function () {
        imageInput.click();
    });

    imageInput.addEventListener("change", function() {
        const file = imageInput.files[0];
        if (file) {
            const reader = new FileReader();

            reader.onload = function (e) {
                const imageURL = e.target.result;

                const imgElement = document.createElement("img");
                imgElement.src = imageURL;
                imgElement.style.maxWidth = "100%";
                imgElement.style.marginTop = "10px";
                contentEditableArea.appendChild(imgElement);
            };

            reader.readAsDataURL(file);
        }
    });
});

// 게시글 취소 버튼
document.getElementById("cancelNew").addEventListener("click", function() {
    if (confirm ("작성을 취소하시겠습니까?")) {
        window.location.href = "http://localhost:8080/post/listPost";
    }
});

document.querySelector(".btn-primary").addEventListener("click", function() {
    const category = document.getElementById("category").value;
    const title = document.getElementById("title").value;
    const content = document.getElementById("contentEditableArea").innerHTML;

    if(!category || !title || !content) {
        alert("제목과 내용을 입력해주세요.")
        return;
    }
});
*/

const insertPost = async (form) => {
    event.preventDefault();

    const category = form.category.value;
    const title = form.title.value;
    const content = form.content.value;

    if (!category || !title || !content) {
        alert("제목과 내용을 입력해주세요.");
        return;
    }

    const data = {
        category: category,
        title: title,
        content: content
    }

    const response = await fetch("/api/post/add", {
        method: "POST",
        body: JSON.stringify(data)
    }).then(response => response.text());

    console.log(response);

    if (response !== "-1") {
        alert("게시글이 등록되었습니다.");
        window.location.href = `/community`;
    } else {
        alert("게시글 등록에 실패했습니다.");
    }
}