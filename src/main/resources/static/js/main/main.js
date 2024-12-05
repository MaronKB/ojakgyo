const clearTags = () => {
    const tags = document.querySelectorAll('[name="location-tag"]');
    tags.forEach((tag) => {
        tag.checked = false;
    });
}