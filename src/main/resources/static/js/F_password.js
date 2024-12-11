
    function validateRecoveryForm() {
        const emailInput = document.getElementById('email');
        const email = emailInput.value.trim();

        if (!email) {
            alert('이메일을 입력하세요.');
            emailInput.focus();
            return false;
        }

        // 간단한 이메일 형식 검증
        const emailRegex = /^[\w-.]+@[\w-]+\.[a-z]{2,7}$/i;
        if (!emailRegex.test(email)) {
            alert('올바른 이메일 형식을 입력하세요.');
            emailInput.focus();
            return false;
        }

        return true; // 폼 제출 허용
    }
