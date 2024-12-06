const clearTags = () => {
    const tags = document.querySelectorAll('[name="location-tag"]');
    tags.forEach((tag) => {
        tag.checked = false;
    });
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

    const locationTags = document.querySelectorAll('[name="location-tag"]:checked');
    const tag = Array.from(locationTags).map((tag) => tag.value);

    const tags = document.createElement('input');
    tags.setAttribute('type', 'hidden');
    tags.setAttribute('name', 'location-tags');
    tags.setAttribute('value', tag.join(','));
    form.appendChild(tags);

    form.submit();
}