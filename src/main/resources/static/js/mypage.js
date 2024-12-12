//마이페이지
// 수정버튼 클릭 이벤트 리스너
/*$(document).ready(function() {
    $("#edit1").on("click", function() {
        alert("닉네임이 수정되었습니다");
        $.ajax({
            type: "GET",
            url: "/mypage/updatenickname", data:(newNickname)
            contentType: "application/json; charset=UTF-8",
            success: function(data) {
                alert(data);
                alert(JSON.stringify(data));
                alert('성공');
            }
        });
    });*/

$(document).ready(function() {
    $("#edit1").on("click", function() {
        var newNickname = $('#nicknameInput').val();
        var userId = $('#userId').val();

        $.ajax({
            type: "GET",
            url: "/mypage/updateNickname",
            data: {
                userId: userId,
                newNickname: newNickname
            },
            success: function(data) {
                alert(data);
                $('#nicknameInput').val(newNickname);
            },
            error: function(xhr, status, error) {
                alert('오류: ' + error);
            }
        });
    });
});





    $("#edit2").on("click", function() {
        alert("이메일이 수정되었습니다");
    });

    $("#edit3").on("click", function() {
        alert("비밀번호가 수정되었습니다");
    });

    $("#edit4").on("click", function() {
        alert("주소가 수정되었습니다");
    });

    $("#edit5").on("click", function() {
        alert("한줄소개가 수정되었습니다");
    });
});
