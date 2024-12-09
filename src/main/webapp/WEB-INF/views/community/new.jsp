<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: MRKB--%>
<%--  Date: 24. 11. 25.--%>
<%--  Time: 오후 3:17--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>오작교-글쓰기</title>--%>
<%--    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">--%>
<%--    <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/>"/>--%>
<%--</head>--%>
<%--<body>--%>
<%--<jsp:include page="/WEB-INF/views/includes/header.jsp"/>--%>

<%--    <div class="container">--%>

<%--        <div class="category-select">--%>
<%--            <select id="category" class="form-select">--%>
<%--                <option value="자유">자유</option>--%>
<%--                <option value="리뷰">리뷰</option>--%>
<%--                <option value="질문">질문</option>--%>
<%--            </select>--%>
<%--        </div>--%>

<%--        <div class="title-input">--%>
<%--            <input type="text" id="title" class="form-control" placeholder="제목">--%>
<%--        </div>--%>

<%--        <div class="content-input">--%>
<%--            <div class="image-upload">--%>
<%--                <button type="button" class="btn btn-outline-secondary" id="imageUploadButton">이미지 첨부</button>--%>
<%--                <input type="file" id="imageInput" style="display: none;" accept="image/*">--%>
<%--                <div id="contentEditableArea" class="form-control" contenteditable="true" style="min-height: 350px"></div>--%>
<%--            </div>--%>
<%--        </div>--%>

<%--        <div class="action-buttons">--%>
<%--            <button type="button" class="btn btn-secondary" id="cancelNew">취소</button>--%>
<%--            <button type="button" class="btn btn-primary" id="submitPost">작성</button>--%>
<%--        </div>--%>
<%--    </div>--%>

<%--<script src="<c:url value='/js/new.js'/>"></script>--%>
<%--</body>--%>
<%--</html>--%>




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
    <meta charset="UTF-8">
    <title>게시글 작성</title>
    <style>
        .text_center{
            text-align:center;
        }
    </style>
</head>
<body>
<form method="post"   action="${contextPath}/post/addPost.do">
    <h1  class="text_center">글쓰기 창 수정중</h1>
    <table  align="center">
        <tr>
            <td width="200"><p align="right">아이디</td>
            <td width="400"><input type="text" name="post_id"></td>
        </tr>
        <tr>
            <td width="200"><p align="right">제목</td>
            <td width="400"><input type="text" name="post_title"></td>
        </tr>
        <tr>
            <td width="200"><p align="right">카테고리</td>
            <td width="400"><p><input type="text" name="post_category"></td>
        </tr>
        <tr>
            <td width="200"><p align="right">작성자아이디</td>
            <td width="400"><p><input type="text" name="post_author_id"></td>
        </tr>        <tr>
        <td width="200"><p align="right">작성자닉네임</td>
        <td width="400"><p><input type="text" name="post_author_nickname"></td>
    </tr>
        <tr>
            <td width="200"><p align="right">내용</td>
            <td width="400"><p><input type="text" name="post_content"></td>
        </tr>

        <tr>
            <td width="200"><p>&nbsp;</p></td>
            <td width="400"><input type="submit" value="가입하기"><input type="reset" value="다시입력"></td>
        </tr>
    </table>
</form>
</body>
