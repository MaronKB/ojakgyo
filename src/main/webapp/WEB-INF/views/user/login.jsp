<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>오작교-로그인</title>
    <!-- 스타일시트 경로 설정 -->
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/index.css'/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/user/login.css'/>"/>
    <!-- 자바스크립트 경로 설정 -->
    <script type="text/javascript" language="javascript" src="<c:url value='/js/login.js'/>"></script>
</head>
<body>
    <!-- 공통 헤더 포함 -->
    <jsp:include page="/WEB-INF/views/includes/header.jsp"/>

    <div class="login-container">
        <div class="image-container"></div>

        <!-- 로그인 폼 -->
        <form class="login-form" action="${contextPath}/user/login.do" method="post">
            <div class="login-fields">
                <label for="userid">아이디</label>
                <input type="text" id="userid" name="userid" placeholder="아이디를 입력하세요" required>

                <label for="password">비밀번호</label>
                <input type="password" id="password" name="password" placeholder="비밀번호를 입력하세요" required>
            </div>
            <div class="login-button">
                <button type="submit">로그인</button>
            </div>
        </form>

        <!-- 추가 링크 -->
        <div class="login-links">
            <a href="<c:url value='/register'/>">회원가입</a>
            <a href="<c:url value='/find_password'/>">비밀번호 찾기</a>
        </div>
    </div>

    <!-- 공통 푸터 -->
    <footer>
        <a href="<c:url value='/index/main.jsp'/>">처음으로</a>
    </footer>
</body>
</html>
