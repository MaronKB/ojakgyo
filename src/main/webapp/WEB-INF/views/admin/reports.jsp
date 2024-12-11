<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 신고관리</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/>"/>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        .container {
            width: 90%;
            margin: auto;
            border: 1px solid #ccc;
            padding: 20px;
        }
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            border-bottom: 1px solid #ccc;
            padding-bottom: 10px;
        }
        .header h1 {
            font-size: 24px;
        }
        .navigation {
            display: flex;
            justify-content: flex-end;
            margin-top: 10px;
        }
        .navigation button {
            margin-left: 10px;
            padding: 5px 15px;
            background-color: #f0f0f0;
            border: 1px solid #ccc;
            cursor: pointer;
        }
        .content {
            margin-top: 20px;
        }
        .table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
        }
        .table th, .table td {
            border: 1px solid #ccc;
            text-align: center;
            padding: 10px;
        }
        .table th {
            background-color: #f9f9f9;
        }
        .pagination {
            text-align: center;
            margin-top: 20px;
        }
        .pagination a {
            margin: 0 5px;
            padding: 5px 10px;
            border: 1px solid #ccc;
            text-decoration: none;
            color: #333;
        }
        .pagination a.active {
            background-color: #007bff;
            color: white;
            border-color: #007bff;
        }
    </style>
</head>
<body>

<jsp:include page="/WEB-INF/views/includes/header.jsp"/>

    <div class="container">

        <div class="category-buttons">
            <button class="btn btn-outline-primary category-btn" data-category="전체">전체</button>
            <button class="btn btn-outline-primary category-btn" data-category="인기">인기</button>
            <button class="btn btn-outline-primary category-btn" data-category="리뷰">리뷰</button>
            <button class="btn btn-outline-primary category-btn" data-category="자유">자유</button>
            <button class="btn btn-outline-primary category-btn" data-category="질문">질문</button>
        </div>


        <div class="navigation">
            <button onclick="location.href='#'">광고관리</button>
            <button onclick="location.href='#'">신고관리</button>
            <button onclick="location.href='#'">유저관리</button>
        </div>


        <div class="content">
            <table class="table">
                <thead>
                    <tr>
                        <th>게시글 제목</th>
                        <th>닉네임</th>
                        <th>처리</th>
                    </tr>
                </thead>
                <tbody>
                        <td>취업은 못할것같습니다 </td>
                        <td>야매로456</td>
                        <td>
                            <button>이동</button>
                            <button>삭제</button>
                        </td>
                    </tr>
                    <tr>
                        <td>코딩이란 무엇인가</td>
                        <td>제라툴</td>
                        <td>
                            <button>이동</button>
                            <button>삭제</button>
                        </td>
                    </tr>
                </tbody>
            </table>

            <!-- Pagination -->
             <nav class="pagination">
                      <ul class="pagination">
                          <li class="page-item"><a class="page-link" href="#"><</a></li>
                          <li class="page-item active"><a class="page-link" href="#">1</a></li>
                          <li class="page-item"><a class="page-link" href="#">2</a></li>
                          <li class="page-item"><a class="page-link" href="#">3</a></li>
                          <li class="page-item"><a class="page-link" href="#">></a></li>
                      </ul>
                  </nav>
                  </div>
        </div>
    </div>
</body>
</html>
