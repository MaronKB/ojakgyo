// 페이지가 로드된 후 기본 콘텐츠 설정
window.addEventListener('DOMContentLoaded', function() {
  showContent('none');  // 기본적으로 표시 x
});

// 콘텐츠를 전환하는 함수
function showContent(content) {
// 모든 콘텐츠를 숨기기
var allContents = document.querySelectorAll('div[id^="cafe"], div[id^="rest"], div[id^="spot"], div[id^="hotel"]');
allContents.forEach(function(contentDiv) {
contentDiv.style.display = "none";
});

// 클릭한 버튼에 맞는 콘텐츠만 보이기
  var selectedContent = document.getElementById(content);
  if (selectedContent) {
    selectedContent.style.display = "block";  // 선택된 콘텐츠만 보이게 하기
  }
}



/*카테고리 1,2,3,4*//*
// 카테고리 구분
var activeSection = '';

// 카테고리 항목 클릭 이벤트
document.querySelectorAll('.categoryItem').forEach(function(item) {
    item.addEventListener('click', function() {
        var selectedSection = item.getAttribute('data-contents');

        // 선택된 섹션이 이미 활성화된 섹션과 다를 경우에만 처리
        if (selectedSection !== activeSection) {
            // 이전 활성화된 섹션 숨기기
            if (activeSection) {
                document.getElementById(activeSection).style.display = 'none';
            }

            // 선택된 섹션 표시 및 활성화 처리
            document.getElementById(selectedSection).style.display = 'block';
            activeSection = selectedSection;

            // 모든 카테고리의 강조 효과 제거
            document.querySelectorAll('.categoryItem').forEach(function(link) {
                link.classList.remove('active');
            });

            // 현재 클릭한 카테고리에 강조 효과 추가
            item.classList.add('active');
        }
    });
});*/

document.addEventListener('DOMContentLoaded', function() {
    // 페이지가 로드되면 첫 번째 카테고리 항목을 자동으로 클릭
    document.querySelector('.categoryItem').click();
});

// 카테고리 항목 클릭 이벤트
document.querySelectorAll('.categoryItem').forEach(function(item) {
    item.addEventListener('click', function() {
        alert("alert");
        var selectedSection = item.getAttribute('data-contents'); // 클릭한 항목에 해당하는 section ID 얻기

        // 모든 섹션을 숨기고, 'active' 클래스를 제거
        document.querySelectorAll('.contents').forEach(function(section) {
            section.classList.remove('active');
        });

        // 선택된 섹션에만 'active' 클래스를 추가하여 보이게 함
        document.getElementById(selectedSection).classList.add('active');

        // 모든 카테고리 항목에서 'active' 클래스를 제거하고 클릭된 항목에 'active' 클래스를 추가
        document.querySelectorAll('.categoryItem').forEach(function(categoryItem) {
            categoryItem.classList.remove('active');
        });
        item.classList.add('active');
    });
});






