<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@include file="includes/head.jsp"%>

<title>Ajouter produit</title>
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
	<h3 class="text-center mt-3">Ajouter un produit</h3>
	<br/>
	<div class="container-md">
		<form action="ProduitServletControleur" method="GET">
			<input type="hidden" name="action" value="AJOUTER" />
			<div class="mb-3 row">
			    <label for="inputNom" class="col-sm-2 col-form-label">Nom :</label>
			    <div class="col-sm-10">
			      <input type="text" name="nom" class="form-control" id="inputNom" required>
			    </div>
			 </div>
			 <div class="mb-3 row">
			    <label for="inputPrix" class="col-sm-2 col-form-label">Prix :</label>
			    <div class="col-sm-10">
			      <input type="number" name="prix" class="form-control" step="0.01" id="inputPrix" required>
			    </div>
			 </div>
			 <div class="mb-3 row">
			    <label for="inputImg" class="col-sm-2 col-form-label">Image :</label>
			    <div class="col-sm-10">
			      <input type="text" name="image" class="form-control" id="inputImg" required>
			    </div>
			 </div>
			 <div class="mb-3 row">
			    <label for="inputQte" class="col-sm-2 col-form-label">Quantité :</label>
			    <div class="col-sm-10">
			      <input type="number" name="quantite" class="form-control" id="inputQte" required>
			    </div>
			 </div>
			 <div class="mb-3 row">
			    <label for="inputCategorie" class="col-sm-2 col-form-label">Categorie :</label>
				    <div class="col-sm-10">
				    	<select class="form-select" name="idCategorie" id="inputategorie" required>
				    		<option selected disabled value="">Sélectionner une categorie</option>
							<c:forEach var="categorie" items="${CATEGORIE_LIST}">
								<option value="${categorie.idCategorie}">${categorie.nom}</option>
							</c:forEach>
						</select>
				    </div>
			 </div>
			 <br/>
			 <div class="col-12">
			 <a href="ProduitServletControleur" class="btn btn-light ps-5 pe-5 ms-3 float-end">Retourner</a>
			 <input class="btn btn-warning ps-5 pe-5 float-end ms-3" type="reset" value="Effacer" />
			 <input class="btn btn-success ps-5 pe-5 float-end" type="submit" value="Ajouter" />
			 </div>
		</form>
	</div>
</body>
</html>