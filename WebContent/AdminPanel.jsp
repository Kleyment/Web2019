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
		<div class="col-lg-6">
			<div class="panel panel-default">
				<div class="panel-heading">Inscrire un utilisateur</div>
		        	<div class="panel-body">
		        		<form class="form-horizontal" method="post" action = "UserInsertServlet">
			          		<div class="form-group">
					            <label for="pseudo" class="col-lg-2 control-label">Pseudo</label>
					            <div class="col-lg-10">
					              <input type="text" class="form-control" id="pseudo" name="pseudo" value="" placeholder="Pseudo">
					            </div>
				          	</div>
				          	<div class="form-group">
					            <label for="password" class="col-lg-2 control-label">Mot de passe</label>
					            <div class="col-lg-10">
					              <input type="password" class="form-control" id="password" name="password" value="" placeholder="Mot de Passe" >
					            </div>
				          </div>
				          <div class="form-group">
					            <label for="role" class="col-lg-2 control-label">Role</label>
					            <div class="col-lg-10">			 
								    <select name="role" class="form-control">
										<option value="user">Utilisateur</option>
										<option value="admin">Administrateur</option>
									</select>
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
	out.println("<thead><tr><th>ID</th><th>Pseudo</th><th>Mot de passe</th><th>Role</th><th></th><th></th></tr></thead><tbody>");
	while(rs.next()){
		out.println("<tr>");
		out.println("<td>"+rs.getInt(1) + "</td>");
		out.println("<td>"+rs.getString(2) + "</td>");
		out.println("<td>"+ rs.getString(3) + "</td>");
		out.println("<td>"+ rs.getString(4) + "</td>");
		out.println("<form method=\"post\" action=\"UserModifyServlet\" class=\"inline\">");
  		out.println("<input type=\"hidden\" name=\"modif\" value=\"1\">");
  		out.println("<td><button type=\"submit\" name=\"id\" value=\""+rs.getInt(1)+"\" class=\"btn btn-primary style-bouton\"><span class=\"glyphicon glyphicon-edit\"/> <span class=\"style-bouton\">Editer</button></td></form>");
  		out.println("<form method=\"post\" action=\"UserDeleteServlet\" class=\"inline\">");
  		out.println("<td><button type=\"submit\" name=\"id\" value=\""+rs.getInt(1)+"\" class=\"btn btn-danger style-bouton\"><span class=\"glyphicon glyphicon-ban-circle\"/> <span class=\"style-bouton\">Supprimer</button></td></form>");
  		out.println("</tr>");
	}
	out.println("</tbody>");
}
%>
		</table>
		</div>
		<div class="col-lg-6">
			<div class="panel panel-default">
				<div class="panel-heading">Ajouter un produit</div>
		        	<div class="panel-body">
		        		<form class="form-horizontal" method="post" action = "ProductInsertServlet">
			          		<div class="form-group">
					            <label for="pseudo" class="col-lg-2 control-label">Nom</label>
					            <div class="col-lg-10">
					              <input type="text" class="form-control" id="name" name="name" value="" placeholder="Nom">
					            </div>
				          	</div>
				          	<div class="form-group">
					            <label for="price" class="col-lg-2 control-label">Prix</label>
					            <div class="col-lg-10">
					              <input type="text" class="form-control" id="price" name="price" value="" placeholder="10.5" >					              
					            </div>
				          </div>
				          <div class="form-group">
					            <label for="image" class="col-lg-2 control-label">Nom de l'image</label>
					            <div class="col-lg-10">
					              <input type="text" class="form-control" id="image" name="image" value="" placeholder="Image.jpg">
					              <button id="submit" type="submit" class="btn btn-default">Ajouter</button>
					            </div>
				          	</div>
		        		</form>
					</div>
				</div>
	
	<table class="table table-hover">	
<% 
if (!(request.getAttribute("products") == null)){
	ResultSet rsProducts = (ResultSet)request.getAttribute("products");
	out.println("<thead><tr><th>ID</th><th>Nom</th><th>Prix</th><th></th><th></th><th></th></tr></thead><tbody>");
	while(rsProducts.next()){
		out.println("<tr>");
		out.println("<td>"+rsProducts.getInt(1) + "</td>");
		out.println("<td>"+rsProducts.getString(2) + "</td>");
		out.println("<td>"+ rsProducts.getDouble(3) + " €</td>");
		out.println("<td>");
		if (!(rsProducts.getString(4) == null)){
			%>
			<img src="${pageContext.request.contextPath}/images/<%=rsProducts.getString(4)%>" class="image">
			<%
		}
		out.println("</td>");
		out.println("<form method=\"post\" action=\"ProductModifyServlet\" class=\"inline\">");
  		out.println("<input type=\"hidden\" name=\"modif\" value=\"1\">");
  		out.println("<td><button type=\"submit\" name=\"id\" value=\""+rsProducts.getInt(1)+"\" class=\"btn btn-primary style-bouton\"><span class=\"glyphicon glyphicon-edit\"/> <span class=\"style-bouton\">Editer</button></td></form>");
  		out.println("<form method=\"post\" action=\"ProductDeleteServlet\" class=\"inline\">");
  		out.println("<td><button type=\"submit\" name=\"id\" value=\""+rsProducts.getInt(1)+"\" class=\"btn btn-danger style-bouton\"><span class=\"glyphicon glyphicon-ban-circle\"/> <span class=\"style-bouton\">Supprimer</span></button></td></form>");
  		out.println("</tr>");
	}
	out.println("</tbody>");
}
%>		</table>
		</div>
	</div>
</div>
</body>
</html>