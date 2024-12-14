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
    <title>관리자-유저</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/>"/>
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
    <div class="container">
        <div class="listUser-search-bar">
            <select id="searchCategory">
                <option value="id">아이디</option>
                <option value="nickname">닉네임</option>
                <option value="email">이메일</option>
<%--                <option value="reg">가입일</option>--%>
<%--                <option value="res">탈퇴일</option>--%>
            </select>
            <input type="text" id="searchKeyword" placeholder="검색어를 입력하세요.">
            <button id="searchButton">조회</button>
        </div>

        <table class="listUser-table">
            <thead>
                <tr>
                    <th><input type="checkbox"></th>
                    <th>아이디</th>
                    <th>닉네임</th>
                    <th>이메일</th>
                    <th>이메일 광고수신</th>
                    <th>가입일</th>
                    <th>탈퇴일</th>
                </tr>
            </thead>
            <tbody id="userTableBody">
                <c:forEach var="user" items="${userList}" >
                    <tr align="center">
                        <td><input type="checkbox"></td>
                        <td>${user.user_id}</td>
                        <td>${user.user_nickname}</td>
                        <td>${user.user_email}</td>
                        <td>${user.user_receive_adv}</td>
                        <td>${user.user_reg_date}</td>
                        <td>${user.user_res_date}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div class="listUser-controls">
            <select>
                <option>10</option>
                <option>30</option>
                <option>50</option>
                <option>100</option>
            </select>

            <div class="pagination">
                <button><</button>
                <button>1</button>
                <button>2</button>
                <button>3</button>
                <button>4</button>
                <button>></button>
            </div>

            <div class="listUser-buttons">
                <button id="add">추가</button>
                <button id="edit">수정</button>
                <button id="delete">삭제</button>
            </div>
        </div>
    </div>
<script src="<c:url value='/js/admin/user.js'/>"></script>
</body>
</html>
