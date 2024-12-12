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
        </div>

        <div class="button-section1">
            <button class="btn-like">👍 추천 ${post.post_vote_count}</button>
        </div>
        <div class="button-section2">
            <button class="btn-report">🚨신고</button>
        </div>

        <div class="move-to-list">
            <button><a href="${contextPath}/post/listPost">목록</a></button>
        </div>

        <div class="view-comment">
            <table class="table-comment">
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

            <div class="comment-insert">
                <h3>댓글 쓰기</h3>
                <div class="comment-box">
                    <textarea placeholder="댓글을 작성하려면 로그인 해주세요. 로그인 하시겠습니까?"></textarea>
                    <button class="comment-submit">등록</button>
                </div>
            </div>
        </div>
        <form method="post"   action="${contextPath}/post/addComment.do">
            <h1  class="text_center">댓글 백엔드 작업중</h1>

            <table border="1"  align="center"  width="80%">
                <tr align="center"   bgcolor="lightgreen">
                    <td ><b>닉네임</b></td>
                    <td><b>시간</b></td>
                    <td><b>내용</b></td>
                </tr>

                <c:forEach var="comment" items="${commentList}" >
                    <tr align="center">
                        <td>${comment.comment_author_nickname}</td>
                        <td>${comment.comment_reg_date}</td>
                        <td>${comment.comment_content}</td>
                    </tr>
                </c:forEach>
            </table>

            <table  align="center">
<%--                <tr>--%>
<%--                    <td width="200"><p align="right">코멘트 아이디</td>--%>
<%--                    <td width="400"><input type="text" name="comment_id"></td>--%>
<%--                </tr>--%>
                <tr>
                    <td width="200"><p align="right">게시글 아이디</td>
                    <td width="400"><input type="text" name="comment_post_id"></td>
                </tr>
                <tr>
                    <td width="200"><p align="right">댓글 작성자 아이디</td>
                    <td width="400"><p><input type="text" name="comment_author_id"></td>
                </tr>
                <tr>
                    <td width="200"><p align="right">댓글 작성자 닉네임</td>
                    <td width="400"><p><input type="text" name="comment_author_nickname"></td>
                </tr>
                <tr>
                    <td width="200"><p align="right">댓글 내용</td>
                    <td width="400"><p><input type="text" name="comment_content"></td>
                </tr>
                <tr>
                    <td width="200"><p>&nbsp;</p></td>
                    <td width="400"><input type="submit" value="댓글쓰기"></td>
                </tr>
            </table>
        </form>


    </div>
</body>
</html>
