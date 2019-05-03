<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<a class="nav-link" href="./Paner.jsp">Votre panier</a>
			</li>
		</ul>
	    </div>
		<div class="row">
			<h1 class="text-center">Produits</h1>
			<div class="mb-4" id="list">
	            <div class="produit">
	              <div class="row nomproduit">
	                <div class="col"><strong>Nom du produit</strong></div>
	              </div>
	              <div class="row">
	                <div class="image col-sm-3">
	                	<img src="${pageContext.request.contextPath}/images/test.jpg" class="image" alt="versusKleymanBossFight.png">
	                </div>
	                <div class="description col-sm-5">
	                  Description du produit
	                  <p>
	                    (Eventuellement date d'ajout au catalogue)
	                  </p>
	                  <p>
	                    Le produit trucmuche permet de trucmucher de la meilleur qualité
	                  </p>
	                </div>
	                <div class="col-sm-4 zone-prix">
	                  <div class="prix">Prix 5 €</div>
	                  <a id="btn-panier" class="btn btn-primary float-right btn-lg" href="./AddPanier.jsp" role="button">
	                  <span class="glyphicon glyphicon-shopping-cart"> Ajouter au panier</span></a>
	                </div>
	              </div>
	            </div>
			</div>
		</div>
	</div>
</div>
</body>
</html>