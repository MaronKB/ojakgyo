<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>404</title>
    <link rel="stylesheet" href="<c:url value="/css/index.css"/>">
</head>
<body>
<main id="error-main" class="max">
    <div id="error-container">
        <div id="error-title">
            <h1><span>404</span><span>NOT FOUND</span></h1>
            <h2>페이지를 찾을 수 없습니다.</h2>
        </div>
        <div id="error-body">
            <p>요청하신 페이지를 찾을 수 없습니다.</p>
            <p>입력하신 주소가 정확한지 다시 한 번 확인해 주세요.</p>
            <hr/>
            <button id="error-button" type="button" onclick="location.href = '/'">홈으로</button>
        </div>
    </div>
</main>
</body>
</html>
