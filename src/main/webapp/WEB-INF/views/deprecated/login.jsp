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
    <script type="text/javascript" src="<c:url value='/js/login.js'/>"></script>
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

    <!-- 모달 추가 -->
    <div id="errorModal" class="modal">
        <div class="modal-content">
            <span class="close-button">&times;</span>
            <p id="modalMessage"></p>
        </div>
    </div>

    <!-- 공통 푸터 -->
    <footer>
        <a href="<c:url value='/index/main.jsp'/>">처음으로</a>
    </footer>

    <style>
        /* 모달 스타일 추가 */
        .modal {
            display: none;
            position: fixed;
            z-index: 1000;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgba(0, 0, 0, 0.4);
        }

        .modal-content {
            background-color: #fefefe;
            margin: 15% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 30%;
            text-align: center;
        }

        .close-button {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
            cursor: pointer;
        }

        .close-button:hover,
        .close-button:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }
    </style>
</body>
</html>
