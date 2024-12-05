    // 이용약관 모달 열기
    document.getElementById('termsLink').onclick = function() {
        document.getElementById('termsModal').style.display = 'block';
    };

    // 개인정보 취급방침 모달 열기
    document.getElementById('privacyLink').onclick = function() {
        document.getElementById('privacyModal').style.display = 'block';
    };

    // 모달 닫기 (이용약관)
    document.getElementById('closeTermsModal').onclick = function() {
        document.getElementById('termsModal').style.display = 'none';
    };

    // 모달 닫기 (개인정보 취급방침)
    document.getElementById('closePrivacyModal').onclick = function() {
        document.getElementById('privacyModal').style.display = 'none';
    };