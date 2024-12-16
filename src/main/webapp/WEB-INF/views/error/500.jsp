<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>500</title>
    <link rel="stylesheet" href="<c:url value="/css/index.css"/>">
</head>
<body>
<main id="error-main" class="max">
    <div id="error-container">
        <div id="error-title">
            <h1><span>500</span><span>INTERNAL SERVER ERROR</span></h1>
            <h2>서버 내부 오류가 발생했습니다.</h2>
        </div>
        <div id="error-body">
            <p>요청하신 페이지를 표시할 수 없습니다.</p>
            <p>잠시 후 다시 시도해 주세요.</p>
            <hr/>
            <button id="error-button" type="button" onclick="location.href = '/'">홈으로</button>
        </div>
    </div>
</main>
</body>
</html>
