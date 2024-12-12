<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
    request.setCharacterEncoding("UTF-8");
%>


<html>
<head>
    <meta charset=UTF-8">
    <title>커뮤니티-오작교</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/>"/>
    <script src="<c:url value='/js/jQuery-2.1.4.min.js'/>"></script>

</head>
<body>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>

    <div class="container">
        <div class="category-buttons">
            <button type="button" class="btn" data-category="전체">전체</button>
            <button type="button" class="btn" data-category="인기">인기</button>
            <button type="button" class="btn" data-category="리뷰">리뷰</button>
            <button id="categoryForum" type="button" class="btn" data-category="자유">자유</button>
            <button type="button" class="btn" data-category="질문">질문</button>
        </div>

        <div class="table-container">
            <table class="table">
                <thead>
                    <tr>
                        <td>번호</td>
                        <td>제목</td>
                        <td>작성자</td>
                        <td>작성일</td>
                        <td>조회수</td>
                        <td>추천수</td>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="post" items="${postList}" >
                    <tr id="postdata">
                        <td><a href="${contextPath}/post/view.do?postId=${post.post_id}">${post.post_id}</a></td>
                        <td class="content"><a href="${contextPath}/post/view.do?postId=${post.post_id}">${post.post_title}</a></td>
                        <td><a href="${contextPath}/post/view.do?postId=${post.post_id}">${post.post_author_nickname}</a></td>
                        <td><a href="${contextPath}/post/view.do?postId=${post.post_id}">${post.post_reg_date}</a></td>
                        <td><a href="${contextPath}/post/view.do?postId=${post.post_id}">${post.post_view_count}</a></td>
                        <td><a href="${contextPath}/post/view.do?postId=${post.post_id}">${post.post_vote_count}</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="write-btn">
            <a href="<c:url value="/community/new"/>">글쓰기</a>
        </div>

        <div class="pagination">
            <a href="#">«</a>
            <a href="#">1</a>
            <a href="#">2</a>
            <a href="#">3</a>
            <a href="#">4</a>
            <a href="#">5</a>
            <a href="#">6</a>
            <a href="#">7</a>
            <a href="#">8</a>
            <a href="#">9</a>
            <a href="#">»</a>
        </div>

        <div class="post-search-bar">
            <select>
                <option>제목</option>
                <option>내용</option>
                <option>제목+내용</option>
                <option>작성자</option>
            </select>
            <input type="text" placeholder="검색어를 입력해주세요.">
            <button>검색</button>
        </div>
    </div>
<script src="<c:url value='/js/listPost.js'/>"></script>
</body>
</html>
