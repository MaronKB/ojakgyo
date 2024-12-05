// login.js

// DOM 요소 가져오기
const usernameInput = document.getElementById("username");
const passwordInput = document.getElementById("password");
const loginForm = document.querySelector(".login-form");
const loginButton = document.querySelector(".login-button button");

// 로그인 버튼 클릭 이벤트
loginForm.addEventListener("submit", (event) => {
    // 기본 폼 제출 방지
    event.preventDefault();

    // 입력값 가져오기
    const username = usernameInput.value.trim();
    const password = passwordInput.value.trim();

    // 간단한 입력값 검증
    if (!username) {
        alert("아이디를 입력하세요.");
        usernameInput.focus();
        return;
    }

    if (!password) {
        alert("비밀번호를 입력하세요.");
        passwordInput.focus();
        return;
    }

    // 서버로 폼 제출 (AJAX 예제)
    fetch("/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({ username, password }),
    })
    .then((response) => {
        if (response.ok) {
            alert("로그인 성공!");
            window.location.href = "/dashboard"; // 대시보드로 이동
        } else if (response.status === 401) {
            alert("로그인 실패: 아이디 또는 비밀번호를 확인하세요.");
        } else {
            alert("로그인 실패: 서버 오류가 발생했습니다.");
        }
    })
    .catch((error) => {
        console.error("로그인 중 오류 발생:", error);
        alert("로그인 중 문제가 발생했습니다. 다시 시도해주세요.");
    });
});

// 입력 필드 포커스 시 스타일 변경
usernameInput.addEventListener("focus", () => {
    usernameInput.style.borderColor = "#007bff";
});

passwordInput.addEventListener("focus", () => {
    passwordInput.style.borderColor = "#007bff";
});

usernameInput.addEventListener("blur", () => {
    usernameInput.style.borderColor = "#ccc";
});

passwordInput.addEventListener("blur", () => {
    passwordInput.style.borderColor = "#ccc";
});

// 버튼 활성화/비활성화 기능
const toggleLoginButton = () => {
    if (usernameInput.value.trim() && passwordInput.value.trim()) {
        loginButton.disabled = false;
        loginButton.style.backgroundColor = "#ffcccc";
    } else {
        loginButton.disabled = true;
        loginButton.style.backgroundColor = "#f0f0f0";
    }
};

usernameInput.addEventListener("input", toggleLoginButton);
passwordInput.addEventListener("input", toggleLoginButton);

// 초기 버튼 상태 설정
toggleLoginButton();
