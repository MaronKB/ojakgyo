<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="org.json.simple.JSONObject" %>
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
            <h3>광고 관리</h3>
            <div id="ads-buttons">
                <a onclick="insertAd()"><i class="fa-solid fa-plus"></i>광고 추가</a>
                <a onclick="deleteAds()"><i class="fa-solid fa-minus"></i>선택 광고 제거</a>
            </div>
        </div>
        <div id="ads-body">
            <div class="ads">
                <h3 class="ads-header">비활성</h3>
                <ul id="ads-disabled" class="ads-list"></ul>
                <div class="ads-footer">
                    <a onclick="setPage('invalid', false)"><i class="fa-solid fa-caret-left"></i></a>
                    <span id="ads-invalid-pagination"></span>
                    <a onclick="setPage('invalid', true)"><i class="fa-solid fa-caret-right"></i></a>
                </div>
            </div>
            <div id="ad-arrows">
                <button id="ad-enable" class="ad-arrow" type="button" onclick="moveAds('Y')"><i class="fa-solid fa-arrow-right"></i></button>
                <button id="ad-disable" class="ad-arrow" type="button" onclick="moveAds('N')"><i class="fa-solid fa-arrow-left"></i></button>
            </div>
            <div class="ads">
                <h3 class="ads-header">활성</h3>
                <ul id="ads-enabled" class="ads-list"></ul>
                <div class="ads-footer">
                    <a onclick="setPage('valid', true)"><i class="fa-solid fa-caret-left"></i></a>
                    <span id="ads-valid-pagination"></span>
                    <a onclick="setPage('valid', false)"><i class="fa-solid fa-caret-right"></i></a>
                </div>
            </div>
        </div>
    </form>
    <jsp:include page="ad_modal.jsp"/>
</main>
<jsp:include page="/WEB-INF/views/includes/footer.jsp"/>
</body>
<script type="text/javascript" src="<c:url value='/js/admin/ads.js'/>"></script>
</html>
