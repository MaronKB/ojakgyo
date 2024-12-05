<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>오작교-비밀번호 찾기</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/index.css'/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/user/login.css'/>"/>
    <script src="<c:url value='/js/passwordRecovery.js'/>"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
<div class="recovery-container">
    <img src="/images/ojakgyo_logo_1000_500.png" alt="오작교 로고">
    <h2>비밀번호 찾기</h2>
    <form class="recovery-form" action="/find_password" method="post" onsubmit="return validateRecoveryForm();">
        <div class="recovery-fields">
            <label for="email">이메일</label>
            <input type="email" id="email" name="email" placeholder="가입한 이메일을 입력하세요" required>
        </div>
        <div class="recovery-button">
            <button type="submit">확인</button>
        </div>
    </form>
    <div class="back-link">
        <a href="/login">로그인 페이지로 돌아가기</a>
    </div>
</div>
<script>
    // 비밀번호 찾기 폼 유효성 검사
    function validateRecoveryForm() {
        const emailInput = document.getElementById('email');
        const email = emailInput.value.trim();

        if (!email) {
            alert('이메일을 입력하세요.');
            emailInput.focus();
            return false;
        }

        // 간단한 이메일 형식 검증
        const emailRegex = /^[\w-.]+@[\w-]+\.[a-z]{2,7}$/i;
        if (!emailRegex.test(email)) {
            alert('올바른 이메일 형식을 입력하세요.');
            emailInput.focus();
            return false;
        }

        return true; // 폼 제출 허용
    }
</script>
</body>
</html>
