const countTags = (element) => {
    const categorys = document.querySelectorAll('[name="category"]:checked');
    const count = categorys.length;

    if (count > 3) {
        alert('태그는 10개까지 선택 가능합니다.');
        element.checked = false;
    }
}
const clearTags = () => {
    const categorys = document.querySelectorAll('[name="category"]');
    categorys.forEach((category) => {
        category.checked = false;
    });
}

const toggleBox = (element) => {
    const target = document.querySelector(`#${element.dataset.target}`);
    target.classList.toggle('active');
}

const go = () => {
    const form = document.querySelector('#main-form');

    const myLocation = form["my-location-value"].value;
    if (myLocation === '') {
        alert('내 위치를 입력해주세요.');
        return;
    }

    const yourLocation = form["your-location-value"].value;
    if (yourLocation === '') {
        alert('상대방 위치를 입력해주세요.');
        return;
    }

    const locationTags = document.querySelectorAll('[name="category"]:checked');
    const category = Array.from(locationTags).map((category) => category.value);

    const categories = document.createElement('input');
    categories.type = 'hidden';
    categories.name = 'categories';
    categories.value = category.join(',');

    form.append(categories);
    form.submit();
}

const init = () => {
    const checkboxes = document.querySelectorAll('[name="location-category"]');
    console.log(checkboxes.length);
    checkboxes.forEach((checkbox) => {
        checkbox.addEventListener('change', (event) => {
            countTags(event.target);
        });
    });
}

window.addEventListener('DOMContentLoaded', () => init());