<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>회원가입</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/>">
    <script src="<c:url value='/js/user/register.js'/>"></script>
</head>
<body>
<main id="register-container" class="max">
    <form id="register" onsubmit="register()">
        <div id="register-already-have-account">
            <span>이미 계정이 있나요?</span>
            <a href="<c:url value="/login"/>">로그인<i class="fa-solid fa-arrow-up-right-from-square"></i></a>
        </div>
        <div id="register-logo-container">
            <img src="<c:url value="/images/ojakgyo_logo_1000_500.png"/>" id="register-logo" alt="오작교"/>
        </div>
        <div class="register-row">
            <label for="user-id">아이디</label>
            <input id="user-id" name="userId" type="text" onkeydown="resetValidation('userId')" required="required"/>
            <button type="button" id="user-id-check" onclick="checkUserId()">중복 확인</button>
            <span id="user-id-error" class="register-error"></span>
        </div>
        <div class="register-row">
            <label for="email">이메일</label>
            <input id="email" name="email" type="email" onkeydown="resetValidation('email')" required="required"/>
            <button type="button" id="email-check" onclick="checkEmail()">중복 확인</button>
            <span id="email-error" class="register-error"></span>
        </div>
        <div class="register-row">
            <label for="nickname">닉네임</label>
            <input id="nickname" name="nickname" type="text" required="required"/>
        </div>
        <div class="register-row">
            <label for="password">비밀번호</label>
            <input id="password" name="password" type="password" onkeydown="resetValidation('password')" onblur="checkPassword()" required="required"/>
            <span id="password-error" class="register-error"></span>
        </div>
        <div class="register-row">
            <label for="password-confirm">비밀번호 확인</label>
            <input id="password-confirm" name="passwordConfirm"  onkeydown="resetValidation('password')" onblur="checkPassword()" type="password" required="required"/>
            <span id="password-confirm-error" class="register-error"></span>
        </div>
        <div id="register-agreements">
            <div class="agreement">
                <input id="terms" name="terms" type="checkbox" required/>
                <label for="terms"><a onclick="openRegisterModal('terms')">이용약관</a> 및 <a onclick="openRegisterModal('privacy')">개인정보 취급방침</a>에 동의합니다(필수).</label>
                <span id="terms-error" class="register-error"></span>
            </div>
            <div class="agreement">
                <input id="receive-ad" name="receiveAd" type="checkbox" value="Y"/>
                <label for="receive-ad">광고성 이메일 수신 동의(선택)</label>
            </div>
        </div>
        <button type="submit" id="register-submit">회원가입</button>
    </form>
</main>
<jsp:include page="terms.jsp"/>
<jsp:include page="privacy.jsp"/>
</body>
</html>
