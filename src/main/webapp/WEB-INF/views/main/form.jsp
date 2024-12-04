<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/>"/>
    <script type="text/javascript" language="javascript" src="<c:url value="/js/main/form.js"/>"></script>
    <script type="text/javascript" language="javascript" src="<c:url value="/js/juso.js"/>"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
<main id="main">
    <div id="my-location" class="location-box">
        <h3>나의 주소</h3>
        <jsp:include page="../includes/juso.jsp">
            <jsp:param name="id" value="my-location"/>
        </jsp:include>
        <div class="location-favorite">
            <%--grid--%>
        </div>
    </div>
    <div id="your-location" class="location-box">
        <h3>상대 주소</h3>
        <jsp:include page="../includes/juso.jsp">
            <jsp:param name="id" value="your-location"/>
        </jsp:include>
        <div class="location-log">
            <%--list--%>
        </div>
    </div>
</main>
<jsp:include page="/WEB-INF/views/includes/footer.jsp"/>
</body>
</html>