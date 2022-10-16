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

	<c:forEach var="produits" items="${PRODUITS_LIST}">

		<tr>
			<td>${produits.idProduit}</td>
			<td>${produits.nom}</td>
			<td>${produits.prix}</td>
			<td>${produits.image}</td>
			<td>${produits.quantite}</td>
			<td>${produits.idCategorie}</td>
		</tr>

	</c:forEach>

</table>

<body>

</body>
</html>