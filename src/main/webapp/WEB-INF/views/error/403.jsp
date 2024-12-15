<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>403</title>
    <link rel="stylesheet" href="<c:url value="/css/index.css"/>">
</head>
<body>
<main id="error-main" class="max">
    <div id="error-container">
        <div id="error-title">
            <h1><span>403</span><span>FORBIDDEN</span></h1>
            <h2>접근 권한이 없습니다.</h2>
        </div>
        <div id="error-body">
            <p>요청하신 페이지에 접근할 권한이 없습니다.</p>
            <p>로그인 후 이용해 주세요.</p>
            <hr/>
            <button id="error-button" type="button" onclick="location.href = '/login'">로그인</button>
        </div>
    </div>
</main>
</body>
</html>
