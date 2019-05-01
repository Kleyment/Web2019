<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Login</title>
</head>
<body>

<form method = "post" action = "LoginServlet">
	<fieldset>
		<legend> Login </legend>
		<label for = "pseudo">Pseudo<span class = "requis"></span></label>
		<input type = "text" id = "nom" name = "nom" value = "" size = "20"/>
		<br/>
		<label for = "password">Mot de passe<span class = "requis"></span></label>
		<input type = "password" id = "mdp" name = "mdp" value = "" size = "20"/>
		<br/>
		<input type = "submit" value = "Envoyer"/>		
	</fieldset>
</form>

</body>
</html>