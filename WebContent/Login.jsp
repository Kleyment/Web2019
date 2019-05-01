<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion</title>
</head>
<body>

<form method = "post" action = "LoginServlet">
	<fieldset>
		<legend> Login </legend>
		<label for = "pseudo">Pseudo<span class = "requis"></span></label>
		<input type = "text" id = "pseudo" name = "pseudo" value = "" size = "20"/>
		<br/>
		<label for = "password">Mot de passe<span class = "requis"></span></label>
		<input type = "password" id = "password" name = "password" value = "" size = "20"/>
		<br/>
		<input type = "submit" value = "Envoyer"/>		
	</fieldset>
</form>

</body>
</html>