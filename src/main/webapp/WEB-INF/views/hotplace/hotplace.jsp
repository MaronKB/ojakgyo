<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<script src="<c:url value="/js/hotplace.js"/>"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>핫플레이스</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/>"/>
</head>
<body>
    <jsp:include page="/WEB-INF/views/includes/header.jsp"/>
        <div class="main">
            <div class="sidebar">


                <div class="sidebarcontent">
                    <div class="cafe">
                        <button class="cafebutton"
                        onclick="showContent('cafe1')">카페</button>
                    </div>
                    <div id="cafe1" class="cafe1">
                        <h2 class="cafetitle">카페버튼클릭</h2>
                    </div>
                </div>

                <div class="sidebarcontent">
                    <div class="restaurant">
                        <button class="restaurantbutton"
                        onclick="showContent('rest1')">식당</button>
                    </div>
                    <div id="rest1">
                        <h2>식당버튼클릭</h2>
                    </div>
                </div>

                <div class="sidebarcontent">
                    <div class="spot">
                        <button class="spotbutton"
                        onclick="showContent('spot1')">명소</button>
                    </div>
                    <div id="spot1">
                        <h2>명소버튼클릭</h2>
                    </div>
                </div>

                <div class="sidebarcontent">
                    <div class="hotel">
                        <button class="hotelbutton"
                        onclick="showContent('hotel1')">숙소</button>
                    </div>
                    <div id="hotel1">
                        <h2>숙소버튼클릭</h2>
                    </div>
                </div>

            </div>

            <div class="regionSelect">
                <form class="seoul">
                    <select class="regions">
                        <option disabled selected>서울특별시</option>
                        <option value="강동구">강동구</option>
                        <option value="강서구">강서구</option>
                        <option value="강남구">강남구</option>
                        <option value="강북구">강북구</option>
                        <option value="도봉구">도봉구</option>
                        <option value="노원구">노원구</option>
                        <option value="성북구">성북구</option>
                        <option value="은평구">은평구</option>
                        <option value="중랑구">중랑구</option>
                        <option value="종로구">종로구</option>
                        <option value="동대문구">동대문구</option>
                        <option value="서대문구">서대문구</option>
                        <option value="중랑구">중랑구</option>
                        <option value="중구">중구</option>
                        <option value="마포구">마포구</option>
                        <option value="성동구">성동구</option>
                        <option value="광진구">광진구</option>
                        <option value="용산구">용산구</option>
                        <option value="영등포구">영등포구</option>
                        <option value="송파구">송파구</option>
                        <option value="서초구">서초구</option>
                        <option value="구로구">구로구</option>
                        <option value="동작구">동작구</option>
                        <option value="양천구">양천구</option>
                        <option value="금천구">금천구</option>
                    </select>
                </form>
                <form class="ggd">
                    <select class="regions">
                        <option value="경기도">경기도</option>
                        <option value="수원시">수원시</option>
                        <option value="성남시">성남시</option>
                        <option value="용인시">용인시</option>
                        <option value="안양시">안양시</option>
                        <option value="안산시">안산시</option>
                        <option value="과천시">과천시</option>
                        <option value="광명시">광명시</option>
                        <option value="광주시">광주시</option>
                        <option value="군포시">군포시</option>
                        <option value="부천시">부천시</option>
                        <option value="시흥시">시흥시</option>
                        <option value="김포시">김포시</option>
                        <option value="안성시">안성시</option>
                        <option value="오산시">오산시</option>
                        <option value="의왕시">의왕시</option>
                        <option value="이천시">이천시</option>
                        <option value="평택시">평택시</option>
                        <option value="하남시">하남시</option>
                        <option value="화성시">화성시</option>
                        <option value="여주시">여주시</option>
                        <option value="고양시">고양시</option>
                        <option value="구리시">구리시</option>
                        <option value="양주시">양주시</option>
                        <option value="파주시">파주시</option>
                        <option value="포천시">포천시</option>
                        <option value="남양주시">남양주시</option>
                        <option value="의정부시">의정부시</option>
                        <option value="양평군">양평군</option>
                        <option value="가평군">가평군</option>
                        <option value="연천군">연천군</option>
                    </select>
                </form>
                <form class="gwd">
                    <select class="regions">
                        <option value="강원도">강원도</option>
                        <option value="춘천시">춘천시</option>
                        <option value="원주시">원주시</option>
                        <option value="강릉시">강릉시</option>
                        <option value="동해시">동해시</option>
                        <option value="태백시">태백시</option>
                        <option value="속초시">속초시</option>
                        <option value="삼척시">삼척시</option>
                        <option value="홍천군">홍천군</option>
                        <option value="횡성군">횡성군</option>
                        <option value="영월군">영월군</option>
                        <option value="평창군">평창군</option>
                        <option value="정선군">정선군</option>
                        <option value="철원군">철원군</option>
                        <option value="화천군">화천군</option>
                        <option value="양구군">양구군</option>
                        <option value="인제군">인제군</option>
                        <option value="고성군">고성군</option>
                        <option value="양양군">양양군</option>
                    </select>
                </form>

                <form class="ccbd">
                    <select class="regions">
                        <option value="충청북도">충청북도</option>
                        <option value="수원시">충주시</option>
                        <option value="청주시">청주시</option>
                        <option value="제천시">제천시</option>
                        <option value="단양군">단양군</option>
                        <option value="음성군">음성군</option>
                        <option value="괴산군">괴산군</option>
                        <option value="진천군">진천군</option>
                        <option value="증평군">증평군</option>
                        <option value="보은군">보은군</option>
                        <option value="옥천군">옥천군</option>
                        <option value="영동군">영동군</option>
                    </select>
                </form>

                <form class="ccnd">
                    <select class="regions">
                        <option value="충청남도">충청남도</option>
                        <option value="천안시">천안시</option>
                        <option value="공주시">공주시</option>
                        <option value="보령시">보령시</option>
                        <option value="아산시">아산시</option>
                        <option value="서산시">서산시</option>
                        <option value="논산시">논산시</option>
                        <option value="계룡시">계룡시</option>
                        <option value="당진시">당신시</option>
                        <option value="금산군">금산군</option>
                        <option value="부여군">부여군</option>
                        <option value="서천군">서천군</option>
                        <option value="청양군">청양군</option>
                        <option value="홍성군">홍성군</option>
                        <option value="태안군">예산군</option>
                    </select>
                </form>

                <form class="jlbd">
                    <select class="regions">
                        <option value="전라북도">전라북도</option>
                        <option value="전주시">전주시</option>
                        <option value="군산시">군산시</option>
                        <option value="익산시">익산시</option>
                        <option value="정읍시">정읍시</option>
                        <option value="남원시">남원시</option>
                        <option value="김제시">김제시</option>
                        <option value="완주군">완주군</option>
                        <option value="진안군">진안군</option>
                        <option value="무주군">무주군</option>
                        <option value="장수군">장수군</option>
                        <option value="임실군">임실군</option>
                        <option value="순창군">순창군</option>
                        <option value="고창군">고창군</option>
                        <option value="부안군">부안군</option>
                    </select>
                </form>

                <form class="jlmd">
                    <select class="regions">
                        <option value="전라북도">전라남도</option>
                        <option value="목포시">목포시</option>
                        <option value="여수시">여수시</option>
                        <option value="순천시">순천시</option>
                        <option value="나주시">나주시</option>
                        <option value="광양시">광양시</option>
                        <option value="담양군">담양군</option>
                        <option value="곡성군">곡성군</option>
                        <option value="구례군">구례군</option>
                        <option value="고흥군">고흥군</option>
                        <option value="보성군">보성군</option>
                        <option value="화순군">화순군</option>
                        <option value="장흥군">장흥군</option
                        <option value="장흥군">장흥군</option>
                        <option value="강진군">강진군</option>
                        <option value="해남군">해남군</option>
                        <option value="영암군">영암군</option>
                        <option value="무안군">무안군</option>
                        <option value="함평군">함평군</option>
                        <option value="영광군">영광군</option>
                        <option value="장성군">장성군</option>
                        <option value="완도군">완도군</option>
                        <option value="진도군">진도군</option>
                        <option value="신안군">신안군</option>
                    </select>
                </form>

                <form class="gsbd">
                    <select class="regions">
                        <option value="경상북도">경상북도</option>
                        <option value="포항시">포항시</option>
                        <option value="경주시">경주시</option>
                        <option value="김천시">김천시</option>
                        <option value="안동시">안동시</option>
                        <option value="구미시">구미시</option>
                        <option value="영주시">영주시</option>
                        <option value="상주시">상주시</option>
                        <option value="문경시">문경시</option>
                        <option value="경산시">경산시</option>
                        <option value="의성군">의성군</option>
                        <option value="청송군">청송군</option>
                        <option value="영양군">영양군</option>
                        <option value="영덕군">영덕군</option>
                        <option value="청도군">청도군</option>
                        <option value="고령군">고령군</option>
                        <option value="성주군">성주군</option>
                        <option value="칠곡군">칠곡군</option>
                        <option value="예천군">예천군</option>
                        <option value="봉화군">봉화군</option>
                        <option value="울진군">울진군</option>
                        <option value="울릉군">울릉군</option>
                    </select>
                </form>

                <form class="gsnd">
                    <select class="regions">
                        <option value="경상남도">경상남도</option>
                        <option value="천안시">천안시</option>
                    </select>
                </form>
        </div>

        <div>
            <ul id="categoryList">
                <li><a class="categoryItem" data-contents="section1">카테고리1</a></li>
                <li><a class="categoryItem" data-contents="section2">카테고리2</a></li>
                <li><a class="categoryItem" data-contents="section3">카테고리3</a></li>
                <li><a class="categoryItem" data-contents="section4">카테고리4</a></li>
            </ul>
        </div>

        <div class="contents" id="section1">
        태사다르: 난 백엔드를 경험한 적이 없네, 제라툴. 앞으로도 그럴 게야.
        </div>

        <div class="contents" id="section2">
        제라툴: 안 돼! 이런 백엔드는! 난 감당할 수 없어. 멈춰!
        </div>

</body>
</html>
