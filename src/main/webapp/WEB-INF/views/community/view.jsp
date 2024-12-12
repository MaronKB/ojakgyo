<%--<%@ page language="java" contentType="text/html; charset=UTF-8"--%>
<%--         pageEncoding="UTF-8"--%>
<%--         isELIgnored="false"  %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>--%>
<%--<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />--%>

<%--<%--%>
<%--    request.setCharacterEncoding("UTF-8");--%>
<%--%>--%>


<%--<html>--%>
<%--<head>--%>
<%--    <meta charset=UTF-8">--%>
<%--    <title>커뮤니티-오작교</title>--%>
<%--    <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/>"/>--%>
<%--</head>--%>
<%--<body>--%>
<%--<jsp:include page="/WEB-INF/views/includes/header.jsp"/>--%>

<%--    <div class="container">--%>

<%--        <div class="post-container">--%>
<%--            <div class="post-header">--%>
<%--                <div class="post-title">${post.post_title}</div>--%>
<%--                <div class="post-info">--%>
<%--                    <span class="post-author">${post.post_author_nickname}</span>--%>
<%--                    <span class="post-date">${post.post_reg_date}</span>--%>
<%--                    <span class="post-view">조회수: ${post.post_view_count}</span>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="post-content">--%>
<%--                ${post.post_content}--%>
<%--            </div>--%>
<%--            <div class="post-actions">--%>
<%--                <button class="btn-like"> 추천 ${post.post_vote_count}</button>--%>
<%--                <button class="btn-report">🚩 신고</button>--%>
<%--            </div>--%>
<%--        </div>--%>

<%--        <div class="comments-section">--%>
<%--            <h2>댓글</h2>--%>
<%--            <div class="comments-list">--%>
<%--                <c:forEach var="comment" items="${comments}">--%>
<%--                    <div class="comment" style="margin-left: ${comment.depth * 20}px">--%>
<%--                        <div class="comment-info">--%>
<%--                            <span class="comment-author">${comment.author}</span>--%>
<%--                            <span class="comment-date">${comment.date}</span>--%>
<%--                        </div>--%>
<%--                        <div class="comment-content">${comment.content}</div>--%>
<%--                        <div class="comment-actions">--%>
<%--                            <button class="btn-reply" data-comment-id="${comment.id}">답글</button>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </c:forEach>--%>
<%--            </div>--%>
<%--            <div class="comment-form">--%>
<%--                <textarea id="new-comment" placeholder="댓글을 작성해주세요."></textarea>--%>
<%--                <button id="submit-comment">등록</button>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>

<%--<script src="<c:url value='/js/view.js'/>"></script>--%>
<%--</body>--%>
<%--</html>--%>




<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 조회</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/>"/>
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>

    <div class="view-container">

        <div class="view-title">
            ${post.post_title}
        </div>

        <div class="view-info">
            <p id="nickname">닉네임: ${post.post_author_nickname}</p>
            <p id="view">조회수: ${post.post_view_count}</p>
            <p id="vote">추천수: ${post.post_vote_count}</p>
            <p id="date">작성일: ${post.post_reg_date}</p>
        </div>

        <div class="view-content">
            <p>${post.post_content}</p>

            <div class="button-container">
                <button class="btn-like">👍 추천 ${post.post_vote_count}</button>
                <button class="btn-report">🚨신고</button>
            </div>
        </div>

        <div class="move-to-list">
            <button><a href="${contextPath}/post/listPost">목록</a></button>
        </div>

        <div class="view-comment">
            <table>
                <thead class="comment-head">
                    <tr>
                        <td>댓글</td>
                    </tr>
                </thead>

                <tbody class="comment-body">
                    <tr>
                        <td>댓글</td>
                        <td>댓글</td>
                    </tr>
                </tbody>
            </table>
        </div>


    </div>
</body>
</html>
