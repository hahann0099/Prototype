<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${invoiceID}
<c:forEach items="${tempPayment.errors}" var="error">
 <p><c:out value="${error}"/> </p>
 </c:forEach>
<form action="Authenticate" method="post">
 <fieldset>
       <p>
          <label>Payment Type:</label>            
          <input type = "radio"
                 name = "cardType"
                 id = "Visa"
                 value = "Visa"
                 checked = "checked" />
          <label for = "Visa">Visa</label>
          <input type = "radio"
                 name = "cardType"
                 id = "MasterCard"
                 value = "MasterCard" />
          <label for = "MasterCard">MasterCard</label>
          <input type = "radio"
                 name = "cardType"
                 id = "AE"
                 value = "American Express" />
                  <label for = "AE">American Express</label>
        </p>       
      </fieldset>     
      First Name (As appears on the Card):<input type="text" name="first" value="<c:out value="${tempPayment.first}"/>"/>
      <br />
Last Name (As appears on the Card): <input type="text" name ="last" value="<c:out value="${tempPayment.last}"/>"/>
<br />
Billing Address: <input type="text" name="address" value="<c:out value="${tempPayment.address}"/>"/>
<br />
Billing Postal Code: <input type="text" name="postal" value="<c:out value="${tempPayment.postal}"/>"/>
<br />
Province: <select name="province">
<option value="Ontario">Ontario </option>
<option value="Manitoba">Manitoba </option>
<option value="Alberta">Alberta </option>
<option value="Saskatchewan">Saskatchewan </option>
</select>
<br />
City: <select name="city" >
<option value="Burlington" name="Burlington">Burlington </option>
<option value="Milton" name="Milton">Milton </option>
<option value="Oakville" name="Oakville">Oakville </option>
<option value="Mississauga" name="Oakville">Oakville </option>
</select>
<br />
      Card #:<input type="password" name="cardNo" value="<c:out value="${tempUser.cardNo}"/>"/>
      <br />
      Security Code: <input type="password" name="code" value="<c:out value="${tempPayment.code}"/>" />
      <br />
      Expiry: <input type="date" name="expiry"/>
      <br />
      <input type="submit" value="Confirm Payment" name ="authenticate" /> 
      </form>
</body>
</html>
