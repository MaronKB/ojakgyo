<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/>"/>
    <script type="text/javascript" language="javascript" src="<c:url value="/js/user/login.js"/>"></script>
</head>
<body>
<main id="login-main" class="max">
    <form id="login-form" onsubmit="login()">
        <a id="login-forgot-password" href="<c:url value="/find_password"/>">아이디/비밀번호 찾기</a>
        <div id="login-logo-container">
            <img id="login-logo" src="<c:url value="/images/ojakgyo_logo_1000_500.png"/>" alt="로고"/>
        </div>
        <div class="login-input-container">
            <label for="login-id"><i class="fa-solid fa-user"></i></label>
            <input type="text" id="login-id" name="id" required/>
        </div>
        <div class="login-input-container">
            <label for="login-password"><i class="fa-solid fa-key"></i></label>
            <input type="password" id="login-password" name="password" required/>
        </div>
        <button id="login-submit" type="submit">로그인</button>
        <span id="login-message">또는</span>
        <a id="login-register" href="<c:url value="/register"/>">회원가입</a>
    </form>
    <a id="login-back" href="<c:url value="/"/>"><i class="fa-solid fa-backward"></i>돌아가기</a>
</main>
</body>
</html>
