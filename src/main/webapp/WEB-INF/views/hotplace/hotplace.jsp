<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<script src="<c:url value="/js/hotplace.js"/>"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>오작교-핫플레이스</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=East+Sea+Dokdo&family=Noto+Serif+KR:wght@200..900&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/>"/>
</head>
<body>
    <jsp:include page="/WEB-INF/views/includes/header.jsp"/>
        <div class="main">
            <div class="sidebar" id="sidebar">
                <div>
                    <h1 class="sidebartitle">카테고리 선택</h1>
                    <div class="line"></div>
                </div>
                <div class="cafe">
                    <button class="cafebutton"
                    onclick="showContent('cafe1')">카페</button>
                </div>
                <div class="line"></div>
                <div class="restaurant">
                    <button class="restaurantbutton"
                    onclick="showContent('rest1')">식당</button>
                </div>
                <div id="rest1"></h2>
                </div>
                <div class="line"></div>
                <div class="spot">
                    <button class="spotbutton"
                    onclick="showContent('spot1')">명소</button>
                </div>
                <div id="spot1"></div>
                <div class="line"></div>
                <div class="hotel">
                    <button class="hotelbutton"
                    onclick="showContent('hotel1')">숙소</button>
                </div>
                <div id="hotel1"></div>
            </div>

              <div class="content-container" id="contentContainer">
                <div class="page" id="cafe">
                  <h2>카페</h2>
                  <p>여기는 카페에 대한 설명이 들어갑니다.</p>
                </div>
                <div class="page" id="restaurant">
                  <h2>레스토랑</h2>
                  <p>여기는 레스토랑에 대한 설명이 들어갑니다.</p>
                </div>
                <div class="page" id="spot">
                  <h2>관광지</h2>
                  <p>여기는 관광지에 대한 설명이 들어갑니다.</p>
                </div>
                <div class="page" id="hotel">
                  <h2>호텔</h2>
                  <p>여기는 호텔에 대한 설명이 들어갑니다.</p>
                </div>

              </div>
            <div class="regionSelect">
                <div>
                    <h1 class="sidebartitle">지역 선택</h1>
                    <div class="line"></div>
                </div>
                <form class="seoul">
                    <select class="regions">
                        <option disabled selected>서울특별시</option>
                        <option value="강동구">강동구</option>
                        <option value="강서구">강서구</option>
                        <option value="강남구">강남구</option>
                    </select>
                </form>
                <div class="line"></div>
                <form class="ggd">
                    <select class="regions">
                        <option value="경기도">경기도</option>
                        <option value="수원시">수원시</option>
                        <option value="성남시">성남시</option>
                    </select>
                </form>
                <div class="line"></div>
                <form class="gwd">
                    <select class="regions">
                        <option value="강원도">강원도</option>
                        <option value="춘천시">춘천시</option>
                        <option value="원주시">원주시</option>
                    </select>
                </form>
                <div class="line"></div>
                <form class="ccbd">
                    <select class="regions">
                        <option value="충청북도">충청북도</option>
                        <option value="충주시">충주시</option>
                        <option value="청주시">청주시</option>
                    </select>
                </form>
                <div class="line"></div>
                <form class="ccnd">
                    <select class="regions">
                        <option value="충청남도">충청남도</option>
                        <option value="천안시">천안시</option>
                        <option value="공주시">공주시</option>
                    </select>
                </form>
                <div class="line"></div>
                <form class="jlbd">
                    <select class="regions">
                        <option value="전라북도">전라북도</option>
                        <option value="전주시">전주시</option>
                        <option value="군산시">군산시</option>
                    </select>
                </form>
                <div class="line"></div>
                <form class="jlnd">
                    <select class="regions">
                        <option value="전라북도">전라남도</option>
                        <option value="목포시">목포시</option>
                        <option value="여수시">여수시</option>
                    </select>
                </form>
                <div class="line"></div>
                <form class="gsbd">
                    <select class="regions">
                        <option value="경상북도">경상북도</option>
                        <option value="포항시">포항시</option>
                        <option value="경주시">경주시</option>
                    </select>
                </form>
                <div class="line"></div>
                <form class="gsnd">
                    <select class="regions">
                        <option value="경상남도">경상남도</option>
                        <option value="천안시">천안시</option>
                    </select>
                </form>
                <div class="line"></div>
                <button onclick="toggleSidebar()" class="movebar">카테고리 보기</button>
            </div>
        </div>
</body>
</html>
