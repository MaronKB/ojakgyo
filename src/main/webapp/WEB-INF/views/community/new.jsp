<%--
  Created by IntelliJ IDEA.
  User: MRKB
  Date: 24. 11. 25.
  Time: 오후 3:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>오작교-글쓰기</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/>"/>
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>

    <div class="container">

        <div class="category-select">
            <select id="category" class="form-select">
                <option value="자유">자유</option>
                <option value="리뷰">리뷰</option>
                <option value="질문">질문</option>
            </select>
        </div>

        <div class="title-input">
            <input type="text" id="title" class="form-control" placeholder="제목">
        </div>

        <div class="content-input">
            <div class="image-upload">
                <button type="button" class="btn btn-outline-secondary" id="imageUploadButton">이미지 첨부</button>
                <input type="file" id="imageInput" style="display: none;" accept="image/*">
                <div id="contentEditableArea" class="form-control" contenteditable="true" style="min-height: 350px"></div>
            </div>
        </div>

        <div class="action-buttons">
            <button type="button" class="btn btn-secondary" id="cancelNew">취소</button>
            <button type="button" class="btn btn-primary">작성</button>
        </div>
    </div>

<script src="<c:url value='/js/new.js'/>"></script>
</body>
</html>
