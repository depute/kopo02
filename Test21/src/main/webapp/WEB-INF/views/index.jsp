<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Home</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
</head>
<body><center><style type="text/css">
a {text-decoration:none;color:black;}</style>
    <h1>게시판</h1>
 
    <table border="1" style="border-collapse:collapse;">
        <thead>
            <tr>
                <th width="50">번호</th>
                <th width="300">제목</th>
                <th width="55">조회수</th>
                <th width="152">등록시간</th>
                <th width="150">작성자</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${fir}" var="fir">
                <tr>
                    <td align="right">${fir.id}</td>
                    <td><a href="view?id=${fir.id}">${fir.title}</a></td>
                    <td align="right">${fir.viewcnt}</td>
                    <td>${fir.date}</td>
                    <td align="center">${fir.wrt}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <table width="702"><tr><td align="right">
    <input type="button" value="작성" onclick="window.location='write'"/></td></tr></table>
    <table width="702"><tr><c:forEach var="cnt" begin="${pstart}" end="${pend}"><td align="center"><a href="index?p=${cnt}">${cnt}</a></td></c:forEach></tr><tr><td align="center" colspan="11"><form method="get" action="index"><select name="sel"><option value="title">제목</option><option value="content">제목+내용</option><option value="wrt">작성자</option></select><input type="text" name="con"/><input type="submit" value="검색"></form></td></tr></table>
    </center>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js"/>"></script>
</body>
</html>