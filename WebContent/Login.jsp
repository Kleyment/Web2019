<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/connection.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap.css">	
<script type="text/javascript" src="${pageContext.request.contextPath}/js/sjcl.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/scriptForAjax.js"></script>
<title>Connexion</title>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="panel panel-default">
			<div class="panel-heading">Connexion</div>
			<div class="panel-body">
	        		<form id="form-password" method = "post" class="form-horizontal" action = "LoginServlet" onsubmit="return onValidatePassword()">
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
				              <button id="submit" type="submit" class="btn btn-default">Se connecter</button>
				            </div>
			          </div>
	        		</form>
			</div>
			
		</div>
	</div>
</div>
</body>
</html>