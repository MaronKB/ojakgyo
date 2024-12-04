<%@ page contentType="text/html;charset=UTF-8" %>
<% String id = request.getParameter("id"); %>
<div class="juso">
    <input type="text" id="<%=id%>-value" class="juso-value" disabled/>
    <div class="juso-buttons">
        <button class="juso-button" type="button" onclick="new Juso('<%=id%>').open()">변경</button>
        <div class="juso-account">
            <button class="juso-button" type="button" onclick="getJusoFromAccount('<%=id%>')">자주 쓰는 주소</button>
            <button class="juso-button" type="button" onclick="window.location.href = '/mypage'">관리</button>
        </div>
    </div>
</div>