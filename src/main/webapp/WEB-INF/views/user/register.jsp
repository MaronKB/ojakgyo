<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MRKB
  Date: 24. 11. 25.
  Time: 오후 3:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ko">
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>회원가입</title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/>"/>
        <script src="<c:url value='/js/register.js'/>"></script>
        
        <style>
            #memberwindow {
                width:400px;
                height:600px;
                border:1px solid black;
                border-radius: 8px;
                position: relative;
                margin:auto;
                top:100px;
            }
            #logoimage {
                background-image: url('/images/ojakgyo_logo_1000_320.png');
                position: relative;
                margin: auto;
                top:10px;
                width:300px;
                height:180px;
                object-fit: cover;
                background-position: center;
                background-repeat: no-repeat; 
                background-size: contain;
            }

            #layout1 {
                display: flex;
            }

            #layout1-input {
                position: relative;
                top:13px;
                right: 60px;
                width:200px;
            }

            #r_id, #r_nickname, #r_password, #r_passwdcheck, #r_email {
                margin: 6px;
                width:200px;
                height:30px;
                border:1px solid black;
                color:black;
                position: relative;
            }

            #layout1-text {
                position: relative;
                right:50px;
                top:3px;
                text-align: right;
                width: 200px;
            }

            #layout1-text p {
              margin: 21px;
              font-size: 20px;
            }

            #layout2 {
              height: 50px;
              width: 400px;
              position: relative;
              left: 60px;
              top:30px;
            }

            #consentinfo, #consentad{
              transform: scale(1.5);
              margin: 10px;
            }

            #accession-button {
              border-radius: 8px;
              display: flex;
              justify-content: center;
              text-align: center;
              width:300px;
              height:60px;
              border:1px solid black;
              position: relative;
              color: black;
              top:60px;
              font-size:30px;
              margin:auto;
            }

            #accession-button:hover{
              color: white;
              background: var(--sub-color);
            }

            #randing-button {
              border-radius: 8px;
              display: flex;
              justify-content: center;
              position: relative;
              font-size:20px;
              top: 100px;
              right: 50px;
              width: 100px;
              height: 40px;
              border: 1px solid black;
              margin-left: auto; 
            }

            #randing-button:hover{
              color: white;
              background: var(--sub-color);
            }

            /* < 동의 모달 창 */

            .modal1 {
                display: none; 
                position: fixed;
                top: 0px; /* 상단 위치 */
                left: 0px; /* 왼쪽 위치 */
                width: 100%; /* 전체 너비 */
                height: 100%; /* 전체 높이 */
                background-color: rgba(0, 0, 0, 0.1); /* 배경 색 */
                z-index: 1; /* 모달의 우선순위 */
            }

            .modal-content1 {
                background-color: white;
                position: relative;
                bottom: 30px;
                margin: 10% auto; /* 수직 중앙 배치 */
                padding: 20px;
                border-radius: 5px;
                width: 80%;
                max-width: 500px;
                overflow-y: auto; /* 내용이 길어지면 세로 스크롤 가능 */
            }

            .close1 {
                color: #aaa;
                font-size: 28px;
                font-weight: bold;
                position: absolute;
                top: 10px; /* 상단 여백 */
                right: 25px; /* 오른쪽 여백 */
                background: none;
                border: none;
            }

            .close1:hover,
            .close1:focus {
                color: black;
                text-decoration: none;
                cursor: pointer;
            }

            /* 동의 모달 창 > */

        </style>
    </head>
    <body> 
      <jsp:include page="/WEB-INF/views/includes/header.jsp"/>
      <form action="<c:url value='/user/register' />" method="POST">  
        <div id="memberwindow">
            <div id="logoimage"></div>
            <div id="layout1">
                <div id="layout1-text">
                    <p>아이디</p>
                    <p>비밀번호</p>
                    <p>비밀번호 확인</p>
                    <p>닉네임</p>
                    <p>이메일</p>
                </div>
                <div id="layout1-input">
                    <input id="r_id" name="userId" type="text" required="required"/>
                    <input id="r_password" name="password" type="password" required="required"/>
                    <input id="r_passwdcheck" name="passwordCheck" type="password" required="required" />
                    <input id="r_nickname" name="nickname" type="text" required="required" />
                    <input id="r_email" name="email" type="email" required="required"/>
                </div> 
            </div>   
            <div id="layout2">
                <p>
                    <input id="consentinfo" name="terms" type="checkbox" required />
                    <a href="javascript:void(0);" id="termsLink" style="text-decoration: underline; color: #0066cc;" 
                       onmouseover="this.style.color='#ff6600'" onmouseout="this.style.color='#0066cc'">이용약관</a> 및 
                    <a href="javascript:void(0);" id="privacyLink" style="text-decoration: underline; color: #0066cc;" 
                       onmouseover="this.style.color='#ff6600'" onmouseout="this.style.color='#0066cc'">개인정보 취급방침</a>에 동의
                </p>
                <p><input id="consentad" name="receiveAd" type="checkbox" /> 광고성 이메일 수신 동의</p>
            </div>
            <div id="accession">
                <input id="accession-button" value="가입하기" type="submit" />
            </div>
        </div>
    </form>
