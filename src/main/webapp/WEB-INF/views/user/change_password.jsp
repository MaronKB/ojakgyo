<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>비밀번호 변경</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/index.css'/>"/>
</head>
<body>
<main id="login-main" class="max">
    <form id="login-form" onsubmit="changePassword(event)">
        <a id="login-forgot-password" href="<c:url value='/find_password'/>">아이디/비밀번호 찾기</a>
        <div id="login-logo-container">
            <img id="login-logo" src="<c:url value='/images/ojakgyo_logo_1000_500.png'/>" alt="로고"/>
        </div>
        <!-- 새 비밀번호 입력 필드 -->
        <div class="login-input-container">
            <label for="newPassword"><i class="fa-solid fa-key"></i></label>
            <input type="password" id="newPassword" name="newPassword" placeholder="새 비밀번호를 입력하세요" required/>
        </div>
        <!-- 비밀번호 확인 입력 필드 -->
        <div class="login-input-container">
            <label for="confirmPassword"><i class="fa-solid fa-key"></i></label>
            <input type="password" id="confirmPassword" name="confirmPassword" placeholder="비밀번호 확인" required/>
        </div>
        <button id="login-submit" type="submit">비밀번호 변경</button>
    </form>
    <a id="login-back" href="<c:url value='/'/>"><i class="fa-solid fa-backward"></i> 돌아가기</a>
</main>

<script>
    // 비밀번호 변경 로직
    function changePassword(event) {
        event.preventDefault();

        const newPassword = document.getElementById('newPassword').value;
        const confirmPassword = document.getElementById('confirmPassword').value;

        if (newPassword !== confirmPassword) {
            alert("비밀번호가 일치하지 않습니다.");
            return;
        }

        // 서버로 요청 보내기 (비밀번호 변경)
        fetch('/change/change_password', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                userId: 'testUser', // 여기에 실제 사용자 ID를 전달하도록 수정 필요
                newPassword: newPassword
            })
        })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                alert("비밀번호가 성공적으로 변경되었습니다.");
                window.location.href = '/login';
            } else {
                alert(data.message || "비밀번호 변경에 실패했습니다. 다시 시도해주세요.");
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert("서버 오류가 발생했습니다. 다시 시도해주세요.");
        });
    }
</script>

</body>
</html>
