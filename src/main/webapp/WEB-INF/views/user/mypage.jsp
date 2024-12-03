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
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/mypage/mypage.css"/>"/>
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
    <div class="profilepicturecontainer">
    <br>
        <img id="profile-img-btn" src="https://i1.sndcdn.com/avatars-000373392764-zp0p80-t200x200.jpg"
            class="defaultprofilepicture">
        <form>
            <input id="profile-img-input" type="file" class="my_hidden" />
        </form>
    </div>
    <br>
    <div class="nickname">
        <input><placeholder=닉네임></input><button>닉네임수정하기</button>
    </div>
    <br>
    <div class="password">
         <input><placeholder=닉네임></input><button>비밀번호 수정하기</button>
    </div>
    <br>
    <div class="address">
         <input><placeholder=닉네임></input><button>주소 수정하기</button>
    </div>
</body>
</html>
