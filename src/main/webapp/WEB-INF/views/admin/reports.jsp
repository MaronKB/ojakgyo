<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 신고관리</title>
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
            <span class="post-treat">처리</span>
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
</main>
<jsp:include page="/WEB-INF/views/includes/footer.jsp"/>
<script src="<c:url value='/js/admin/reports.js'/>"></script>
</body>
</html>
