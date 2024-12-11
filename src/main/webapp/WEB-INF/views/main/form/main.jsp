<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/>"/>
    <script type="text/javascript" language="javascript" src="<c:url value="/js/main/main.js"/>"></script>
    <script type="text/javascript" language="javascript" src="<c:url value="/js/includes/juso.js"/>"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
<main id="main" class="max">
    <form id="main-form" action="${pageContext.request.contextPath}/main/result"  method="post" onsubmit="go()">
        <div id="main-container">
            <button type="button" id="my-location-toggle" class="location-toggle" data-target="my-location" onclick="toggleBox(this)">
                <span class="location-image-container">
                    <img src="<c:url value="/images/place_user.png"/>" alt="내 위치"/>
                </span>
                <span class="location-toggle-title">내 위치</span>
            </button>
            <jsp:include page="radius.jsp"/>
            <button type="button" id="your-location-toggle" class="location-toggle" data-target="your-location" onclick="toggleBox(this)">
                <span class="location-image-container">
                    <img src="<c:url value="/images/place_user.png"/>" alt="상대 위치"/>
                </span>
                <span class="location-toggle-title">상대 위치</span>
            </button>
            <div id="main-hr"></div>
            <div id="center-buttons">
                <jsp:include page="category_button.jsp"/>
                <button id="go-button" type="button" onclick="go()">
                    <span>만나기</span>
                </button>
            </div>
        </div>
        <jsp:include page="sort.jsp"/>
        <jsp:include page="my_location.jsp"/>
        <jsp:include page="your_location.jsp"/>
        <jsp:include page="category_box.jsp"/>
    </form>
</main>
<jsp:include page="/WEB-INF/views/includes/footer.jsp"/>
</body>
</html>