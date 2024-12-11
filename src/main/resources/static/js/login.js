// login.js

document.addEventListener("DOMContentLoaded", function () {
    // 로그인 폼 요소 가져오기
    const loginForm = document.querySelector(".login-form");
    const usernameInput = document.querySelector("#username");
    const passwordInput = document.querySelector("#password");

    // 폼 제출 이벤트 처리
    loginForm.addEventListener("submit", function (event) {
        // 입력값 검증
        if (usernameInput.value.trim() === "") {
            alert("아이디를 입력하세요.");
            usernameInput.focus();
            event.preventDefault(); // 폼 제출 중단
            return;
        }

        if (passwordInput.value.trim() === "") {
            alert("비밀번호를 입력하세요.");
            passwordInput.focus();
            event.preventDefault(); // 폼 제출 중단
            return;
        }

        // 유효성 검사를 통과한 경우 콘솔 출력 (추후 서버 요청 처리 가능)
        console.log("아이디:", usernameInput.value);
        console.log("비밀번호:", passwordInput.value);
    });
});
.