const addComment = async () => {
    event.preventDefault();
    const postId = document.querySelector('#comment-post-id').value;
    const content = document.querySelector('#comment-area').value;
    const response = await fetch(`/api/comment/add`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            postId: postId,
            content: content,
        }),
    }).then(response => response.text());

    if (response !== "-1") {
        alert('댓글이 등록되었습니다.');
        window.location.reload();
    } else {
        alert('댓글 등록에 실패했습니다.');
    }
}

const commentLimitation = () => {
    const commentArea = document.querySelector('#comment-area');
    const commentLength = document.querySelector('#comment-length');
    commentLength.innerText = commentArea.value.length + '/4000';
    if (commentArea.value.length >= 4000) {
        commentLength.style.color = 'red';
        commentLength.innerText = '댓글은 4000자까지만 입력 가능합니다. 4000/4000';
        commentArea.value = commentArea.value.substring(0, 4000);
    }
}

const reportPost = async (postId) => {
    if (!confirm('해당 게시글을 신고하시겠습니까?')) {
        return;
    }
    const response = await fetch(`/api/post/report/${postId}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        }
    }).then(response => response.text());

    if (response === '1') {
        alert('신고가 완료되었습니다.');
        window.location.reload();
    } else {
        alert('신고에 실패했습니다.');
    }
}

const deletePost = async (postId) => {
    if (!confirm('해당 게시글을 삭제하시겠습니까?')) {
        return;
    }
    const response = await fetch(`/api/post/delete/${postId}`, {
        method: 'DELETE',
    }).then(response => response.text());

    if (response === '-1') {
        alert('게시글이 삭제되었습니다.');
        window.location.href = '/community';
    } else {
        alert('게시글 삭제에 실패했습니다.');
    }
}

const upVote = async (postId) => {
    const response = await fetch(`/api/post/upvote/${postId}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        }
    }).then(response => response.text());

    if (response === '1') {
        alert('추천하였습니다.');
        window.location.reload();
    } else {
        alert('추천에 실패했습니다.');
    }
}