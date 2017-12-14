<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>OAuth Approval</h1>
	<p>Do you authorize '${authorizationRequest.clientId}' to access
		your protected resources?</p>
	<form id='confirmationForm' name='confirmationForm'
		action='${path}/oauth/authorize' method='post'>
		<input name='user_oauth_approval' value='true' type='hidden' /><label><input
			name='authorize' value='Authorize' type='submit'></label>
	</form>
	<form id='denialForm' name='denialForm'
		action='${path}/oauth/authorize' method='post'>
		<input name='user_oauth_approval' value='false' type='hidden' /><label><input
			name='deny' value='Deny' type='submit'></label>
	</form>

</body>
</html>
