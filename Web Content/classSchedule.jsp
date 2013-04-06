<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Class Schedule</title>
	</head>
	<body>
	
	<table border="1">
		<tr>
			<td>Class ID</td><td>Class Name</td><td>Start Date</td><td>Term</td><td>Teacher</td><td>Price</td>
		</tr>
		<c:forEach items="${Course}" var="class" step="1">
	    <tr>
	    	<td><c:out value="${class.classID}" /></td>
	       <td><c:out value="${class.name}" /></td>
	       <td><c:out value="${class.date}" /></td>
	       <td><c:out value="${class.term}" /></td>
	       <td><c:out value="${class.teacher.getFullName()}" /></td>
	       <td><c:out value="${class.price}" /></td>
	     </tr>
	     </c:forEach>
	</table>
	</body>
</html>
