<%@ page contentType="text/html;charset=UTF-8" %>
<div id="my-location" class="location-box-container main-box-container" data-target="my-location">
    <div class="location-box main-box">
        <header class="location-box-header main-box-header">
            <h3>내 위치</h3>
            <a data-target="my-location" onclick="toggleBox(this)"><i class="fa-solid fa-times"></i></a>
        </header>
        <div class="location-box-body main-box-body">
            <jsp:include page="/WEB-INF/views/includes/juso.jsp">
                <jsp:param name="id" value="my-location"/>
            </jsp:include>
            <div class="my-juso">
                <button class="my-juso-button" type="button" onclick="getJusoFromAccount()"><i class="fa-solid fa-upload"></i>자주 쓰는 주소</button>
                <button class="my-juso-button" type="button" onclick="window.location.href = '/mypage'"><i class="fa-solid fa-gear"></i>관리</button>
            </div>
        </div>
    </div>
</div>
