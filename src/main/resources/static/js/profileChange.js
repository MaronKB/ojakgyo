    $("#profile-img-btn").click(() => {
        // 파일 업로드 실행
        $("#profile-img-input").click();
    });

     $("#profile-img-input").change(function() {
                const file = this.files[0]; // 선택된 파일
                if (file) {
                    const reader = new FileReader();

                    reader.onload = function(e) {
                        // 이미지 미리보기 업데이트
                        $("#profile-img").attr("src", e.target.result);
                    };

                    // 파일 읽기
                    reader.readAsDataURL(file);
                }
     });