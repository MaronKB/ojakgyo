<%--
  Created by IntelliJ IDEA.
  User: MRKB
  Date: 24. 11. 25.
  Time: 오후 3:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="ojakgyo/src/main/resources/static/css/mypage/mypage.css">
<head>
    <title>마이페이지</title>
</head>
<body>
    <div class="profilepicturecontainer">
        <img id="profile-img-btn" src="https://i1.sndcdn.com/avatars-000373392764-zp0p80-t200x200.jpg"
            class="defaultprofilepicture">
        <form>
            <input id="profile-img-input" type="file" class="my_hidden" />
        </form>
    </div>

    <div class="nickname">
        <input><placeholder=닉네임></input><button>닉네임수정하기</button>
    </div>

    <div class="비밀번호">
         <input><placeholder=닉네임></input><button>닉네임수정하기</button>
    </div>
</body>
</html>
