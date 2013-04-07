<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Authenticate" method="post">
<center>
 <c:forEach items="${tempUser.errors}" var="error">
 <p><c:out value="${error}"/> </p>
 </c:forEach>
 
First Name:<input type="text" name="first" value="<c:out value="${tempUser.first}"/>" /> Last Name: <input type="text" name="last" value="<c:out value="${tempUser.last}"/>"/>
<br />Email:<input type="email" name="email" value="<c:out value="${tempUser.email}"/>"/> Confirm Email:<input type="email" name="cEmail" /> <br />
Phone: <input type="tel" name="phone" value="<c:out value="${tempUser.homePhone}"/>"/> Work Phone:<input type="tel" name="wPhone" value="<c:out value="${tempUser.workPhone}"/>"/>
<br />Password: <input type="password" name="pass" /> Confirm Password: <input type="password" name="cPass" />
<br />Emergency Contact: <input type="text" name="emer" value="<c:out value="${tempUser.emerContact}"/>"/> Emergency Phone: <input type="text" name="emerP" value="<c:out value="${tempUser.emerPhone}"/>"  />
<br />Address: <input type="text" name="address" value="<c:out value="${tempUser.address}"/>" /> City: <input type="text" name="city" value="<c:out value="${tempUser.city}"/>" />
<br />Province: <select name="province">
  <option>Ontario</option>
  <option>Quebec</option>
  <option>Manitoba</option>
</select>  
Postal Code: <input type="text" name="postal" value="<c:out value="${tempUser.postal}"/>" />/> 
<br />
<input type="submit" value="Register" name="authenticate" />
</center>
</form>
</body>
</html>
