<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="your-location" class="location-box main-box">
  <h3>상대 주소</h3>
  <jsp:include page="../includes/juso.jsp">
    <jsp:param name="id" value="your-location"/>
  </jsp:include>
  <div class="location-logs">
    <p>기록이 없습니다</p>
  </div>
</div>