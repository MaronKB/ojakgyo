<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    JSONArray poiData = (JSONArray) request.getAttribute("poiData");
    for (Object poiDatum : poiData) {
        JSONObject data = (JSONObject) poiDatum;
        String name = (String) data.get("name");

        name = name.replaceAll("\\[[ㄱ-ㅎ가-힣]+]", "");

        data.remove("name");
        data.put("name", name);
    }
%>
<html>
<head>
    <title>결과</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/>"/>
    <script>
        const categories = '${categories}'.split(',');
        const myLocation = '${myLocation}';
        const yourLocation = '${yourLocation}';
        const centerLocation = JSON.parse('${centerLocation}');
        const poiData = JSON.parse('${poiData}'.replace(/\n/g, '<br/>'));
        const mapImage = '${mapImage}';
        const myRoute = JSON.parse(`${myRoute}`);
        const yourRoute = JSON.parse(`${yourRoute}`);
    </script>
</head>
<body>
<jsp:include page="../includes/header.jsp"/>
<main id="result">
    <div id="result-header">
        <c:forEach var="category" items="${categories}" varStatus="loop">
            <div class="category" data-category="${category}">
                #${category}
            </div>
        </c:forEach>
    </div>
    <section about="map" id="map-container">
        <c:forEach var="poi" items="${poiData}" varStatus="loop">
            <div class="poi">
                <div class="poi-category">${poi.bizCatName}</div>
                <div class="poi-name">${poi.name}</div>
                <div class="poi-address">
                    <c:choose>
                        <c:when test="${poi.bldAddr ne ''}">${poi.bldAddr} ${poi.bldNo1}<c:if test="${poi.bldNo2 ne ''}"> - ${poi.bldNo2}</c:if><c:if test="${poi.dcdName ne ''}">(${poi.dcdName})</c:if></c:when>
                        <c:otherwise>${poi.address}</c:otherwise>
                    </c:choose>
                </div>
            </div>
        </c:forEach>
        <div id="map" style="width: 100%; height: 100%;">
        </div>
    </section>
    <section about="locates" id="locates-container">
        <jsp:include page="route_box.jsp">
            <jsp:param name="id" value="my-locate"/>
            <jsp:param name="title" value="나의 경로"/>
            <jsp:param name="address" value="${myLocation}"/>
            <jsp:param name="route" value="${myRoute}"/>
        </jsp:include>
        <jsp:include page="route_box.jsp">
            <jsp:param name="id" value="your-locate"/>
            <jsp:param name="title" value="상대의 경로"/>
            <jsp:param name="address" value="${yourLocation}"/>
            <jsp:param name="route" value="${yourRoute}"/>
        </jsp:include>
    </section>
    <section about="recommends" id="recommends-container">
        <div id="recommend-rental" class="recommend">
            <h3>렌터카</h3>
            <div class="recommend-list">
                <div class="recommend-item">
                    <div class="recommend-image">
                        <img src="<c:url value="/images/rental_1.jpg"/>" alt="렌터카1"/>
                    </div>
                    <div class="recommend-info">
                        <h4>렌터카1</h4>
                        <p>렌터카1 설명</p>
                    </div>
                </div>
                <div class="recommend-item">
                    <div class="recommend-image">
                        <img src="<c:url value="/images/rental_2.jpg"/>" alt="렌터카2"/>
                    </div>
                    <div class="recommend-info">
                        <h4>렌터카2</h4>
                        <p>렌터카2 설명</p>
                    </div>
                </div>
                <div class="recommend-item">
                    <div class="recommend-image">
                        <img src="<c:url value="/images/rental_3.jpg"/>" alt="렌터카3"/>
                    </div>
                    <div class="recommend-info">
                        <h4>렌터카3</h4>
                        <p>렌터카3 설명</p>
                    </div>
                </div>
                <div class="recommend-item">
                    <div class="recommend-image">
                        <img src="<c:url value="/images/rental_4.jpg"/>" alt="렌터카4"/>
                    </div>
                    <div class="recommend-info">
                        <h4>렌터카4</h4>
                        <p>렌터카4 설명</p>
                    </div>
                </div>
                <div class="recommend-item">
                    <div class="recommend-image">
                        <img src="<c:url value="/images/rental_5.jpg"/>" alt="렌터카5"/>
                    </div>
                    <div class="recommend-info">
                        <h5>렌터카5</h5>
                        <p>렌터카5 설명</p>
                    </div>
                </div>
            </div>
        </div>
        <div id="inn" class="recommend">
            <h3>숙박</h3>
            <div class="recommend-list">
                <div class="recommend-item">
                    <div class="recommend-image">
                        <img src="<c:url value="/images/inn_1.jpg"/>" alt="숙박1"/>
                    </div>
                    <div class="recommend-info">
                        <h4>숙박1</h4>
                        <p>숙박1 설명</p>
                    </div>
                </div>
                <div class="recommend-item">
                    <div class="recommend-image">
                        <img src="<c:url value="/images/inn_2.jpg"/>" alt="숙박2"/>
                    </div>
                    <div class="recommend-info">
                        <h4>숙박2</h4>
                        <p>숙박2 설명</p>
                    </div>
                </div>
                <div class="recommend-item">
                    <div class="recommend-image">
                        <img src="<c:url value="/images/inn_3.jpg"/>" alt="숙박3"/>
                    </div>
                    <div class="recommend-info">
                        <h4>숙박3</h4>
                        <p>숙박3 설명</p>
                    </div>
                </div>
                <div class="recommend-item">
                    <div class="recommend-image">
                        <img src="<c:url value="/images/inn_4.jpg"/>" alt="숙박4"/>
                    </div>
                    <div class="recommend-info">
                        <h4>숙박4</h4>
                        <p>숙박4 설명</p>
                    </div>
                </div>
                <div class="recommend-item">
                    <div class="recommend-image">
                        <img src="<c:url value="/images/inn_5.jpg"/>" alt="숙박5"/>
                    </div>
                    <div class="recommend-info">
                        <h5>숙박5</h5>
                        <p>숙박5 설명</p>
                    </div>
                </div>
            </div>
        </div>
        <div id="restaurant" class="recommend">
            <h3>음식점</h3>
            <div class="recommend-list">
                <div class="recommend-item">
                    <div class="recommend-image">
                        <img src="<c:url value="/images/restaurant_1.jpg"/>" alt="음식점1"/>
                    </div>
                    <div class="recommend-info">
                        <h4>음식점1</h4>
                        <p>음식점1 설명</p>
                    </div>
                </div>
                <div class="recommend-item">
                    <div class="recommend-image">
                        <img src="<c:url value="/images/restaurant_2.jpg"/>" alt="음식점2"/>
                    </div>
                    <div class="recommend-info">
                        <h4>음식점2</h4>
                        <p>음식점2 설명</p>
                    </div>
                </div>
                <div class="recommend-item">
                    <div class="recommend-image">
                        <img src="<c:url value="/images/restaurant_3.jpg"/>" alt="음식점3"/>
                    </div>
                    <div class="recommend-info">
                        <h4>음식점3</h4>
                        <p>음식점3 설명</p>
                    </div>
                </div>
                <div class="recommend-item">
                    <div class="recommend-image">
                        <img src="<c:url value="/images/restaurant_4.jpg"/>" alt="음식점4"/>
                    </div>
                    <div class="recommend-info">
                        <h4>음식점4</h4>
                        <p>음식점4 설명</p>
                    </div>
                </div>
                <div class="recommend-item">
                    <div class="recommend-image">
                        <img src="<c:url value="/images/restaurant_5.jpg"/>" alt="음식점5"/>
                    </div>
                    <div class="recommend-info">
                        <h5>음식점5</h5>
                        <p>음식점5 설명</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>
<jsp:include page="../includes/footer.jsp"/>
</body>
<script type="text/javascript" language="javascript" src="https://oapi.map.naver.com/openapi/v3/maps.js?ncpClientId=d2682gqz4u"></script>
<script type="text/javascript" language="javascript" src="<c:url value="/js/main/result.js"/>"></script>
</html>
