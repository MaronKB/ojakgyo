<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html lang="ko">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/>"/>
    <script src="<c:url value='/js/register.js'/>"></script>
    <script src="<c:url value='/js/jQuery-2.1.4.min.js'/>"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
<main>
    <form action="${contextPath}/user/register.do" method="post">
        <div id="memberwindow">
            <div id="logoimage"></div>
            <div id="layout1">
                <div id="layout1-text">
                    <p>아이디</p>
                    <p>비밀번호</p>
                    <p>비밀번호 확인</p>
                    <p>닉네임</p>
                    <p>이메일</p>
                </div>
                <div id="layout1-input">
                    <input id="r_id" name="userId" type="text" required="required"/>
                    <input id="r_idcheck" type="button" value="중복체크" onclick="checkUserId()" />
                    <input id="r_password" name="password" type="password" required="required"/>
                    <input id="r_passwordcheck" name="passwordCheck" type="password" required="required" />
                    <input id="r_nickname" name="nickname" type="text" required="required" />
                    <input id="r_email" name="email" type="email" required="required"/>
                    <input id="r_emailcheck" type="button" value="중복체크" onclick="checkEmail()" />
                </div>
            </div>
            <div id="layout2">
                <p>
                    <input id="consentinfo" name="terms" type="checkbox" required />
                    <a href="javascript:void(0);" id="termsLink" style="text-decoration: underline; color: #0066cc;"
                       onmouseover="this.style.color='#ff6600'" onmouseout="this.style.color='#0066cc'">이용약관</a> 및
                    <a href="javascript:void(0);" id="privacyLink" style="text-decoration: underline; color: #0066cc;"
                       onmouseover="this.style.color='#ff6600'" onmouseout="this.style.color='#0066cc'">개인정보 취급방침</a>에 동의
                </p>
                <p><input id="consentad" name="receiveAd" type="checkbox"  value="Y" /> 광고성 이메일 수신 동의</p>
            </div>
            <div id="accession">
                <input id="accession-button" value="가입하기" type="submit" onclick="return validateForm()"  />
            </div>
        </div>
    </form>
</main>
<div>
    <button id="randing-button" onclick="window.location.href='<c:url value="/"/>';">
        처음으로
    </button>
</div>
<script>

</script>

</body>
</html>
