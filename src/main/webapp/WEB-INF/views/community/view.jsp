<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>${post.title} - 오작교 커뮤니티</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/>"/>
    <script src="<c:url value="/js/community/view.js"/>"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
<main id="community-view-main">
    <div class="view-container">
        <h2 class="view-title">
            ${post.title}
        </h2>
        <div class="view-info">
            <p id="nickname">닉네임: ${post.authorNickname}</p>
            <p id="view">조회수: ${post.viewCount}</p>
            <p id="vote">추천수: ${post.voteCount}</p>
            <p id="date">작성일: ${post.regDate}</p>
        </div>
        <div class="view-content">
            <p>${post.content}</p>
        </div>
        <div class="button-section1">
            <button class="btn-like">👍추천 ${post.voteCount}</button>
        </div>
        <div class="button-section2">
            <button class="btn-report">🚨신고</button>
        </div>
        <div class="move-to-list">
            <button><a href="<c:url value="/community"/>">목록</a></button>
        </div>
        <section id="post-comments-container">
            <ul id="post-comments">
                <c:forEach var="comment" items="${comments}">
                    <li class="comment">
                        <header class="comment-header">
                            <span class="comment-author">${comment.authorNickname}</span>
                            <span class="comment-date">${comment.regDate}</span>
                        </header>
                        <div class="comment-content">${comment.content}</div>
                    </li>
                </c:forEach>
            </ul>
            <form id="comment-insert" onsubmit="addComment()">
                <input id="comment-post-id" type="hidden" value="${post.postId}">
                <label for="comment-area"><span id="comment-insert-header">댓글 쓰기</span><span id="comment-length">0/4000</span></label>
                <textarea id="comment-area"<c:if test="${sessionScope.user == null}"> placeholder="댓글을 작성하려면 로그인 해주세요. 로그인 하시겠습니까?" onfocus="location.href = '/login'"</c:if> oninput="commentLimitation()"></textarea>
                <button id="comment-submit" type="submit"<c:if test="${sessionScope.user == null}"> disabled</c:if>>등록</button>
            </form>
        </section>
    </div>
</main>
</body>
</html>
