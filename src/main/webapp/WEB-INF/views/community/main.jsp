<%--
  Created by IntelliJ IDEA.
  User: MRKB
  Date: 24. 11. 25.
  Time: 오후 3:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>오작교-커뮤니티</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/>"/>
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>

    <div class="container">

        <div class="category-buttons">
            <button class="btn btn-outline-primary category-btn" data-category="전체">전체</button>
            <button class="btn btn-outline-primary category-btn" data-category="인기">인기</button>
            <button class="btn btn-outline-primary category-btn" data-category="리뷰">리뷰</button>
            <button class="btn btn-outline-primary category-btn" data-category="자유">자유</button>
            <button class="btn btn-outline-primary category-btn" data-category="질문">질문</button>
        </div>

        <table class="table table-hover">
            <thead>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>작성일</th>
                    <th>조회수</th>
                    <th>추천수</th>
                </tr>
            </thead>
            <tbody id="postList">
    <%--        <c:forEach var="post" items="${postList}">--%>
    <%--            <tr>--%>
    <%--                <td>${post.id}</td>--%>
    <%--                <td>${post.title} <span class="badge bg-secondary">${post.commentCount}</span></td>--%>
    <%--                <td>${post.author}</td>--%>
    <%--                <td>${post.date}</td>--%>
    <%--                <td>${post.views}</td>--%>
    <%--                <td>${post.recommendations}</td>--%>
    <%--            </tr>--%>
    <%--        </c:forEach>--%>
                <tr data-category="자유">
                    <td>1</td>
                    <td>취업은 못할것같습니다</td>
                    <td>야메로456</td>
                    <td>2024-12-04</td>
                    <td>0</td>
                    <td>0</td>
                </tr>
                <tr data-category="질문">
                    <td>2</td>
                    <td>코딩이란 무엇인가</td>
                    <td>제라툴</td>
                    <td>2024-12-04</td>
                    <td>0</td>
                    <td>0</td>
                </tr>
            </tbody>
        </table>

        <div class="write-btn">
<%--            <a href="new.jsp" class="btn btn-success">글쓰기</a>--%>
                <a href="<c:url value="/community/new"/>" class="btn btn-success">글쓰기</a>
        </div>

        <nav class="pagination">
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="#"><</a></li>
                <li class="page-item active"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item"><a class="page-link" href="#">></a></li>
            </ul>
        </nav>

        <div class="search-bar">
            <input type="text" class="form-control" placeholder="검색어를 입력해주세요.">
            <button class="btn btn-primary">검색</button>
        </div>
    </div>

<script src="<c:url value='/js/community.js'/>"></script>
</body>
</html>
