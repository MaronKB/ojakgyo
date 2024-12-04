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
        window.location.href = "http://localhost:8080/community";
    }
});

document.querySelector(".btn-primary").addEventListener("click", function() {
    const category = document.getElementById("category").value;
    const title = document.getElementById("title").value;
    const content = document.getElementById("contentEditableArea").innerHTML;

    const post = {
        title: title,
        category: category,
        authorId: "yamero456",
        authorNickname: "제라툴",
        content: content,
        imageName: "",
        imagePath: ""
    };

    fetch("/post/create", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(post)
    })

    .then(response => {
        if (response.ok) {
            alert("글이 작성되었습니다.");
            window.location.href = "http://localhost:8080/community";  // 이거 주소 수정해야함. 일단이걸로
        } else {
            alert("실패");
        }
    })
    .catch(error => console.error("Error:", error));
});