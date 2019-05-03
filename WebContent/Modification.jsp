<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import ="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/connection.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap.css">
<title>Modification</title>
</head>
<body>

<% ResultSet rs = null;
if (!(request.getAttribute("user") == null)){
		rs = (ResultSet)request.getAttribute("user");
		rs.next();
	}
%>
<div class="container">
	<div class="row">
		<div class="col-lg-6">
			<div class="panel panel-default">
				<div class="panel-heading">Modifier un utilisateur</div>
		        	<div class="panel-body">
		        		<form id="modify" class="form-horizontal" method="post" action = "UserModifyServlet">
			          		<div class="form-group">
					            <label for="pseudo" class="col-lg-2 control-label">Pseudo</label>
					            <div class="col-lg-10">
			            			<input type = "text" class="form-control" id = "pseudo" name = "pseudo" value = "<% out.println(rs.getString(2)); %>" size = "20" placeholder="Pseudo"/>
					            </div>
				          	</div>
				          	<div class="form-group">
					            <label for="password" class="col-lg-2 control-label">Mot de passe</label>
					            <div class="col-lg-10">
				              	<input type = "password" class="form-control" id = "password" name = "password" value="<% out.println(rs.getString(3)); %> " size = "20" placeholder="Mot de Passe"/>
				            </div>
				          </div>
				          <div class="form-group">
					            <label for="role" class="col-lg-2 control-label">Role</label>
					            <div class="col-lg-10">			 
								    <select name="role" class="form-control">
										<option value="user" <%if (rs.getString(4).contentEquals("user")) { out.println("selected=\"selected\"");} %>>Utilisateur</option>
										<option value="admin"<%if (rs.getString(4).contentEquals("admin")) { out.println("selected=\"selected\"");} %>>Administrateur</option>
									</select>
									<button id="submit" type="submit" class="btn btn-default">Modifier</button>
						   		</div>
							</div>
		        		</form>
					</div>
			</div>
		</div>
	</div>
</div>
<!--  
<form method = "post" action = "UserModifyServlet">
	<fieldset>
		<legend> Modification </legend>
		<label for = "pseudo">Pseudo<span class = "requis"></span></label>
		<input type = "text" id = "pseudo" name = "pseudo" value = "<% out.println(rs.getString(2)); %>" size = "20"/>
		<br/>
		<label for = "password">Mot de passe<span class = "requis"></span></label>
		<input type = "password" id = "password" name = "password" value = "<% out.println(rs.getString(3)); %> " size = "20"/>
		<br/>
		<input type = "submit" value = "Envoyer"/>		
	</fieldset>
</form>-->

</body>
</html>

