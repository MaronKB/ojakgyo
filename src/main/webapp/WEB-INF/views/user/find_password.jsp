<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>오작교-비밀번호 찾기</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/index.css'/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/user/find_password.css'/>"/>
    <script type="text/javascript" src="<c:url value='/js/F_password.js'/>" defer></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
<div id="login-main">
    <div class="recovery-container">
        <h2>비밀번호 찾기</h2>
        <form class="recovery-form">
            <div class="recovery-fields">
                <label for="email">이메일</label>
                <input type="email" id="email" name="email" placeholder="가입한 이메일을 입력하세요" required>
            </div>
            <div class="recovery-button">
                <button type="submit">확인</button>
            </div>
        </form>
        <div class="back-link">
            <a id="login-forgot-password" href="/login">로그인 페이지로 돌아가기</a>
        </div>
    </div>
</div>

<div id="modal" class="modal">
    <div class="modal-content">
        <span class="close">&times;</span>
        <p id="modal-message"></p>
    </div>
</div>
</body>
</html>
