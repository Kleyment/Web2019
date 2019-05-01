<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Formation</title>
</head>
<body>

<form method = "post" action = "UserServlet">
	<fieldset>
		<legend> Inscrire un utilisateur </legend>
		<label for = "pseudo">Pseudo<span class = "requis"></span></label>
		<input type = "text" id = "nom" name = "nom" value = "" size = "20"/>
		<br/>
		<label for = "password">Mot de passe<span class = "requis"></span></label>
		<input type = "password" id = "mdp" name = "mdp" value = "" size = "20"/>
		<br/>
		<input type = "submit" value = "Envoyer"/>		
	</fieldset>
</form>

<table>
<% 
if (!(request.getAttribute("users") == null)){
	ResultSet rs = (ResultSet)request.getAttribute("users");
	out.println("<tr><th>ID</th><th>Pseudo</th><th>Mot de passe</th><th></th><th></th></tr>");
	int i = 1;
	while(rs.next()){
		out.println("<tr>");
		out.println("<td>"+rs.getInt(1) + "</td>");
		out.println("<td>"+rs.getString(2) + "</td>");
		out.println("<td>"+ rs.getString(3) + "</td>");
		out.println("<form method=\"post\" action=\"UserDeleteServlet\" class=\"inline\">");
  		out.println("<td><button type=\"submit\" name=\"id\" value=\""+rs.getInt(1)+"\" class=\"link-button\">Supprimer</button></td></form>");
  		out.println("<form method=\"post\" action=\"UserModifyServlet\" class=\"inline\">");
  		out.println("<input type=\"hidden\" name=\"modif\" value=\"1\">");
  		out.println("<td><button type=\"submit\" name=\"id\" value=\""+rs.getInt(1)+"\" class=\"link-button\">Modifier</button></td></form>");
  		out.println("</tr>");
		}
	i++;
}
%>
</table>

</body>
</html>