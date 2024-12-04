const onMenuHover = () => {
    const menus = document.querySelectorAll('#header-menu > a');
    const selector = document.querySelector('#header-selector');
    menus.forEach((menu) => {
        menu.addEventListener("mouseover", () => {
            console.log(menu.offsetLeft);
            selector.style.left = menu.offsetLeft + 'px';
            selector.style.opacity = '1';
        });
        menu.addEventListener("mouseout", () => {
            selector.style.left = '0px';
            selector.style.opacity = '0';
        });
    });
}

window.onload = () => {
    onMenuHover();
}