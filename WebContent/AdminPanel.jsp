<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/connection.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap.css">
<script id="twitter-wjs" src="${pageContext.request.contextPath}/widgets.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap.js"></script>
<title>Panneau Administrateur</title>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="panel panel-default">
			<div class="panel-heading">Inscrire un utilisateur</div>
	        	<div class="panel-body">
	        		<form class="form-horizontal" action = "UserServlet">
		          		<div class="form-group">
				            <label for="pseudo" class="col-lg-2 control-label">Pseudo</label>
				            <div class="col-lg-10">
				              <input type="text" class="form-control" id="nom" name="nom" value="" placeholder="Pseudo">
				            </div>
			          	</div>
			          	<div class="form-group">
				            <label for="password" class="col-lg-2 control-label">Mot de passe</label>
				            <div class="col-lg-10">
				              <input type="password" class="form-control" id="mdp" name="mdp" value="" placeholder="Mot de Passe" >
				              <button id="submit" type="submit" class="btn btn-default">Ajouter</button>
				            </div>
			          </div>
	        		</form>
				</div>
		</div>
		<table class="table table-hover">
<% 
if (!(request.getAttribute("users") == null)){
	ResultSet rs = (ResultSet)request.getAttribute("users");
	out.println("<thead><tr><th>ID</th><th>Pseudo</th><th>Mot de passe</th><th></th><th></th></tr></thead><tbody>");
	while(rs.next()){
		out.println("<tr>");
		out.println("<td>"+rs.getInt(1) + "</td>");
		out.println("<td>"+rs.getString(2) + "</td>");
		out.println("<td>"+ rs.getString(3) + "</td>");
		out.println("<form method=\"post\" action=\"UserDeleteServlet\" class=\"inline\">");
  		out.println("<td><button type=\"submit\" name=\"id\" value=\""+rs.getInt(1)+"\" class=\"btn btn-primary\"><span class=\"glyphicon glyphicon-edit\"> Editer</span></button></td></form>");
  		out.println("<form method=\"post\" action=\"UserModifyServlet\" class=\"inline\">");
  		out.println("<input type=\"hidden\" name=\"modif\" value=\"1\">");
  		out.println("<td><button type=\"submit\" name=\"id\" value=\""+rs.getInt(1)+"\" class=\"btn btn-danger\"><span class=\"glyphicon glyphicon-ban-circle\"> Supprimer</span></button></td></form>");
  		out.println("</tr>");
	}
	out.println("</tbody>");
}
%>
		</table>
	</div>
</div>
</body>
</html>