<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MRKB
  Date: 24. 11. 25.
  Time: 오후 3:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>마이페이지</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/>"/>
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>

    <div class="bodycontainer">
        <h2 class=bodyTitle>마이페이지</h2>

                <div class="imgcontainer">
                    <img id="profile-img-btn"
                        src="https://i1.sndcdn.com/avatars-000373392764-zp0p80-t200x200.jpg"
                        class="defaultprofilepicture">
                    <form>
                        <input id="profile-img-input" type="file" class="my_hidden"/>
                    </form>
                </div>

                <div class="upper">
                    <div class="nickname">
                        <input placeholder="야메로"
                        style="width:200px; height:30px;">
                        <button class="nicknamebutton" style="width:200px; height:30px;">닉네임 수정하기</button>
                    </div>

                    <div class="email">
                            <input placeholder="이메일 수정하기"
                            style="width:200px; height:30px;">
                            <button class="emailbutton" style="width:200px; height:30px;">이메일 수정하기</button>
                    </div>
                </div>

                <div class="lower">
                        <div class="password">
                             <input placeholder="비밀번호"
                             style="width:200px; height:30px;">
                             <button class="passwordbutton" style="width:200px; height:30px;">비밀번호 수정하기</button>
                        </div>

                        <div class="address">
                             <input placeholder="경기도 수원시"
                             style="width:200px; height:30px;">
                             <button class="addressbutton" style="width:200px; height:30px;" >주소 수정하기</button>
                        </div>
                </div>


                <div class="introduction">
                    <input placeholder="한줄소개"
                     style="width:200px; height: 60px;">
                    <button class="introbutton" style="width:200px; height:60px;">소개 수정하기</button>
                </div>

                <div class="recentlyRegisteredPosts">
                    <div class="title">
                </div>

                <div class="recentlyRegisteredComments">
                    <div class="title">
                </div>
    </div>
</body>
</html>
