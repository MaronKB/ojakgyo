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
    const sidebar = document.getElementById('sidebar');
    sidebar.classList.toggle('open'); // 'open' 클래스를 토글하여 사이드바 열고 닫기
}


// 버튼 클릭 시 해당 내용 표시
function showContent(contentType) {
  const modalTitle = document.getElementById('modalTitle');
  const modalDescription = document.getElementById('modalDescription');

  if (contentType === 'cafe1') {
    alert("우리 카페에서는 다양한 커피와 디저트를 제공합니다. 친구와 함께 또는 혼자서 편안하게 즐길 수 있는 공간입니다.");
    modalTitle.textContent = "카페";
    modalDescription.textContent = "우리 카페에서는 다양한 커피와 디저트를 제공합니다. 친구와 함께 또는 혼자서 편안하게 즐길 수 있는 공간입니다.";
  }

}