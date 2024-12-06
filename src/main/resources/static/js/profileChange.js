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



