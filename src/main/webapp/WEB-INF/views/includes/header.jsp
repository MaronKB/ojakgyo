<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="<c:url value="/js/includes/header.js"/>"></script>
<header id="header">
    <a id="header-title" href="<c:url value="/"/>">
        <img id="header-title-img" src="<c:url value="/images/ojakgyo_logo_1000_320.png"/>" alt="로고"/>
        <h1 id="header-title-text">오작교</h1>
    </a>
    <nav id="header-menu">
        <a href="<c:url value="/main"/>">장소찾기</a>
        <a href="<c:url value="/community"/>">커뮤니티</a>
        <a href="<c:url value="/hotplace"/>">핫플레이스</a>
        <c:if test="${sessionScope.user.isAdmin == 'Y'}">
            <a href="<c:url value="/admin/ads"/>">광고관리</a>
            <a href="<c:url value="/admin/reports"/>">신고관리</a>
            <a href="<c:url value="/admin/users"/>">유저관리</a>
        </c:if>
    </nav>
    <nav id="header-user">
        <c:choose>
            <c:when test="${!empty sessionScope.user}">
                <a href="<c:url value="/mypage"/>">마이페이지</a>
                <a onclick="logout()">로그아웃</a>
            </c:when>
            <c:otherwise>
                <a href="<c:url value="/login"/>">로그인</a>
                <a href="<c:url value="/register"/>">회원가입</a>
            </c:otherwise>
        </c:choose>
    </nav>
    <div id="header-selector"></div>
</header>
