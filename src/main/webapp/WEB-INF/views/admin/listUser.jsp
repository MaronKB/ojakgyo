<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: MRKB--%>
<%--  Date: 24. 11. 25.--%>
<%--  Time: 오후 3:15--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>관리자페이지</title>--%>
<%--    <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/>"/>--%>
<%--</head>--%>
<%--<body>--%>
<%--<jsp:include page="/WEB-INF/views/includes/header.jsp"/>--%>
<%--    <div class="container">--%>
<%--        <div class="search-bar">--%>
<%--            <select>--%>
<%--                <option value="id">아이디</option>--%>
<%--                <option value="nickname">닉네임</option>--%>
<%--                <option value="email">이메일</option>--%>
<%--            </select>--%>
<%--            <input type="text" placeholder="검색어 입력">--%>
<%--            <button>조회</button>--%>
<%--        </div>--%>
<%--        <table>--%>
<%--            <thead>--%>
<%--            <tr>--%>
<%--                <th><input type="checkbox"></th>--%>
<%--                <th>번호</th>--%>
<%--                <th>아이디</th>--%>
<%--                <th>비밀번호</th>--%>
<%--                <th>닉네임</th>--%>
<%--                <th>이메일</th>--%>
<%--                <th>가입일</th>--%>
<%--                <th>탈퇴일</th>--%>
<%--                <th>이메일 수신</th>--%>
<%--            </tr>--%>
<%--            </thead>--%>
<%--            <tbody>--%>
<%--            <tr>--%>
<%--                <td><input type="checkbox"></td>--%>
<%--                <td>1</td>--%>
<%--                <td>human123456</td>--%>
<%--                <td>***********</td>--%>
<%--                <td>둘리희동이</td>--%>
<%--                <td>great119@human.com</td>--%>
<%--                <td>2023-07-25</td>--%>
<%--                <td>-</td>--%>
<%--                <td>O</td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td><input type="checkbox"></td>--%>
<%--                <td>2</td>--%>
<%--                <td>yamero0125</td>--%>
<%--                <td>***********</td>--%>
<%--                <td>야메로456</td>--%>
<%--                <td>yamero9478@human.com</td>--%>
<%--                <td>2024-04-22</td>--%>
<%--                <td>2024-10-02</td>--%>
<%--                <td>X</td>--%>
<%--            </tr>--%>
<%--            <!-- 추가 데이터 행 -->--%>
<%--            </tbody>--%>
<%--        </table>--%>
<%--        <div class="controls">--%>
<%--            <div class="pagination">--%>
<%--                <button>&laquo;</button>--%>
<%--                <button>1</button>--%>
<%--                <button>2</button>--%>
<%--                <button>3</button>--%>
<%--                <button>4</button>--%>
<%--                <button>5</button>--%>
<%--                <button>&raquo;</button>--%>
<%--            </div>--%>
<%--            <select>--%>
<%--                <option>10</option>--%>
<%--                <option>20</option>--%>
<%--                <option>50</option>--%>
<%--            </select>--%>
<%--        </div>--%>
<%--        <div class="action-buttons">--%>
<%--            <button>추가</button>--%>
<%--            <button>수정</button>--%>
<%--            <button>삭제</button>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</body>--%>
<%--</html>--%>


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
</head>
<body>
    <table border="1"  align="center"  width="80%">
        <tr align="center"   bgcolor="lightgreen">
            <td ><b>아이디</b></td>
            <td><b>비밀번호</b></td>
            <td><b>닉네임</b></td>
            <td><b>이메일</b></td>
            <td><b>광고수신</b></td>
            <td><b>가입일</b></td>
            <td><b>탈퇴일</b></td>
        </tr>

        <c:forEach var="user" items="${userList}" >
            <tr align="center">
                <td>${user.user_id}</td>
                <td>${user.user_pw}</td>
                <td>${user.user_nickname}</td>
                <td>${user.user_email}</td>
                <td>${user.user_receive_adv}</td>
                <td>${user.user_reg_date}</td>
                <td>${user.user_res_date}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
