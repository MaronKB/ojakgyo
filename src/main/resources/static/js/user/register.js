let userIdValid = false;
let emailValid = false;

const openRegisterModal = (id) => {
    event.preventDefault();
    const modal = document.querySelector(`#register-modal-${id}`);
    modal.classList.add("show");
}

const closeRegisterModal = (id) => {
    const modal = document.querySelector(`#register-modal-${id}`);
    modal.classList.remove("show");
}

const resetUserIdValidation = () => {
    emailValid = false;
}

const errorMessage = (target, msg) => {
    target.innerHTML = msg;
    target.classList.add("active");
    setTimeout(() => {
        target.classList.remove("active");
    }, 2000);
}

const checkUserId = async () => {
    const userId = document.querySelector("#user-id").value;
    const userIdError = document.querySelector("#user-id-error");
    if (userId.length < 4 || userId.length > 20) {
        errorMessage(userIdError, "아이디는 4자 이상 20자 이하로 입력해주세요");
        userIdValid = false;
    } else if (!/^[a-z0-9]{4,20}$/.test(userId)) {
        errorMessage(userIdError, "아이디는 영문 소문자와 숫자로만 입력해주세요");
        userIdValid = false;
    } else {
        const isUsedId = await fetch(`/api/user/check/id/${userId}`).then(response => response.json());
        console.log(isUsedId);
        if (!isUsedId) {
            errorMessage(userIdError, "이미 사용중인 아이디입니다.");
            userIdValid = false;
        } else {
            errorMessage(userIdError, "사용 가능한 아이디입니다.");
            userIdValid = true;
        }
    }
}

const checkEmail = async () => {
    const email = document.querySelector("#email").value;
    const emailError = document.querySelector("#email-error");
    if (email.length < 3 || email.length > 50) {
        emailError.innerHTML = "이메일은 3자 이상 50자 이하로 입력해주세요";
        emailError.style.display = "block";
        emailValid = false;
    } else {
        emailError.style.display = "none";
        const isUsedEmail = await fetch(`/api/user/validate/${email}`).then(response => response.json());
        if (isUsedEmail) {
            emailError.innerHTML = "이미 사용중인 이메일입니다.";
            emailError.style.display = "block";
            emailValid = false;
        } else {
            emailError.style.display = "none";
            emailValid = true;
        }
    }
}

const validateRegisterForm = (form) => {
    const userId = document.querySelector("#userId").value;
}