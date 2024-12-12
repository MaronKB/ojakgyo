<%--
  Created by IntelliJ IDEA.
  User: MRKB
  Date: 24. 11. 25.
  Time: 오후 3:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>오작교-비밀번호 찾기</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/index.css'/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/user/find_password.css'/>"/>
    <script type="text/javascript" language="javascript" src="<c:url value='/js/F_password.js'/>"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
<div class="recovery-container">
    <div class="image-container"></div>
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
        <a href="/login">로그인 페이지로 돌아가기</a>
    </div>
</div>

<!-- 모달 추가 -->
<div id="modal" class="modal">
    <div class="modal-content">
        <span class="close">&times;</span>
        <p id="modal-message"></p>
    </div>
</div>

</body>
</html>
