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
    <title>회원 정보 출력창</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/>"/>
</head>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
    <body>
    <table border="1"  align="center"  width="80%">
        <tr align="center"   bgcolor="lightgreen">
            <td ><b>번호</b></td>
            <td><b>제목</b></td>
            <td><b>작성자</b></td>
            <td><b>작성일</b></td>
            <td><b>조회수</b></td>
            <td><b>추천수</b></td>
        </tr>

        <c:forEach var="post" items="${postList}" >
            <tr align="center">
                <td>${post.post_id}</td>
                <td>${post.post_title}</td>
                <td>${post.post_author_nickname}</td>
                <td>${post.post_reg_date}</td>
                <td>${post.post_view_count}</td>
                <td>${post.post_vote_count}</td>
            </tr>
        </c:forEach>
    </table>
    <%--<a  href="${contextPath}/member/memberForm.do"><h1 style="text-align:center">회원가입</h1></a>--%>
    </body>
</html>
