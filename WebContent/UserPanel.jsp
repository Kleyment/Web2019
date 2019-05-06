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
		<div class="navbar navbar-default navbar-static-top">
	      <div class="container">
	        <div class="navbar-header">
	          <a id="catalogue" class="navbar-brand" href="#">Catalogue</a>
	        </div>
	        
	        <div class="navbar-collapse header-collapse">
	          <ul class="nav navbar-nav">
	          	<span><a class="nav-link faux-lien padding-right">Bienvenue <% out.print(request.getAttribute("pseudoUser")); %></a></span>
                <span class="nav-link liste-item"><a href="${pageContext.request.contextPath}/CartServlet">Panier</a></span>
                <span class="nav-link liste-item deconnecter"><a href="${pageContext.request.contextPath}/DeconnectServlet">Se déconnecter</a></span>
	          </ul>
			</div>
	      </div>
		</div>
		<!--<div class="navbar" id="navbar">
		<ul class="navbar-nav">
			<li class="nav-item items">
				<a class="nav-link faux-lien">Bienvenue <% out.print(request.getAttribute("pseudoUser")); %></a>
			</li>
			<li class="nav-item items">
				<a class="nav-link" href="${pageContext.request.contextPath}/Panier.jsp">Votre panier</a>
			</li>
		</ul> -->
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
			          	<img src="${pageContext.request.contextPath}/images/<%=rs.getString(4)%>"class="image-user" alt="<%=rs.getString(2)%>">
			          	<%
			          out.println("</div>");
			          out.println("<div class=\"description col-sm-5\">");
			            out.println("<p>");
			            if (!(rs.getString(5) == null)){
			    			out.println(rs.getString(5));
			    		}
			            out.println("</p>");
			          out.println("</div>");
			          out.println("<div class=\"col-sm-3 zone-prix\">");
			            out.println("<div class=\"prix\">Prix "+rs.getDouble(3)+" €</div>");
			            out.println("<a id=\"btn-panier\" class=\"btn btn-primary float-right btn-lg style-bouton\" onclick=\"addToCart("+rs.getInt(1)+");\" role=\"button\">");
			            out.println("<span class=\"glyphicon glyphicon-shopping-cart\"/> <span class=\"style-bouton\">Ajouter au panier</span></a>");
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