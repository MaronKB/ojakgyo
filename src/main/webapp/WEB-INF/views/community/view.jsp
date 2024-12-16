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
    <div id="view-container">
        <section id="view-post-container">
            <h2 id="view-title">${post.title}</h2>
            <div id="view-info">
                <span id="nickname">닉네임: ${post.authorNickname}</span>
                <div>
                    <span id="views">조회수: ${post.viewCount}</span>
                    <span id="votes">추천수: ${post.voteCount}</span>
                    <span id="date">작성일: ${post.regDate}</span>
                </div>
            </div>
            <div id="view-content">${post.content}</div>
            <div id="vote-container">
                <div id="vote-content">
                    <span id="vote-title">추천수</span>
                    <span id="vote">${post.voteCount}</span>
                </div>
                <div id="vote-buttons">
                    <button onclick="upVote(${post.postId})"><i class="fa-solid fa-thumbs-up"></i>추천</button>
                    <button onclick="reportPost(${post.postId})"><i class="fa-solid fa-bell"></i>신고</button>
                </div>
            </div>
            <div id="button-section">
                <a href="<c:url value="/community"/>">목록</a>
                <c:if test="${isOwner}">
                    <a href="<c:url value="/community/edit/${post.postId}"/>">수정</a>
                    <a onclick="deletePost(${post.postId})">삭제</a>
                </c:if>
            </div>
        </section>
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
