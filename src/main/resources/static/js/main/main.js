const countTags = (element) => {
    const categories = document.querySelectorAll('[name="category"]:checked');
    const count = categories.length;

    if (count > 8) {
        alert('태그는 8개까지 선택 가능합니다.');
        element.checked = false;
    }
}

const clearTags = () => {
    const categories = document.querySelectorAll('[name="category"]');
    categories.forEach((category) => {
        category.checked = false;
    });
}

const toggleBox = (element) => {
    const target = document.querySelector(`#${element.dataset.target}`);
    target.classList.toggle('active');
    checkInputDone();
}

const checkInputDone = () => {
    const myLocation = document.querySelector('#my-location-value').value;
    const myLocationButton = document.querySelector('#my-location-toggle');
    myLocationButton.classList.toggle('done', myLocation !== '');

    const yourLocation = document.querySelector('#your-location-value').value;
    const yourLocationButton = document.querySelector('#your-location-toggle');
    yourLocationButton.classList.toggle('done', yourLocation !== '');

    const categories = document.querySelectorAll('[name="category"]:checked + label');
    const categoryButton = document.querySelector('#category-button');
    categoryButton.classList.toggle('done', categories.length > 0);
    const tags = Array.from(categories).map((category) => {
        const span = document.createElement('span');
        span.classList.add('category-tag');
        span.textContent = category.innerText;
        return span;
    });

    const categoryTags = document.querySelector('#category-tags');
    if (tags.length === 0) {
        const span = document.createElement('span');
        span.classList.add('category-tag');
        span.textContent = '태그_선택';
        categoryTags.replaceChildren(span);
    } else {
        categoryTags.replaceChildren(...tags);
    }
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
        alert('상대방의 위치를 입력해주세요.');
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
    const checkboxes = document.querySelectorAll('[name="category"]');
    console.log(checkboxes.length);
    checkboxes.forEach((checkbox) => {
        checkbox.addEventListener('change', (event) => {
            countTags(event.target);
        });
    });
    const mainContainers = document.querySelectorAll(".main-box-container");
    Array.from(mainContainers).forEach((container) => {
        container.addEventListener('click', (event) => {
            toggleBox(event.target);
        });
    });
    const mainBoxes = document.querySelectorAll(".main-box");
    Array.from(mainBoxes).forEach((box) => {
        box.addEventListener('click', (event) => {
            event.stopPropagation();
        });
    })
}

window.addEventListener('DOMContentLoaded', () => init());