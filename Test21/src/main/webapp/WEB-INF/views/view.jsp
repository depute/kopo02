<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Home</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<script>
function dirc(str){
	var opass=document.getElementById("opass").value;
	var pass=document.getElementById("pass").value;
	var id=document.getElementById("id").value;
	if(opass==pass){
		if(str=="upd") butt.action="update?id="+id;
		else if(str=="del") butt.action="delete?id="+id;
	}
	else return false;
}
function dirc2(str){
	var opass=document.getElementById("opass2").value;
	var pass=document.getElementById("pass2").value;
	var rootid=document.getElementById("id").value;
	var id=document.getElementById("id2").value;
	if(opass==pass){
		if(str=="upd") butt2.action="update?rootid="+rootid+"&id="+id;
		else if(str=="del") butt2.action="delete?rootid="+rootid+"&id="+id;
	}
	else return false;
}
function check(){
	var content=document.getElementById("content").value;
	var wrt=document.getElementById("wrt").value;
	var pass=document.getElementById("pass").value;
	if(content.indexOf("\\")>-1||wrt.indexOf("\\")>-1||pass.indexOf("\\")>-1|content.trim().length<1||wrt.trim().length<1||pass.trim().length<1) return false;
}
</script>
</head>
<body>
<center>
    <h1>게시판</h1>
    <c:forEach items="${fou}" var="fou"><c:set var="id" value="${fou.id}"/><input type="hidden" id="id" value="${fou.id}"/><input type="hidden" id="opass" value="${fou.pass}"/>
    <table border="1" style="border-collapse:collapse;">
    <tr><td>제목</td><td width="500">${fou.title}</td></tr>
    <tr><td>시간</td><td>${fou.date}</td></tr>
    <tr><td>작성자</td><td>${fou.wrt}</td></tr>
    <tr><td>조회수</td><td>${fou.viewcnt}</td></tr>
    <tr><td>내용</td><td>${fou.content}</td></tr>
    <tr><td>비밀번호</td><td><input type="password" maxlength="20" id="pass"/></td></tr>
    </table><form method="post" name="butt">
    <table>
    	<tr><td><input type="submit" value="수정" onclick='return dirc("upd")'></td>
    	<td><input type="submit" value="삭제" onclick='return dirc("del")'></td><td>
    	<input type="button" value="목록" onclick="window.location='index'"></td></tr>
    </table>
    </form>
    </c:forEach>
	<form method="post" action="insert" onsubmit="return check();"><input type="hidden" name="rootid" value="${id}"/>
    <table border="1" style="border-collapse:collapse;">
    	<tr><td colspan="4"><textarea rows="10" cols="70" name="content"></textarea></td></tr>
    	<tr><td>닉네임</td><td><input type="text" name="wrt"/></td><td>비밀번호</td><td><input type="password" name="pass"/></td></tr>
    </table>
    <input type="submit" value="입력"/>
    </form>
    <form method="post" name="butt2">
    <table border="1" width="600" style="border-collapse:collapse;border-left:hidden;border-right:hidden;">
    <c:forEach items="${re}" var="re"><input type="hidden" id="id2" value="${re.id}"/><tr><td>${re.wrt}</td><td><input type="hidden" id="opass2" value="${re.pass}"/><input type="password" id="pass2"></td><td><input type="submit" value="수정" onclick='return dirc2("upd")'></td><td><input type="submit" value="삭제" onclick='return dirc2("del")'></td><tr><tr><td colspan="4">${re.content}</td></tr></c:forEach>
    </table></form>
</center>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js"/>"></script>
</body>
</html>