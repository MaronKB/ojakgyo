window.onload = function() {
    // 이용약관 모달 열기
    document.getElementById('termsLink').onclick = function() {
        document.getElementById('termsModal').style.display = 'block';
    };

    // 개인정보 취급방침 모달 열기
    document.getElementById('privacyLink').onclick = function() {
        document.getElementById('privacyModal').style.display = 'block';
    };

    // URL에서 success 파라미터를 가져옵니다.
    const success = new URLSearchParams(window.location.search).get("success");

    // success가 true 또는 false일 때 모달을 표시
    if (success === "true" || success === "false") {
        var modal = document.getElementById("myModal");
        modal.style.display = "block";  // 모달을 표시합니다.

        // 2초 후에 모달을 자동으로 닫고 "/login"로 리다이렉트
        setTimeout(function() {
            closeModal(modal); // 모달 닫기
            window.location.href = "/login";  // "/login"로 리다이렉트
        }, 2000);  // 2초 (2000ms)
    }

    // 모달 닫기 버튼을 클릭하면 모달을 닫음
    var closeBtn = document.getElementsByClassName("close");
    for (let i = 0; i < closeBtn.length; i++) {
        closeBtn[i].onclick = function() {
            var modal = closeBtn[i].closest('.modal');
            closeModal(modal); // 닫을 모달을 찾고 닫기
        }
    }

    // 사용자가 모달 외부를 클릭하면 모달을 닫음
    window.onclick = function(event) {
        var modal = event.target;
        if (modal.classList.contains("modal")) {
            closeModal(modal); // 클릭된 모달 닫기
        }
    };

    // 이용약관 모달 닫기
    document.getElementById('closeTermsModal').onclick = function() {
        document.getElementById('termsModal').style.display = 'none';
    };

    // 개인정보 취급방침 모달 닫기
    document.getElementById('closePrivacyModal').onclick = function() {
        document.getElementById('privacyModal').style.display = 'none';
    };

    // 모달 닫기 함수
    function closeModal(modal) {
        modal.style.display = "none";
    }
};

// 중복 체크
var userIdChecked = false;
var emailChecked = false;
// 아이디 중복 체크
function checkUserId() {
    var userId = document.getElementById('r_id').value;
    if (userId) {
        $.ajax({
            url: '/user/checkUserId.do',
            type: 'POST',
            data: { userId: userId },
            dataType: 'json',
            success: function(response) {
                if (response.result === 'available') {
                    alert("사용 가능한 아이디입니다.");
                    userIdChecked = true;  // 아이디 중복 체크 성공
                } else {
                    alert("이미 존재하는 아이디입니다.");
                    userIdChecked = false;  // 아이디 중복 체크 실패
                }
            },
            error: function(xhr, status, error) {
                alert("아이디 중복 체크 실패");
                userIdChecked = false;
            }
        });
    } else {
        alert("아이디를 입력해주세요.");
        userIdChecked = false;
    }
}

// 이메일 중복 체크
function checkEmail() {
    var email = document.getElementById('r_email').value;
    if (email) {
        $.ajax({
            url: '/user/checkEmail.do',
            type: 'POST',
            data: { email: email },
            dataType: 'json',
            success: function(response) {
                if (response.result === 'available') {
                    alert("사용 가능한 이메일입니다.");
                    emailChecked = true;  // 이메일 중복 체크 성공
                } else {
                    alert("이미 존재하는 이메일입니다.");
                    emailChecked = false;  // 이메일 중복 체크 실패
                }
            },
            error: function(xhr, status, error) {
                alert("이메일 중복 체크 실패");
                emailChecked = false;
            }
        });
    } else {
        alert("이메일을 입력해주세요.");
        emailChecked = false;
    }
}

// 가입하기 버튼 클릭 시 중복 체크 여부 확인
function validateForm() {
    if (!userIdChecked) {
        alert("아이디 중복 체크를 완료해주세요.");
        return false; // 제출 방지
    }
    if (!emailChecked) {
        alert("이메일 중복 체크를 완료해주세요.");
        return false; // 제출 방지
    }
    return true; // 제출 허용
}