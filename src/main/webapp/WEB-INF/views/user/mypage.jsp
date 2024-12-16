<%@ page import="org.json.simple.JSONObject" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>오작교-마이페이지</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/>"/>
    <script src="<c:url value="/js/includes/juso.js"/>"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
<main>
    <div id="profile-container">
        <h3 id="profile-title">내 프로필</h3>
        <form id="profile" onsubmit="updateProfile()">
            <input type="hidden" id="profile-user-id" name="userId" value="${user.userId}">
            <div id="profile-img-container">
                <img id="profile-img" src="<%
                    JSONObject user = (JSONObject) request.getAttribute("user");
                    Object image = user.get("profileName");
                    String path;
                    if (image == null) path= "/images/default_profile.png";
                    else path = image.toString();

                    out.print(path);
                %>" alt="프로필 사진">
            </div>
            <div id="profile-grid">
                <div class="profile-input">
                    <label for="profile-nickname">닉네임</label>
                    <input type="text" id="profile-nickname" value="${user.nickname}" readonly>
                    <button id="profile-nickname-edit" type="button" onclick="editProfile('nickname')">수정</button>
                </div>
                <div class="profile-input">
                    <label for="profile-email">이메일</label>
                    <input type="email" id="profile-email" value="${user.email}" readonly>
                    <button id="profile-email-edit" type="button" onclick="editProfile('email')">수정</button>
                </div>
                <div class="profile-input span-2">
                    <label>자주 쓰는 주소</label>
                    <jsp:include page="/WEB-INF/views/includes/juso.jsp">
                        <jsp:param name="id" value="profile-address"/>
                    </jsp:include>
                </div>
                <div class="profile-input span-2">
                    <label for="profile-intro">소개</label>
                    <textarea id="profile-intro" placeholder="자기소개" readonly>${user.intro}</textarea>
                    <button id="profile-intro-edit" type="button" onclick="editProfile('intro')">수정</button>
                </div>
                <button class="profile-input span-2" id="profile-submit" type="submit">수정 확인</button>
            </div>
        </form>
        <div id="recent-container">
            <div class="mypage-lists">
                <h3>최근 게시글 목록</h3>
                <ul id="recent-post" class="mypage-list">
                </ul>
            </div>
            <div class="mypage-lists">
                <h3>최근 댓글 목록</h3>
                <ul id="recent-comment" class="mypage-list">
                </ul>
            </div>
        </div>
    </div>
</main>
<script src="<c:url value='/js/user/mypage.js'/>"></script>
</body>
</html>
