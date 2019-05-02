<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap.css">
<title>Modification</title>
</head>
<body>

<% ResultSet rs = null;
if (!(request.getAttribute("user") == null)){
		rs = (ResultSet)request.getAttribute("user");
		rs.next();
	}
%>



<form method = "post" action = "UserModifyServlet">
	<fieldset>
		<legend> Modification </legend>
		<label for = "pseudo">Pseudo<span class = "requis"></span></label>
		<input type = "text" id = "pseudo" name = "pseudo" value = "<% out.println(rs.getString(2)); %>" size = "20"/>
		<br/>
		<label for = "password">Mot de passe<span class = "requis"></span></label>
		<input type = "password" id = "password" name = "password" value = "<% out.println(rs.getString(3)); %> " size = "20"/>
		<br/>
		<input type = "submit" value = "Envoyer"/>		
	</fieldset>
</form>

</body>
</html>

