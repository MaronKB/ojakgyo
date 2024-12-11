<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="your-location" class="location-box-container main-box-container" data-target="your-location">
    <div class="location-box main-box">
        <header class="location-box-header main-box-header">
            <h3>상대 위치</h3>
            <a data-target="your-location" onclick="toggleBox(this)"><i class="fa-solid fa-times"></i></a>
        </header>
        <div class="location-box-body main-box-body">
            <jsp:include page="/WEB-INF/views/includes/juso.jsp">
                <jsp:param name="id" value="your-location"/>
            </jsp:include>
            <div class="location-logs">
                <p>기록이 없습니다</p>
            </div>
        </div>
    </div>
</div>