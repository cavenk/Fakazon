<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="includes/head.jsp"%>
<title>Erreur</title>
</head>
<body>
    <!-- Header -->
	<%@include file="includes/header.jsp"%>

    <!-- Main -->
	<div class="container-fluid mb-5 mt-1">
        <div class="row">
            <p class="text-center fs-1">Une erreur inconnue s'est produite</p>
            <br>
            <a class="text-center" href="rechercheProduitControleur">Retourner à la page d'acceuil</a>
        </div>
    </div>
</body>
</html>