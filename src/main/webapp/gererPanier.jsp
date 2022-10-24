<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Page Panier</title>

<%@include file="includes/head.jsp"%>

</head>

<body>
	<%@include file="/includes/header.jsp"%>
	
	

	<div class="container">
		<div class="d-flex py-3">
		</div>
		<table class="table table-light">
			<thead>
				<tr>
					<th>Nom du Produit</th>
					<th>Prix</th>
					<th>Quantité</th>
				</tr>
			</thead>
			<tbody>
				<!-- forEach -->
				<c:forEach var="produitPanier" items="${listePanier}" varStatus="p">
				
					<c:set var="prixTotalParProd" scope="request" 
					value="${produitPanier.prix *listeQuantiteParProd[p.count-1]}" />
					
					<c:set var="prixTotalPanier" scope="request" 
					value="${prixTotalPanier = prixTotalPanier + prixTotalParProd }" />
					<tr>
						<td>${produitPanier.nom}</td>
						<td>${produitPanier.prix}</td>
						<td>
							<form class="form-inline">
								<!-- <input type="hidden" name="id" value="1" class="form-input" > -->
								<div class="form-group d-flex justify-content-between">

									<c:url var="decrementeQty"
										value="gererPanierControleur">
										<c:param name="action" value="decrementerQty" />
										<c:param name="idProduit" value="${produitPanier.idProduit}" />
									</c:url>

									<a href='<c:out value="${decrementeQty}"/>' class="btn btn-sm btn-decre" >
									<i class="fas fa-minus-square"></i>
									</a> 
									
									<input type="text" name="quantite" class="form-control"
										value="${listeQuantiteParProd[p.count-1]}" readonly>
									
									<c:url var="incrementeQty"
										value="gererPanierControleur">
										<c:param name="action" value="ajouterPanier" />
										<c:param name="idProduit" value="${produitPanier.idProduit}" />
									</c:url>
									 
									 <a href='<c:out value="${incrementeQty}"/>' class="btn btn-sm btn-incre">
									 <i class="fas fa-plus-square"></i> 
									 </a>
								</div>

							</form>
						</td>
					</tr>
				</c:forEach>
				<!-- End forEach -->
			<h3>Prix total: ${prixTotalPanier}</h3>
			</tbody>
			
		</table>

		<div class="container-fluid pt-2 d-flex align-items-center col-lg-4">
			<a class="mx-3 btn btn-light" href="rechercheProduitControleur">
				continuer à magasiner</a> <a class="mx-3 btn btn-light"
				href="AcheterProduitControleur"> Acheter</a>
		</div>

	</div>
	<%@include file="/includes/footer.jsp"%>
</body>
</html>