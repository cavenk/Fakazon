<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@include file="includes/head.jsp"%>

<title>Ajouter categorie</title>
</head>
<body>
	<nav class="navbar navbar-light bg-light">
  		<div>
    		<a href="#">
      			<img class="ms-3" src="Images/logo.png" alt="" height="70">
    		</a>
  		</div>
	</nav>
	<br/>
	<a class="btn btn-light ms-3" href="indexAdministrateur.jsp">Retourner à l'accueil</a>
	<h3 class="text-center mt-3">Ajouter une categorie</h3>
	<br/>
	<div class="container-md">
		<form action="CategorieServletControleur" method="GET">
			<input type="hidden" name="action" value="AJOUTER" />
			<div class="mb-3 row">
			    <label for="inputNom" class="col-sm-2 col-form-label">Nom :</label>
			    <div class="col-sm-10">
			      <input type="text" name="nom" class="form-control" id="inputNom" required>
			    </div>
			 </div>
			 <div class="mb-3 row">
			    <label for="inputDesc" class="col-sm-2 col-form-label">Description :</label>
			    <div class="col-sm-10">
			      <input type="text" name="description" class="form-control" step="0.01" id="inputDesc" required>
			    </div>
			 </div>
			 <br/>
			 <div class="col-12">
			 <a href="CategorieServletControleur" class="btn btn-light ps-5 pe-5 ms-3 float-end">Retourner</a>
			 <input class="btn btn-warning ps-5 pe-5 float-end ms-3" type="reset" value="Effacer" />
			 <input class="btn btn-success ps-5 pe-5 float-end" type="submit" value="Ajouter" />
			 </div>
		</form>
	</div>
</body>
</html>