<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
list.jsp
	
	<table width="500" cellpadding="0" border="1">
	<tr>
		<td>번호 </td>
		<td>이름 </td>
		<td>제목 </td>
		<td>날짜 </td>
		<td>히트 </td>
	</tr>	
	<c:forEach items="${list}" var="dto">
		<tr>
			id: <td>${dto.bid}</td>
			이름 :<td>${dto.bName}</td>
			제목 :<td>${dto.bTitle}</td>
			날짜 : <td>${dto.bDate}</td>
			히트 : <td>${dto.bHit}</td>
		</tr>
	</c:forEach>
	
	</table>

	
</body>
</html>