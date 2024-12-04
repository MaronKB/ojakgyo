document.addEventListener("DOMContentLoaded", function() {

})




document.getElementById("cancelNew").addEventListener("click", function() {
    if (confirm ("작성을 취소하시겠습니까?")) {
        window.location.href = "http://localhost:8080/community";
    }
});