<%@ page contentType="text/html;charset=UTF-8" %>
<div id="my-location" class="location-box-container main-box-container">
    <div class="location-box main-box">
        <h3>나의 주소</h3>
        <jsp:include page="/WEB-INF/views/includes/juso.jsp">
            <jsp:param name="id" value="my-location"/>
        </jsp:include>
        <div class="my-juso">
            <button class="my-juso-button" type="button" onclick="getJusoFromAccount()"><i class="fa-solid fa-upload"></i>자주 쓰는 주소</button>
            <button class="my-juso-button" type="button" onclick="window.location.href = '/mypage'"><i class="fa-solid fa-gear"></i>관리</button>
        </div>
    </div>
</div>
