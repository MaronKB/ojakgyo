<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
    request.setCharacterEncoding("UTF-8");
%>


<html>
<head>
    <meta charset=UTF-8">
    <title>회원 정보 출력창</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/>"/>
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/header.jsp"/>

    <div class="container">
        <div class="category-tabs">
            <div class="tab active">전체</div>
            <div class="tab">인기</div>
            <div class="tab">리뷰</div>
            <div class="tab">자유</div>
            <div class="tab">질문</div>
        </div>

        <div class="table-container">
            <table class="table">
                <thead>
                    <tr>
                        <td ><b>번호</b></td>
                        <td><b>제목</b></td>
                        <td><b>작성자</b></td>
                        <td><b>작성일</b></td>
                        <td><b>조회수</b></td>
                        <td><b>추천수</b></td>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="post" items="${postList}" >
                    <tr>
                        <td>${post.post_id}</td>
                        <td>${post.post_title}</td>
                        <td>${post.post_author_nickname}</td>
                        <td>${post.post_reg_date}</td>
                        <td>${post.post_view_count}</td>
                        <td>${post.post_vote_count}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="pagination">
            <a href="#">«</a>
            <a href="#">1</a>
            <a href="#">2</a>
            <a href="#">3</a>
            <a href="#">4</a>
            <a href="#">5</a>
            <a href="#">6</a>
            <a href="#">7</a>
            <a href="#">8</a>
            <a href="#">9</a>
            <a href="#">»</a>
        </div>

        <div class="search-bar">
            <select>
                <option>제목</option>
                <option>내용</option>
                <option>제목+내용</option>
                <option>작성자</option>
            </select>
            <input type="text" placeholder="검색어를 입력해주세요.">
            <button>검색</button>
        </div>
    </div>
    <%--<a  href="${contextPath}/member/memberForm.do"><h1 style="text-align:center">회원가입</h1></a>--%>
</body>
</html>
