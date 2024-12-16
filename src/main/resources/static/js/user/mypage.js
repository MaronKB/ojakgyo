const editProfile = (id) => {
    const target = document.querySelector(`#profile-${id}`);
    target.readOnly = !target.readOnly;
}

const getUserPosts = async (type, id) => {
    const response = await fetch(`/api/${type}/userId/${id}?page=1`, {
        method: 'GET'
    });

    const res = await response.json();
    let list = res.posts ?? res;
    list = list.slice(0, 5);
    if (list.length === 0) {
        const postList = document.querySelector(`#recent-${type}`);
        postList.innerHTML = `<li class="mypage-list-item">작성 내역이 없습니다.</li>`;
        return;
    }
    if (list.length < 5) {
        for (let i = list.length; i < 5; i++) {
            list.push({ title: "" });
        }
    }
    const doc = list.slice(0, 5).map((post) => {
        const item = document.createElement('li');
        item.classList.add('mypage-list-item');
        if (post.title === "") {
            return item;
        }
        if (type === "post") {
            item.innerHTML = `<a href="/community/v/${post.postId}">${post.title}</a>`;
        } else if (type === "comment") {
            item.innerHTML = `<a href="/community/v/${post.postId}">${post.content}</a>`;
        } else return;
        return item;
    });

    const postList = document.querySelector(`#recent-${type}`);
    postList.replaceChildren(...doc);
}

const updateProfile = async () => {
    const userId = document.querySelector('#profile-user-id').value;
    const nickname = document.querySelector('#profile-nickname').value;
    const email = document.querySelector('#profile-email').value;
    const address = document.querySelector('#profile-address-value').value;
    const intro = document.querySelector('#profile-intro').value;

    const data = {
        user_nickname: nickname,
        user_email: email,
        user_address: address,
        user_intro: intro
    }

    const response = await fetch(`/api/user/update/${userId}`, {
        method: 'PATCH',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });

    if (response.ok) {
        alert('수정되었습니다.');
        location.reload();
    } else {
        alert('수정에 실패했습니다.');
    }
}

const init = async () => {
    const userId = document.querySelector('#profile-user-id').value;
    await getUserPosts('post', userId);
    await getUserPosts('comment', userId);
}

window.onload = init();