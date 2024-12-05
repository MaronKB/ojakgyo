<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>오작교-로그인</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/user/login.css'/>"/>
   <script type="text/javascript" language="javascript" src="<c:url value="/js/login.js"/>"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
    <div class="login-container">
        <img src="/images/ojakgyo_logo_1000_500.png" alt="오작교 로고">
        <form class="login-form" action="/login" method="post">
            <div class="login-fields">
                <label for="username">아이디</label>
                <input type="text" id="username" name="username" placeholder="아이디를 입력하세요" required>
                <label for="password">비밀번호</label>
                <input type="password" id="password" name="password" placeholder="비밀번호를 입력하세요" required>
            </div>
            <div class="login-button">
                <button type="submit">로그인</button>
            </div>
        </form>
        <div class="login-links">
            <a href="/register">회원가입</a>
            <a href="/find_password">비밀번호 찾기</a>
        </div>
    </div>
    <footer>
        <a href="#">처음으로</a>
    </footer>
</body>
</html>
