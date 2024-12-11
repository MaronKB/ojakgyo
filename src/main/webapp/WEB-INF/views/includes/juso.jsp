<%@ page contentType="text/html;charset=UTF-8" %>
<% String id = request.getParameter("id"); %>
<div class="juso">
    <input type="text" id="<%=id%>-value" name="<%=id%>" class="juso-value" onclick="new Juso('<%=id%>').open()" readonly/>
    <button class="juso-button" type="button" onclick="new Juso('<%=id%>').open()"><i class="fa-solid fa-pen-to-square"></i>변경</button>
</div>