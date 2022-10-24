<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@include file="includes/head.jsp"%>

<title>Liste des Categories</title>
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
				<h2 class="text-center">Gestion de categorie</h2>
				<br/>
				
				<a class="btn btn-light" href="indexAdministrateur.jsp">Retourner à l'accueil</a>
				<input type="button" value="Ajouter une categorie" class="btn btn-success ms-2"
						onclick="window.location.href='ajouterCategorie.jsp'; return false;"/>
				<br/><br/>
				
				
				<table class="table table-hover align-middle">
					<thead class="table-light">
						<tr class="text-center">
						<th>ID</th>
						<th>Nom</th>
						<th>Description</th>
						<th>Modifier</th>
						<th>Supprimer</th>
						</tr>
					</thead>
					
					<tbody class="table-group-divider">
						<c:forEach var="categorie" items="${CATEGORIE_LIST}">
					
						<c:url var="lienModifier" value="CategorieServletControleur">
							<c:param name="action" value="CHARGER"/>
							<c:param name="idCategorie" value="${categorie.idCategorie}"/>
						</c:url>
						
						<c:url var="lienSupprimer" value="CategorieServletControleur">
							<c:param name="action" value="SUPPRIMER" />
							<c:param name="idCategorie" value="${categorie.idCategorie}" />
						</c:url>
					
						<tr class="text-center">
							<td>${categorie.idCategorie}</td>
							<td>${categorie.nom}</td>
							<td>${categorie.description}</td>
							<td><a href="${lienModifier}" class="btn btn-primary">Modifier</a></td>
							<td><a href="${lienSupprimer}"
									onclick="if (!(confirm('Voulez vous supprimer cette categorie?'))) return false"
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