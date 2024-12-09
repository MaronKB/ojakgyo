//마이페이지
// 버튼 클릭 이벤트 리스너 추가
/*
$(document).ready(function() {
    $("#editbutton").on("click", function() {
        alert("ajax 통신");
*/

/*        $.ajax()*/

       /* type: "GET",
        url: "/code/list",
        contentType: "application/json; charset=UTF-8",
        success : function(data) {
            alert(성공);
            alert(JSON.stringify(data));

       },
       error: function(xhr, status, error) {
            // 요청이 실패하면 실행되는 콜백 함수
            alert("에러 발생: " + error); // 에러 메시지 출력
       }
    });*/


function btn(editbutton){
    console.log('버튼이 클릭되었습니다');
};