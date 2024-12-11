<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/index.css'/>">
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
<main id="main" class="max">
    <form id="ads">
        <div id="ads-header">
            <a><i class="fa-solid fa-plus"></i></a>
            <a><i class="fa-solid fa-minus"></i></a>
        </div>
        <div id="ads-body">
            <div class="ads">
                <h3 class="ads-header">비활성</h3>
                <ul id="ads-disabled" class="ads-list">
                    <c:forEach items="${ads.get('inactive')}" var="ad">
                        <jsp:include page="ad_item.jsp">
                            <jsp:param name="ad" value="${ad}"/>
                        </jsp:include>
                    </c:forEach>
                </ul>
            </div>
            <div id="ad-arrows">
                <button id="ad-enable" class="ad-arrow" type="button"><i class="fa-solid fa-arrow-right"></i></button>
                <button id="ad-disable" class="ad-arrow" type="button"><i class="fa-solid fa-arrow-left"></i></button>
            </div>
            <div class="ads">
                <h3 class="ads-header">활성</h3>
                <ul id="ads-enabled" class="ads-list">
                    <c:forEach items="${ads.get('active')}" var="ad">
                        <jsp:include page="ad_item.jsp">
                            <jsp:param name="ad" value="${ad}"/>
                        </jsp:include>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </form>
</main>
<jsp:include page="/WEB-INF/views/includes/footer.jsp"/>
</body>
</html>
