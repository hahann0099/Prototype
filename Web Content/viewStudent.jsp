<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Insert title here</title>
    </head>
    <body>
        <center>
            <form method="post" action="Authenticate">
                <h1>${message} </h1>
                <SELECT name="Student">
                <c:forEach items="${studentInfo}" var="stu" step="1">
                    <OPTION value="<c:out value="${stu.studentID}"/>"> <c:out value="${stu.first}"/> </OPTION>
                </c:forEach>
                </SELECT>
                <input type="submit" name="authenticate" value="View Info" /> 
                <c:url var="editUrl" value="/person.html" />
                <c:url var="deleteUrl" value="/person/delete.html" />
                <c:forEach items="${studentInfos}" var="stud" step="1">
                    <table border="1">
                        <tr><td>First Name</td><td>Last Name</td><td>Dance Experience</td><td>Class</td><td>Edit</td><td>Delete</td></tr>
                        <tr>
                            <td><c:out value="${stud.first}" /></td>
                            <td><c:out value="${stud.last}" /></td>
                            <td><c:out value="${stud.danceExp}" /></td>
                            <td><c:out value="${stud.classes[0].name}" /></td>
                            <td><a href="<c:out value="${editUrl}"/>">Edit</a></td>
                            <td><a href="<c:out value="${deleteUrl}"/>">Delete</a></td>
                        </tr>
                    </table>
                </c:forEach>
            </form>
        </center>
    </body>
</html>
