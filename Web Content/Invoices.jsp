<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<form method="post" action="Authenticate"><SELECT name="Invoice">
<c:forEach items="${invoices}" var="inv" step="1">
<OPTION value="<c:out value="${inv.invoiceID}"/>"> <c:out value="${inv.invoiceID}"/>
</OPTION>
</c:forEach>
</SELECT>
  <input type="submit" name="authenticate" value="View Invoice"/> 
  <br/>
   <input type="submit" name="authenticate" value="Pay Invoice"/> 
   <br />
   <SELECT name="pInvoice">
<c:forEach items="${pInvoices}" var="invo" step="1">
<OPTION value="<c:out value="${invo.invoiceID}"/>"> <c:out value="${invo.invoiceID}"/>
</OPTION>
</c:forEach>
</SELECT>
<input type="submit" name="authenticate" value="View Current Invoice"/> 
      </form>
      </center>
      </body>
      </html>