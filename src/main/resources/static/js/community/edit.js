const editPost = async (postId, form) => {
    const category = form.category.value;
    const title = form.title.value;
    const content = form.content.value;
    const response = await fetch(`/api/post/edit/${postId}`, {
        method: 'PATCH',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            title: title,
            category: category,
            content: content,
        }),
    }).then(response => response.text());

    if (response === '1') {
        alert('게시글이 수정되었습니다.');
        window.location.href = '/community/v/' + postId;
    } else {
        alert('게시글 수정에 실패했습니다.');
    }
}