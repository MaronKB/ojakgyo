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
    console.log(res);
    if (res.status === 200) {
        document.cookie = `token=${JSON.stringify(res)}`;
        alert('로그인 성공');
        location.href = '/';
    } else {
        alert('로그인 실패');
    }
}