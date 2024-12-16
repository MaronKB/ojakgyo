<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>게시글 수정</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/>"/>
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
<main>
    <form onsubmit="editPost(${post.postId}, this)">
        <div id="post-new-container">
            <header id="post-new-header">
                <select id="post-new-category" name="category">
                    <option value="자유"<c:if test="${post.category == '자유'}"> selected</c:if>>자유</option>
                    <option value="리뷰"<c:if test="${post.category == '리뷰'}"> selected</c:if>>리뷰</option>
                    <option value="질문"<c:if test="${post.category == '질문'}"> selected</c:if>>질문</option>
                </select>
                <input type="text" id="post-title" placeholder="제목" name="title" value="${post.title}">
            </header>
            <div id="post-new-body">
                <%--                <div class="image-upload">--%>
                <%--                    <button type="button" id="post-image-upload">이미지 첨부</button>--%>
                <%--                    <input type="file" id="post-new-image" accept="image/*">--%>
                <%--                </div>--%>
                <textarea id="post-content" name="content" placeholder="내용을 입력하세요...">${post.content}</textarea>
            </div>
            <div id="post-new-buttons">
                <button type="button" id="post-new-cancel" onclick="location.href = '/community/v/${post.postId}'">취소</button>
                <button type="submit" id="post-new-submit">수정</button>
            </div>
        </div>
    </form>
</main>
<script src="<c:url value='/js/community/edit.js'/>"></script>
</body>
</html>
