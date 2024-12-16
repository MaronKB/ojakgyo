<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
    request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
    <title>게시글 작성</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/>"/>
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
<main>
    <form method="post" onsubmit="insertPost(this)">
        <div id="post-new-container">
            <header id="post-new-header">
                <select id="post-new-category" name="category">
                    <option value="자유">자유</option>
                    <option value="리뷰">리뷰</option>
                    <option value="질문">질문</option>
                </select>
                <input type="text" id="post-title" placeholder="제목" name="title">
            </header>
            <div id="post-new-body">
<%--                <div class="image-upload">--%>
<%--                    <button type="button" id="post-image-upload">이미지 첨부</button>--%>
<%--                    <input type="file" id="post-new-image" accept="image/*">--%>
<%--                </div>--%>
                <textarea id="post-content" name="content" placeholder="내용을 입력하세요..."></textarea>
            </div>
            <div id="post-new-buttons">
                <button type="button" id="post-new-cancel">취소</button>
                <button type="submit" id="post-new-submit">확인</button>
            </div>
        </div>
    </form>
</main>
<script src="<c:url value='/js/community/new.js'/>"></script>
</body>
</html>
