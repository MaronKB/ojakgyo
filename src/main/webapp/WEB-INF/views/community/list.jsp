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
    <title>커뮤니티</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/>"/>
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
<main id="post-main">
    <div class="category-buttons">
        <button type="button" class="category-button active" data-category="전체">전체</button>
        <button type="button" class="category-button" data-category="인기">인기</button>
        <button type="button" class="category-button" data-category="리뷰">리뷰</button>
        <button id="categoryForum" type="button" class="category-button" data-category="자유">자유</button>
        <button type="button" class="category-button" data-category="질문">질문</button>
    </div>
    <div id="post-container">
        <header id="post-header" class="post-item">
            <span class="post-index">번호</span>
            <span class="post-title">제목</span>
            <span class="post-writer">작성자</span>
            <span class="post-date">작성일</span>
            <span class="post-views">조회</span>
            <span class="post-votes">추천</span>
        </header>
        <ul id="post-body"></ul>
        <footer id="post-footer">
            <div id="post-pagination">
                <a id="post-left" class="post-page-button"><i class="fa-solid fa-chevron-left"></i></a>
                <span id="post-page"></span>
                <a id="post-right" class="post-page-button"><i class="fa-solid fa-chevron-right"></i></a>
            </div>
        </footer>
    </div>
    <div id="post-bottom">
        <div class="post-search-bar">
            <select id="search-type">
                <option value="title">제목</option>
                <option value="content">내용</option>
                <option value="author">작성자</option>
            </select>
            <input type="text" id="search-value" placeholder="검색어를 입력해주세요.">
            <button type="button" onclick="searchPost()">검색</button>
        </div>
        <a id="add-post" href="<c:url value="/community/new"/>">글쓰기</a>
    </div>
</main>
</body>
<script src="<c:url value='/js/community/list.js'/>"></script>
</html>
