const editProfile = (id) => {
    const target = document.querySelector(`#profile-${id}`);
    target.readOnly = !target.readOnly;
}

const getUserPosts = async (id) => {
    const response = await fetch(`/api/post/id/${id}?page=1`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        },
    });

    const posts = await response.json();
    console.log(posts);
    const postList = document.querySelector('.post-list');
    postList.innerHTML = '';
    posts.forEach((post) => {
        const postItem = document.createElement('li');
        postItem.innerHTML = `
            <a href="/post/${post.id}">${post.title}</a>
        `;
        postList.appendChild(postItem);
    });
}