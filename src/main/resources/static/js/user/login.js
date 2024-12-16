const login = async () => {
    event.preventDefault();
    const body = {
        userId: document.getElementById('login-id').value,
        password: document.getElementById('login-password').value
    }
    const res = await fetch('/api/user/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(body)
    }).then(res => res.json());

    const message = document.querySelector('#login-message');
    if (!res || !res.status) {
        message.innerText = '통신 오류로 로그인에 실패했습니다.';
        message.style.color = 'red';
        return;
    }
    switch (Math.floor(res.status / 100)) {
        case 2:
            document.cookie = `token=${JSON.stringify(res)}`;
            location.href = '/';
            break;
        case 4:
            const msgText = (res?.message) ? res.message : '통신 오류로 로그인에 실패했습니다.';
            message.innerText = res.message;
            message.style.color = 'red';
            break;
        default:
            message.innerText = '서버 오류로 로그인에 실패했습니다.';
            message.style.color = 'red';
            break;
    }
}