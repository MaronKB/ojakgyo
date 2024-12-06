// 페이지가 로드된 후 기본 콘텐츠 설정
window.addEventListener('DOMContentLoaded', function() {
  showContent('none');  // 기본적으로 표시 x
});

// 콘텐츠를 전환하는 함수
function showContent(content) {
    // 모든 콘텐츠를 숨기기
    var allContents = document.querySelectorAll('div[id^="cafe"], div[id^="rest"], div[id^="spot"], div[id^="hotel"]');
    allContents.forEach(function(contentDiv) {
        contentDiv.style.display = "none";  // 모든 콘텐츠 숨기기
    });

    // 클릭한 버튼에 맞는 콘텐츠만 보이기
    if (content !== 'none') {
        var selectedContent = document.getElementById(content);
        if (selectedContent) {
            selectedContent.style.display = "block";  // 선택된 콘텐츠만 보이게 하기
        }
    }
}

/*==========================================================================*/

// 사이드바 열기/닫기 토글 함수
function toggleSidebar() {
    var sidebar = document.getElementById("sidebar");

    // 사이드바가 보이면 숨기고, 숨겨져 있으면 보이게 설정
    if (sidebar.style.display === "none" || sidebar.style.display === "") {
        sidebar.style.display = "block";  // 보이게 설정
    } else {
        sidebar.style.display = "none";  // 숨기기 설정
    }
}

// 버튼 클릭 시 해당 콘텐츠 표시 함수
function showContent(contentId) {
    var content = document.getElementById(contentId);

    // 해당 콘텐츠를 보이게 설정
    content.style.display = "block";

    // 다른 콘텐츠는 숨기기
    var allContents = document.querySelectorAll('.sidebarcontent > div');
    allContents.forEach(function(item) {
        if (item.id !== contentId) {
            item.style.display = "none";
        }
    });
}
