// 페이지 진입 시 기본 값
window.addEventListener('DOMContentLoaded', function() {
  showContent('cafe');
});

function showContent(content) {
  var contentA = document.getElementById("cafe1");
  var contentB = document.getElementById("rest1");

  // 내용 숨김
  contentA.style.display = "none";
  contentB.style.display = "none";

  // 선택한 내용 보이기
  if (content === "cafe") {
    contentA.style.display = "block";
  } else if (content === "rest") {
    contentB.style.display = "block";
  }
}