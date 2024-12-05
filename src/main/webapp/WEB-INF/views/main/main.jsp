<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/>"/>
    <script type="text/javascript" language="javascript" src="<c:url value="/js/main/main.js"/>"></script>
    <script type="text/javascript" language="javascript" src="<c:url value="/js/juso.js"/>"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
<main id="main">
    <form id="main-form" action="${pageContext.request.contextPath}/main/result"  method="post" onsubmit="go()">
        <div id="my-location" class="location-box">
            <h3>나의 주소</h3>
            <jsp:include page="../includes/juso.jsp">
                <jsp:param name="id" value="my-location"/>
            </jsp:include>
            <div class="my-juso">
                <button class="my-juso-button" type="button" onclick="getJusoFromAccount()"><i class="fa-solid fa-upload"></i>자주 쓰는 주소</button>
                <button class="my-juso-button" type="button" onclick="window.location.href = '/mypage'"><i class="fa-solid fa-gear"></i>관리</button>
            </div>
            <div class="location-tags">
                <input type="hidden" name="location-tags" id="location-tags" class="location-tags"/>
                <input type="checkbox" name="location-tag" id="cafe" value="카페"/>
                <label for="cafe">카페</label>
                <input type="checkbox" name="location-tag" id="bakery" value="베이커리"/>
                <label for="bakery">베이커리</label>
                <input type="checkbox" name="location-tag" id="dessert" value="디저트"/>
                <label for="dessert">디저트</label>
                <input type="checkbox" name="location-tag" id="bar" value="술집"/>
                <label for="bar">술집</label>
                <input type="checkbox" name="location-tag" id="pub" value="펍"/>
                <label for="pub">펍</label>
                <input type="checkbox" name="location-tag" id="karaoke" value="노래방"/>
                <label for="karaoke">노래방</label>
                <input type="checkbox" name="location-tag" id="amusement" value="놀이공원"/>
                <label for="amusement">놀이공원</label>
                <input type="checkbox" name="location-tag" id="none0" value="빈 자리" disabled/>
                <label for="none0"></label>
                <hr/>
                <input type="checkbox" name="location-tag" id="restaurant" value="식당"/>
                <label for="restaurant">식당</label>
                <input type="checkbox" name="location-tag" id="korean" value="한식"/>
                <label for="korean">한식</label>
                <input type="checkbox" name="location-tag" id="chinese" value="중식"/>
                <label for="chinese">중식</label>
                <input type="checkbox" name="location-tag" id="japanese" value="일식"/>
                <label for="japanese">일식</label>
                <input type="checkbox" name="location-tag" id="western" value="양식"/>
                <label for="western">양식</label>
                <input type="checkbox" name="location-tag" id="fusion" value="퓨전"/>
                <label for="fusion">퓨전</label>
                <input type="checkbox" name="location-tag" id="fine-dining" value="파인다이닝"/>
                <label for="fine-dining">파인다이닝</label>
                <input type="checkbox" name="location-tag" id="vegetarian" value="채식"/>
                <label for="vegetarian">채식</label>
                <hr/>
                <input type="checkbox" name="location-tag" id="tour-spot" value="관광지"/>
                <label for="tour-spot">관광지</label>
                <input type="checkbox" name="location-tag" id="attraction" value="명소"/>
                <label for="attraction">명소</label>
                <input type="checkbox" name="location-tag" id="park" value="공원"/>
                <label for="park">공원</label>
                <input type="checkbox" name="location-tag" id="valley" value="계곡"/>
                <label for="valley">계곡</label>
                <input type="checkbox" name="location-tag" id="mountain" value="산"/>
                <label for="mountain">산</label>
                <input type="checkbox" name="location-tag" id="beach" value="해변"/>
                <label for="beach">해변</label>
                <input type="checkbox" name="location-tag" id="temple" value="종교"/>
                <label for="temple">종교</label>
                <input type="checkbox" name="location-tag" id="none1" value="빈 자리" disabled/>
                <label for="none1"></label>
                <hr/>
                <input type="checkbox" name="location-tag" id="inn" value="숙박"/>
                <label for="inn">숙박</label>
                <input type="checkbox" name="location-tag" id="hotel" value="호텔"/>
                <label for="hotel">호텔</label>
                <input type="checkbox" name="location-tag" id="motel" value="모텔"/>
                <label for="motel">모텔</label>
                <input type="checkbox" name="location-tag" id="guesthouse" value="게스트하우스"/>
                <label for="guesthouse">게스트하우스</label>
                <input type="checkbox" name="location-tag" id="pension" value="펜션"/>
                <label for="pension">펜션</label>
                <input type="checkbox" name="location-tag" id="resort" value="리조트"/>
                <label for="resort">리조트</label>
                <input type="checkbox" name="location-tag" id="campsite" value="캠핑"/>
                <label for="campsite">캠핑</label>
                <input type="checkbox" name="location-tag" id="glamping" value="글램핑"/>
                <label for="glamping">글램핑</label>
            </div>
            <div class="tag-buttons">
                <button class="tag-button" type="button" onclick="clearTags()">초기화</button>
            </div>
        </div>
        <div id="go">
            <button id="go-button" type="button" onclick="go()">만나기</button>
        </div>
        <div id="your-location" class="location-box">
            <h3>상대 주소</h3>
            <jsp:include page="../includes/juso.jsp">
                <jsp:param name="id" value="your-location"/>
            </jsp:include>
            <div class="location-logs">
                <p>기록이 없습니다</p>
            </div>
        </div>
    </form>
</main>
<jsp:include page="/WEB-INF/views/includes/footer.jsp"/>
</body>
</html>