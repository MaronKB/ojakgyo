<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MRKB
  Date: 24. 12. 2.
  Time: 오후 3:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>핫플레이스</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/>"/>
</head>
<body>
    <jsp:include page="/WEB-INF/views/includes/header.jsp"/>
    <br>
    <div class="container">
    </div>
    <div class="regionSelect">
        <form class="select">
        <select name="regions" id="region">
            <option value="서울시">서울시</option>
        </form>
    </div>

    <div class="sidebar">
    </div>
</body>
</html>
