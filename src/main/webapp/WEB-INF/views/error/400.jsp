<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>400</title>
    <link rel="stylesheet" href="<c:url value="/css/index.css"/>">
</head>
<body>
<main id="error-main" class="max">
    <div id="error-container">
        <div id="error-title">
            <h1><span>400</span><span>BAD REQUEST</span></h1>
            <h2>잘못된 요청입니다.</h2>
        </div>
        <div id="error-body">
            <p>잘못된 요청입니다.</p>
            <p>요청하신 페이지를 표시할 수 없습니다.</p>
            <hr/>
            <button id="error-button" type="button" onclick="location.href = '/'">홈으로</button>
        </div>
    </div>
</main>
</body>
</html>
