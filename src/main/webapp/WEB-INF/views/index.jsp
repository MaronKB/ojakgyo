<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/landing.css"/>"/>
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
<main id="index">
    <div id="index-content">
        <div id="index-content-container">
            <h2>너에게로 향하는 길</h2>
            <p>모든 친구, 연인, 가족들의 인연을 지원합니다.</p>
            <p><span>오작교</span>는 멀리 떨어져 지내는 분들의 만남 장소를 추천하고 공유하는 서비스입니다.</p>
            <p>원거리 연애 커플, 상경하거나 귀농하여 떨어진 가족, 오랜만에 만나는 친구, 인터넷으로 맺어진 인연 등, 많은 연유로 만나고 싶지만 만나기 어려운 사람들이 중간 지점에서 만날 수 있도록 돕습니다.</p>
            <a href="<c:url value="/main"/>">지금 시작하기</a>
        </div>
    </div>
    <div id="index-image">
        <div id="index-image-container">
            <img id="index-image-img" src="<c:url value="/images/index_photo_2.jpg"/>" alt="이정표"/>
            <div id="index-image-cover"></div>
        </div>
    </div>
</main>
</body>
</html>
