<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import ="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/connection.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap.css">
<title>Modification Produit</title>
</head>
<body>

<% ResultSet rs = null;
if (!(request.getAttribute("product") == null)){
		rs = (ResultSet)request.getAttribute("product");
		rs.next();
	}
%>
<div class="container">
	<div class="row">
		<div class="col-lg-6">
			<div class="panel panel-default">
				<div class="panel-heading">Modifier un produit</div>
		        	<div class="panel-body">
		        		<form id="modify" class="form-horizontal" method="post" action = "ProductModifyServlet">
			          		<div class="form-group">
					            <label for="name" class="col-lg-2 control-label">Nom</label>
					            <div class="col-lg-10">
			            			<input type = "text" class="form-control" id = "name" name = "name" value = "<% out.println(rs.getString(2)); %>" size = "20" placeholder="Name"/>
					            </div>
				          	</div>
				          	<div class="form-group">
					            <label for="price" class="col-lg-2 control-label">Prix</label>
					            <div class="col-lg-10">
				              		<input type = "text" class="form-control" id = "price" name = "price" value="<% out.println(rs.getDouble(3)); %> " size = "20" placeholder="0.0"/>
				            	</div>
				            </div>
				            <div class="form-group">
					            <label for="image" class="col-lg-2 control-label">Nom de l'image</label>
					            <div class="col-lg-10">
				              	<input type = "text" class="form-control" id = "image" name = "image" value="<% if (!(rs.getString(4) == null)) {out.println(rs.getString(4));} %> " size = "20" placeholder="Image.jpg"/>
				            </div>
				            </div>
				            <div class="form-group">
					            <label for="description" class="col-lg-2 control-label">Description</label>
					            <div class="col-lg-10">
				         		<textarea class="form-control" id = "description" name = "description" placeholder="Description"><% if (!(rs.getString(5) == null)) {out.println(rs.getString(5));} %></textarea>
					         	<button id="submit" type="submit" class="btn btn-default">Modifier</button>	 					         	
				            </div>				            
				          </div>				
		        		</form>
		        		<button id="cancel" class="btn btn-danger" onclick="location.href='Login.jsp'">Annuler</button>
					</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>

