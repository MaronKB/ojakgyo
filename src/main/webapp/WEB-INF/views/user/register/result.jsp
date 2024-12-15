<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/>"/>
</head>
<body>
<main id="register-result-main" class="max">
    <section id="register-result">
        <header id="register-result-header">
            <h2>회원가입 완료</h2>
            <p>회원가입이 완료되었습니다.</p>
        </header>
        <div id="register-result-body">
            <a href="<c:url value="/login"/>">로그인</a>
            <a href="<c:url value="/"/>">메인으로</a>
        </div>
    </section>
</main>
</body>
</html>
