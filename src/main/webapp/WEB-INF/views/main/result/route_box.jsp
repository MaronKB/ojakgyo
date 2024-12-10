<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="org.json.simple.parser.JSONParser" %>
<%@ page import="org.json.simple.parser.ParseException" %>
<%@ page import="org.json.simple.JSONArray" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    JSONParser parser = new JSONParser();
    JSONObject route = null;
    try {
        route = (JSONObject) parser.parse(request.getParameter("route"));
    } catch (ParseException e) {
        throw new RuntimeException(e);
    }
    JSONArray section = (JSONArray) route.get("section");
    JSONObject summary = (JSONObject) route.get("summary");
    long duration = (long) summary.get("duration");
    long durationHour = duration / 3600000;
    long durationMinute = (duration % 3600000) / 60000;
%>
<div id="<%=request.getParameter("id")%>" class="route-box">
    <div class="route-header">
        <h3 class="route-title"><%=request.getParameter("title")%></h3>
        <div class="route-duration">
            <div class="hours route-time"><span><%=durationHour%></span>시간</div>
            <div class="minutes route-time"><span><%=durationMinute%></span>분</div>
        </div>
    </div>
    <hr/>
    <h4 class="route-start"><%=request.getParameter("address")%></h4>
    <div class="route-road">
        <i class="fa-solid fa-angles-right"></i>
        <c:forEach var="section" items="<%=section%>" varStatus="sectionLoop">
            <h4 class="road">${section.get("name")}</h4>
            <i class="fa-solid fa-angles-right"></i>
        </c:forEach>
    </div>
    <hr/>
    <a class="route-outer-link">자세히 보기<i class="fa-solid fa-arrow-up-right-from-square"></i></a>
</div>