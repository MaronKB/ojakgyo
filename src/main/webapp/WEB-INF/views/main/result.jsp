<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>결과</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/>"/>
    <script>
        const test = '${pageContext.request.contextPath}' === '/test/main';
        const myLocation = '${myLocation}';
        const yourLocation = '${yourLocation}';
        const categories = '${categories}'.split(',');
        const centerGeocode = JSON.parse('${centerGeocode}');
        const poiData = JSON.parse('${poiData}'.replace(/\n/gi, "<br/>"));
    </script>
    <script type="text/javascript" language="javascript" src="<c:url value="/js/main/result.js"/>"></script>
</head>
<body>
<jsp:include page="../includes/header.jsp"/>
<main>
    <div>
        <p>${myLocation}</p>
        <p>${yourLocation}</p>
        <p>${categories}</p>
    </div>
    <section about="map" id="map">
        <div id="map-left" class="map-side">

        </div>
        <div id="map-center">

        </div>
        <div id="map-right" class="map-side">
        </div>
    </section>
</main>
<jsp:include page="../includes/footer.jsp"/>
</body>
</html>
