<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Home</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<script type="text/javascript">
function check(){
	var title=document.getElementById("title").value;
	var content=document.getElementById("content").value;
	var wrt=document.getElementById("wrt").value;
	var pass=document.getElementById("pass").value;
	if(title.indexOf("\\")>-1||content.indexOf("\\")>-1||wrt.indexOf("\\")>-1||pass.indexOf("\\")>-1||title.trim().length<1||content.trim().length<1||wrt.trim().length<1||pass.trim().length<1) return false;
}
</script>
</head>
<body>
<center>
    <h1>게시판</h1><c:forEach items="${fou}" var="fou"><c:set var="id" value="${fou.id}"/><c:if test="${fou.rootid==null}"><c:set var="title" value="${fou.title}"/><c:set var="rootid"/></c:if><c:if test="${fou.rootid!=null}"><c:set var="rootid" value="${fou.rootid}"/></c:if><c:set var="content" value="${fou.content}"/><c:set var="wrt" value="${fou.wrt}"/></c:forEach>
 <form action="insert" method="post" onsubmit="return check();"><c:if test="${rootid!=null}"><input type="hidden" name="rootid" value="${rootid}"/></c:if>
    <table border="1" style="border-collapse:collapse;"><input type="hidden" value="${id}" name="id"/>
            <c:if test="${rootid==null}"><tr>
                <td>제목</td>
                <td><input type="text" name="title" id="title" maxlength="100" style="width:100%" value="${title}" required/></td>
            </tr></c:if>
        <tr>
     
                    <td>내용</td>
                    <td><textarea name="content" id="content" cols="80" rows="20" required>${content}</textarea></td>
                </tr>
        <tr><td>작성자</td><td><input type="text" name="wrt" id="wrt" maxlength="20" value="${wrt}" required/></td>
        </tr>
        <tr><td>비밀번호</td><td><input type="password" name="pass" id="pass" maxlength="20" required/></td>
        </tr>
    </table>
    <input type="submit" value="작성"/><input type="button" value="취소" onclick="window.location='index'"/>
    </form>
    </center>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js"/>"></script>
</body>
</html>