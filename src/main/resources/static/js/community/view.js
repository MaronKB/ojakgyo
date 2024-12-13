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