</body>
      <!-- 시작 홈 버튼 -->
        <div>
          <button id="randing-button" onclick="window.location.href='<c:url value="/"/>';">
          처음으로
          </button>
        </div>


      <!-- 이용약관 모달 -->
      <div id="termsModal" class="modal1">
        <div class="modal-content1">
            <button class="close1" id="closeTermsModal">&times;</button>
            <h1>이용약관</h1>
            <br>
            <div id="termsContent">
              <h3>1. 서비스 이용 개요</h3>
              <br>
               <p style="font-size:16px; letter-spacing: 1px;">
                본 약관은 커뮤니티 서비스의 사용에 관한 규칙을 정의하며, 
                사용자는 서비스 이용을 통해 본 약관에 동의한 것으로 간주됩니다. 
                커뮤니티는 사용자가 온라인에서 의견을 교환하고 정보를 공유할 수 있는 공간을 제공하며, 
                해당 서비스의 사용자는 본 약관을 준수해야 합니다.
               </p>
              <br>
               <h3>2. 이용자 의무 </h3>
                <br>
              <p style="font-size:16px; letter-spacing: 1px;">
                이용자는 부적절한 게시물(욕설, 불법 내용 등)을 올리지 않아야 하며, 이를 위반할 경우 서비스 제공자는 경고나 제재를 할 수 있습니다.
                사용자는 타인의 개인정보를 보호하고, 불법적인 행위를 하지 않도록 주의해야 합니다.
              </p>
               <br>
                <h3>3. 서비스 제공자의 권리 </h3>
                <br>
                <p style="font-size:16px; letter-spacing: 1px;">
                커뮤니티 운영자는 서비스를 제공하며, 정책을 수정할 수 있는 권리를 가집니다.
                운영자는 사용자로부터 제공받은 정보에 대해 관리 및 보호 책임이 있습니다.
               </p>
               <br>
                <h3>4. 쿠키 사용 </h3>
                <br>
                <p style="font-size:16px; letter-spacing: 1px;">
                컨웹사이트 이용자의 편의를 위해 쿠키를 사용하여 정보 기록을 저장합니다.
                사용자는 브라우저 설정을 통해 쿠키를 거부할 수 있습니다.
               </p>
               <br>
                <h3>5. 면책 조항 </h3>
                <br>
                <p style="font-size:16px; letter-spacing: 1px;">
                커뮤니티는 이용자가 서비스를 이용하는 동안 발생하는 문제에 대해 책임을 지지 않습니다.
                사용자는 본 서비스 이용에 따른 모든 책임을 부담합니다.
               </p>
               <br>
                <h3>6. 법적 책임 </h3>
                <br>
                <p style="font-size:16px; letter-spacing: 1px;">
                서비스 제공에 있어 커뮤니티의 귀책 사유가 아닌 경우, 커뮤니티는 손해에 대한 책임을 지지 않습니다.
               </p>
            </div>
        </div>
      </div>

      <!-- 개인정보 취급방침 모달 -->
      <div id="privacyModal" class="modal1">
        <div class="modal-content1">
            <button class="close1" id="closePrivacyModal">&times;</button>
            <h2>개인정보 취급방침</h2>
            <br>
            <div id="privacyContent">
              <h3>1. 개인정보의 수집 항목</h3>
              <br>
               <p style="font-size:16px; letter-spacing: 1px;">
                회사는 사용자가 서비스를 이용하는 과정에서 다음과 같은 개인정보를 수집할 수 있습니다.
               </p>
               <br>
              <p style="font-size:12px; letter-spacing: 1px;">
                - 필수항목 : 이메일주소, 비밀번호, 가입일시
              </p>
              <p style="font-size:12px; letter-spacing: 1px;">
                - 선택항목 : 프로필 사진
              </p>
              <p style="font-size:12px; letter-spacing: 1px;">
                - 자동수집항목 :IP 주소, 로그인 기록, 쿠키 정보, 접속 로그, 서비스 이용 기록
              </p>
              <br>
              <h3>2. 개인정보 수집 및 이용 목적</h3>
              <br>
               <p style="font-size:16px; letter-spacing: 1px;">
                회사는 사용자가 서비스를 이용하는 과정에서 다음과 같은 개인정보를 수집할 수 있습니다.
               </p>
               <br>
              <p style="font-size:12px; letter-spacing: 1px;">
                - 이메일 서비스 제공: 이메일 발송 및 수신, 이메일 계정 관리, 비밀번호 재설정 등 서비스 제공에 필요한 절차 수행
              </p>
              <p style="font-size:12px; letter-spacing: 1px;">
                - 법적 의무 준수: 법적 요구 사항, 분쟁 해결, 고객 지원 등을 위한 개인정보 이용
              </p>
              <br>
              <h3>3. 개인정보의 보유 및 이용 기간</h3>
              <br>
               <p style="font-size:16px; letter-spacing: 1px;">
                회사는 사용자가 서비스를 이용하는 과정에서 다음과 같은 개인정보를 수집할 수 있습니다.
               </p>
               <br>
              <p style="font-size:12px; letter-spacing: 1px;">
                - 회원가입 시 수집된 개인정보: 회원 탈퇴 시까지 보유하며, 탈퇴 문의 요청 시 즉시 삭제됩니다.
              </p>
              <p style="font-size:12px; letter-spacing: 1px;">
                - 이메일 이용 기록: 서비스 제공 기간 동안 보유하며, 일정 기간 후 안전하게 삭제합니다.
              </p>
              <p style="font-size:12px; letter-spacing: 1px;">
                - 법적 의무에 따른 보유: 법률에 의해 필요한 경우, 법적 요구 기간 동안 개인정보를 보관합니다.
              </p>
            </div>
        </div>
      </div>

      <script>
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
      </script>


    </body>
</html>
