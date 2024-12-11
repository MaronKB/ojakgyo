<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="org.json.simple.parser.JSONParser" %>
<%@ page import="org.json.simple.parser.ParseException" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    JSONParser parser = new JSONParser();
    JSONObject ad = null;
    String adString = request.getParameter("ad");
    System.out.println(adString);
    try {
        ad = (JSONObject) parser.parse(adString);
    } catch (ParseException e) {
        throw new RuntimeException(e);
    }
%>
<li class="ad">
    <input type="checkbox" id="ad-<%=ad.get("id")%>" name="ads" value="<%=ad.get("id")%>">
    <label for="ad-<%=ad.get("id")%>">
        <span class="ad-content">
            <a class="ad-title"><%=ad.get("title")%></a>
            <span class="ad-expires-in">만료일 :
                <c:choose>
                    <c:when test='<%=ad.get("expDate").equals("")%>'>
                        지정되지 않음
                    </c:when>
                    <c:otherwise>
                        <%=ad.get("expDate")%>
                    </c:otherwise>
                </c:choose>
            </span>
        </span>
        <span class="ad-buttons">
            <a class="ad-edit"><i class="fa-solid fa-pen-to-square"></i></a>
            <a class="ad-delete"><i class="fa-solid fa-trash"></i></a>
        </span>
    </label>
</li>