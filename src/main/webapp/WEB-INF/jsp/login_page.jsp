<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<h2>Virgilio</h2>
<c:if test = "${message != null}">      
   <b>User Not Found</b><br><br>
</c:if> 

<form name="auth" action="/OAuthAAA/login" method="post">
<input type="hidden" id="client_id" name="client_id" value="${client_id}">
<input type="hidden" id="redirect_uri" name="redirect_uri" value="${redirect_uri}">

Username<br>
<input type="text" id="txtUsername" name="txtUsername"><br><br>
Password<br>
<input type="password" id="txtPassword" name="txtPassword"><br><br>
<input type="submit" value="Invia" id="send">
</form> 


</body>
</html>
