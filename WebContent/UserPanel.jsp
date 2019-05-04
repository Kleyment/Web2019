<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/connection.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap.css">	
<title>Interface client</title>
</head>
<body>
<div class="containerforcontainer">
	<div class="container">
		<div class="navbar" id="navbar">
		<ul class="navbar-nav">
			<li class="nav-item items">
				<a class="nav-link faux-lien">Bienvenue Jean-Patrick</a>
			</li>
			<li class="nav-item items">
				<a class="nav-link" href="./Panier.jsp">Votre panier</a>
			</li>
		</ul>
	    </div>
		<div class="row">
			<h1 class="text-center">Produits</h1>
			<div class="mb-4" id="list">
			<% 
			if (!(request.getAttribute("products") == null)){
				ResultSet rs = (ResultSet)request.getAttribute("products");
				while(rs.next()){
			        out.println("<div class=\"produit\">");
			        out.println("<div class=\"row nomproduit\">");
			          out.println("<div class=\"col\"><strong>"+rs.getString(2)+"</strong></div>");
			        out.println("</div>");
			        out.println("<div class=\"row\">");
			          out.println("<div class=\"image col-sm-3\">");
			          	%>
			          	<img src="${pageContext.request.contextPath}/images/<%=rs.getString(4)%>"class="image" alt="Meme guy">
			          	<%
			          out.println("</div>");
			          out.println("<div class=\"description col-sm-5\">");
			            out.println("Description du produit");
			            out.println("<p>");
			              out.println("(Eventuellement date d'ajout au catalogue)");
			            out.println("</p>");
			            out.println("<p>");
			              out.println("Le produit trucmuche permet de trucmucher de la meilleur qualité");
			            out.println("</p>");
			          out.println("</div>");
			          out.println("<div class=\"col-sm-4 zone-prix\">");
			            out.println("<div class=\"prix\">Prix "+rs.getInt(3)+" €</div>");
			            out.println("<a id=\"btn-panier\" class=\"btn btn-primary float-right btn-lg\" onclick=\"addToCart("+rs.getInt(1)+");\" role=\"button\">");
			            out.println("<span class=\"glyphicon glyphicon-shopping-cart\"> Ajouter au panier</span></a>");
			          out.println("</div>");
			        out.println("</div>");
			      out.println("</div>");
				}
			}
			%>
			</div>
		</div>
	</div>
</div>
<script src="${pageContext.request.contextPath}/js/scriptForAjax.js"></script>
</body>
</html>