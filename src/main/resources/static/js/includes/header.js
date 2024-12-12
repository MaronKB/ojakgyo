const onMenuHover = () => {
    const menus = document.querySelectorAll('#header-menu > a');
    const selector = document.querySelector('#header-selector');
    menus.forEach((menu) => {
        menu.addEventListener("mouseover", () => {
            selector.style.left = menu.offsetLeft + 'px';
            selector.style.opacity = '1';
        });
        menu.addEventListener("mouseout", () => {
            selector.style.left = '0px';
            selector.style.opacity = '0';
        });
    });
}

const logout = async () => {
    const res = await fetch('/api/user/logout').then(res => res.text());
    if (res === "success") {
        alert('로그아웃 되었습니다.');
        location.href = '/login';
    } else {
        alert('오류가 발생했습니다. 잠시 후 다시 시도해주세요.');
    }
}

window.onload = () => {
    onMenuHover();
}