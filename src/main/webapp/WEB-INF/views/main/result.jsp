<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>결과</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/>"/>
    <script>
        const myLocation = '${myLocation}';
        const yourLocation = '${yourLocation}';
        const categories = '${categories}'.split(',');
        const centerGeocode = JSON.parse('${centerGeocode}');
        const poiData = JSON.parse('${poiData}');
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
</main>
<jsp:include page="../includes/footer.jsp"/>
</body>
</html>
