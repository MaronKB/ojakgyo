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
            </div>
        </div>
        <div id="inn" class="recommend">
            <h3>숙박</h3>
            <div class="recommend-list"></div>
        </div>
        <div id="restaurant" class="recommend">
            <h3>음식점</h3>
            <div class="recommend-list"></div>
        </div>
    </section>
</main>
<jsp:include page="../includes/footer.jsp"/>
</body>
<script type="text/javascript" language="javascript" src="https://oapi.map.naver.com/openapi/v3/maps.js?ncpClientId=d2682gqz4u"></script>
<script type="text/javascript" language="javascript" src="<c:url value="/js/main/result.js"/>"></script>
</html>
