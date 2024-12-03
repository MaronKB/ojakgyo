<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Header</title>
    <script src="<c:url value="/js/header.js"/>"></script>
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/header.css"/>"/>
</head>
<body>
<header id="header">
    <div id="header-title">
        <img id="header-title-img" src="<c:url value="/images/ojakgyo_logo_1000_320.png"/>" alt="로고"/>
        <h1 id="header-title-text">오작교</h1>
    </div>
    <div id="header-navs">
        <nav id="header-top">
            <c:choose>
                <c:when test="${!empty sessionScope.user}">
                    <a href="<c:url value="/mypage"/>">마이페이지</a>
                    <a href="<c:url value="/api/user/logout"/>">로그아웃</a>
                </c:when>
                <c:otherwise>
                    <a href="<c:url value="/login"/>">로그인</a>
                    <a href="<c:url value="/register"/>">회원가입</a>
                </c:otherwise>
            </c:choose>
        </nav>
        <nav id="header-menu">
            <a href="<c:url value="/main"/>">장소찾기</a>
            <a href="<c:url value="/community"/>">커뮤니티</a>
            <a href="<<c:url value="/hotplace"/>">핫플레이스</a>
            <c:if test="${sessionScope.user.isAdmin}">
                <a href="<c:url value="/admin/ad"/>">광고관리</a>
                <a href="<c:url value="/admin/reports"/>">신고관리</a>
                <a href="<c:url value="/admin/users"/>">유저관리</a>
            </c:if>
        </nav>
    </div>
    <div id="header-selector"></div>
</header>
</body>
</html>
