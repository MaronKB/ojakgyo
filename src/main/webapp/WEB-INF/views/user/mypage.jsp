<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>오작교-마이페이지</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/>"/>
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>

    <div class="bodycontainer">
        <h2 class=bodyTitle>마이페이지</h2>
                <br>
                <div class="imgcontainer">
                    <img id="profile-img-btn"
                        src="https://i1.sndcdn.com/avatars-000373392764-zp0p80-t200x200.jpg"
                        class="defaultprofilepicture">
                        <br>
                    <form>
                        <input id="profile-img-input" type="file" class="my_hidden"/>
                    </form>
                </div>
                <div class="upper">
                    <div class="nickname">
                        <p>닉네임</p>
                        <input placeholder="태사다르"
                        style="width:200px; height:30px;">
                        <button class="editbutton" style="width:100px; height:30px;">수정</button>
                    </div>
                <br>
                    <div class="email">
                        <p>이메일</p>
                        <input placeholder="tassadar@aiur.com"
                        style="width:200px; height:30px;">
                        <button class="editbutton" style="width:100px; height:30px;">수정</button>
                    </div>
                </div>
                <br>
                <div class="lower">
                    <div class="password">
                         <p>비밀번호</p>
                         <input placeholder="123546789"
                         style="width:200px; height:30px;">
                         <button class="editbutton" style="width:100px; height:30px;">수정</button>
                    </div>
                <br>
                    <div class="address">
                         <p>주소</p>
                         <input placeholder="경기도 수원시"
                         style="width:200px; height:30px;">
                         <button class="editbutton" style="width:100px; height:30px;" >수정</button>
                    </div>
                </div>
                <br>
                <div class="introduction">
                    <div class="intro">
                        <p>한줄소개</p>
                        <input placeholder="난 백엔드를 경험한 적이 없네"
                        style="width:544px; height: 30px;">
                        <button class="editbutton" style="width:100px; height:30px;">수정</button>
                    </div>
                </div>
                <br>
                <div class="caption">
                    <h4 class="caption1">내가 쓴 게시글</h4>
                    <br>
                    <h4 class="caption2">내가 쓴 댓글</h4>
                </div>
                <div class="recents">
                    <div class="recentlyRegisteredPosts">
                        <div class="title"><p>2차프로젝트 ㅈㄴ어려워</p></div>
                        <div class="title"><p>난 백엔드를 경험한 적이 없네.</p></div>
                        <div class="title"><p>미친 소리!</p></div>
                        <div class="title"><p>안돼! 이런 백엔드는! 난 감당할 수 없어! 멈춰!</p></div>
                        <div class="title"><p>가.. 짐.. 어서</p></div>
                    </div>

                    <div class="recentlyRegisteredComments">
                        <div class="title"><p>야!!!!!!</p></div>
                        <div class="title"><p>개짖는</p></div>
                        <div class="title"><p>소리좀</p></div>
                        <div class="title"><p>안나게</p></div>
                        <div class="title"><p>해라</p></div>
                    </div>
                </div>
    </div>
</body>
</html>
