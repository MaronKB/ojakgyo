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