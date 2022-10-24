<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@include file="includes/head.jsp"%>

<title>Accueil administrateur</title>
</head>

<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg ">
	<div class="container-fluid">
		<!-- Logo -->
		<a class="navbar-brand" href="indexAdministrateur.jsp">
			<img alt="Logo image of Fakazon" src="Images/logo.png" height="70">
		</a>
		<a class="btn btn-danger" href="connexionControleur">Me déconnecter</a>
		<!-- Fin Logo -->
	</div>
</nav>


	<!-- Boutons Gestion Produit et Categorie -->
	<div class="row align-items-center vh-50">
		<div class="col text-center">
			<form action="ProduitServletControleur">
				<input class="btn btn-outline-dark mb-5" type="submit" value="Gestion de produits"/>	
			</form>
			<form action="CategorieServletControleur">
				<input class="btn btn-outline-dark" type="submit" value="Gestion de categories"/>	
			</form>
		</div>
	</div>
	<!-- Fin Boutons Gestion Produit et Categorie -->
</body>
</html>