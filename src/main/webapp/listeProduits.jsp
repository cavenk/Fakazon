<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@include file="includes/head.jsp"%>

<title>Liste des Produits</title>
</head>
<body>

	<nav class="navbar navbar-light bg-light">
  		<div>
    		<a href="#">
      			<img class="ms-3" src="Images/logo.png" alt="" height="70">
    		</a>
  		</div>
	</nav>
	
	<div class="container-fluid">
		<div class="row">
			<div class="col">
				<br/>
				<h2 class="text-center">Gestion de produit</h2>
				<br/>
		
					<form action="ProduitServletControleur" method="GET">
						<a class="btn btn-light" href="indexAdministrateur.jsp">Retourner à l'accueil</a>
						<input type="hidden" name="action" value="AJOUTERPRODUIT" />
						<input class="btn btn-success ms-2" type="submit" value="Ajouter un produit" />
					</form>
				<br/>
		
			<table class="table table-hover align-middle">
				<thead class="table-light">
					<tr class="text-center">
						<th>ID</th>
						<th>Nom</th>
						<th>Prix</th>
						<th>Image</th>
						<th>Quantite</th>
						<th>Categorie</th>
						<th>Modifier</th>
						<th>Supprimer</th>
					</tr>
				</thead>
				<tbody class="table-group-divider">
					
					<c:forEach var="produit" items="${PRODUIT_LIST}">
					
						<c:url var="lienModifier" value="ProduitServletControleur">
							<c:param name="action" value="CHARGER"/>
							<c:param name="idProduit" value="${produit.idProduit}"/>
						</c:url>
						
						<c:url var="lienSupprimer" value="ProduitServletControleur">
							<c:param name="action" value="SUPPRIMER" />
							<c:param name="idProduit" value="${produit.idProduit}" />
						</c:url>
					
					<tr class="text-center">
						<td>${produit.idProduit}</td>
						<td>${produit.nom}</td>
						<td>${produit.prix}</td>
						<td><img src="${produit.image}" width="50" height="60"/></td>
						<td>${produit.quantite}</td>
						<td>${produit.idCategorie}</td>
						<td><a href="${lienModifier}" class="btn btn-primary">Modifier</a></td>
						<td><a href="${lienSupprimer}"
								onclick="if (!(confirm('Voulez vous supprimer cet enregistrement?'))) return false"
								class="btn btn-danger">Supprimer</a>	
						</td>
					</tr>
					
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	</div>
</body>
</html>