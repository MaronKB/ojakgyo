document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector(".recovery-form");
    const emailInput = document.querySelector("#email");
    const modal = document.getElementById("modal");
    const modalMessage = document.getElementById("modal-message");
    const closeModal = document.querySelector(".close");

    // 모달 열기
    function openModal(message) {
        modalMessage.textContent = message;
        modal.style.display = "block";
    }

    // 모달 닫기
    closeModal.addEventListener("click", () => {
        modal.style.display = "none";
    });

    window.addEventListener("click", (event) => {
        if (event.target === modal) {
            modal.style.display = "none";
        }
    });

    // 폼 제출 이벤트
    form.addEventListener("submit", function (event) {
        event.preventDefault(); // 기본 폼 제출 막기

        const email = emailInput.value.trim();

        // 이메일 유효성 검사
        if (!validateEmail(email)) {
            openModal("올바른 이메일 주소를 입력하세요.");
            return;
        }

        // 서버로 요청 보내기
        fetch("/find_password.do", {
            method: "POST",
            headers: { "Content-Type": "application/x-www-form-urlencoded" },
            body: `email=${encodeURIComponent(email)}`,
        })
            .then((response) => response.json())
            .then((data) => {
                if (data.success) {
                    openModal("임시 비밀번호가 이메일로 발송되었습니다.");
                } else {
                    openModal("입력하신 이메일을 찾을 수 없습니다.");
                }
            })
    });

    // 이메일 형식 검사 함수
    function validateEmail(email) {
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return emailRegex.test(email);
    }
});
