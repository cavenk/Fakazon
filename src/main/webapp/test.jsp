<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Listes des produits</title>

<%@include file="includes/head.jsp"%>
</head>

<table>

	<tr>
		<th>idProduit</th>
		<th>nom</th>
		<th>prix</th>
		<th>image</th>
		<th>quantite</th>
		<th>idCategorie</th>
	</tr>

	<c:forEach var="produit" items="${PRODUITS_LIST}">

		<tr>
			<td>${produit.idProduit}</td>
			<td>${produit.nom}</td>
			<td>${produit.prix}</td>
			<td>${produit.image}</td>
			<td>${produit.quantite}</td>
			<td>${produit.idCategorie}</td>
		</tr>

	</c:forEach>

</table>

<body>

</body>
</html>