let userIdValid = false;
let emailValid = false;
let passwordValid = false;

const openRegisterModal = (id) => {
    event.preventDefault();
    const modal = document.querySelector(`#register-modal-${id}`);
    modal.classList.add("show");
}

const closeRegisterModal = (id) => {
    const modal = document.querySelector(`#register-modal-${id}`);
    modal.classList.remove("show");
}

const resetValidation = (type) => {
    switch (type) {
        case "userId":
            userIdValid = false;
            break;
        case "email":
            emailValid = false;
            break;
        case "password":
            passwordValid = false;
            break;
        default: break;
    }
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
        if (isUsedId) {
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
        errorMessage(emailError, "이메일은 3자 이상 50자 이하로 입력해주세요");
        emailValid = false;
    } else {
        const isUsedEmail = await fetch(`/api/user/check/email/${email}`).then(response => response.json());
        if (isUsedEmail) {
            errorMessage(emailError, "이미 사용중인 이메일입니다.");
            emailValid = false;
        } else {
            errorMessage(emailError, "사용 가능한 이메일입니다.");
            emailValid = true;
        }
    }
}

const checkPassword = () => {
    const password = document.querySelector("#password").value;
    const passwordError = document.querySelector("#password-error");
    if (password.length < 8 || password.length > 20) {
        errorMessage(passwordError, "비밀번호는 8자 이상 20자 이하로 입력해주세요");
        passwordValid = false;
        return;
    }

    const passwordConfirm = document.querySelector("#password-confirm").value;
    const passwordConfirmError = document.querySelector("#password-confirm-error");
    if (password !== passwordConfirm) {
        errorMessage(passwordConfirmError, "비밀번호가 일치하지 않습니다.");
        passwordValid = false;
        return;
    }
    passwordValid = true;
}

const register = () => {
    event.preventDefault();
    if (!userIdValid) {
        errorMessage(document.querySelector("#user-id-error"), "아이디를 확인해주세요");
        return;
    }
    if (!emailValid) {
        errorMessage(document.querySelector("#email-error"), "이메일을 확인해주세요");
        return;
    }
    if (!passwordValid) {
        errorMessage(document.querySelector("#password-error"), "비밀번호를 확인해주세요");
        return;
    }

    const terms = document.querySelector("#terms").checked;
    if (!terms) {
        errorMessage(document.querySelector("#terms-error"), "약관에 동의해주세요");
        return;
    }

    const userId = document.querySelector("#user-id").value;
    const email = document.querySelector("#email").value;
    const nickname = document.querySelector("#nickname").value;
    const password = document.querySelector("#password").value;
    const receiveAd = document.querySelector("#receive-ad").checked ? "Y" : "N";

    const body = {
        user_id: userId,
        user_pw: password,
        user_email: email,
        user_nickname: nickname,
        user_receive_adv: receiveAd
    };

    fetch("/api/user/register", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(body)
    }).then(response => {
        console.log(response)
        if (response.ok) {
            location.href = "/register/result";
        } else {
            alert("회원가입에 실패했습니다. 다시 시도해 주세요.");
        }
    });
}