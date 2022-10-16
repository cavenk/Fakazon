<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Rechercher un produit</title>

<%@include file="includes/head.jsp"%>

</head>

<body>

	<%@include file="includes/header.jsp"%>

	<!-- Container Sidebar & product displayal  -->
	<div class="container-fluid mb-5 mt-1">
		<div class="row border-top px-xl-6">

			<!-- Sidebar 3 col  -->
			<div class="col-lg-2 d-none d-lg-block ms-4 mt-5">

				<!-- Nos catégories  -->
				<a
					class="btn d-flex align-items-center justify-content-between bg-light text-secondary text-decoration-none w-100"
					data-toggle="collapse" href=""
					style="height: 65px; margin-top: -1px; padding: 0 30px;">
					<h6 class="m-0">Nos categories</h6> <i></i>
				</a>

				<!-- Listes des catégos  -->
				<hr>
				<ul class="nav nav-pills flex-column mb-auto">
					<li><a href="#" class="nav-link link-dark text-secondary">
							Toutes les marques </a></li>
					<li><a href="#" class="nav-link link-dark text-secondary">
							Apple </a></li>
					<li><a href="#" class="nav-link link-dark text-secondary">
							Samsung </a></li>
					<li><a href="#" class="nav-link link-dark text-secondary">
							Google </a></li>
					<li><a href="#" class="nav-link link-dark text-secondary">
							Motorola </a></li>
					<li><a href="#" class="nav-link link-dark text-secondary">
							TCL </a></li>
					<li><a href="#" class="nav-link link-dark text-secondary">
							Nokia </a></li>
				</ul>
				<hr>
				<!-- End Listes des catégos  -->

				<!-- Dropdown Mon compte  -->
				<div class="dropdown">
					<a href="#"
						class="d-flex align-items-center link-dark text-decoration-none dropdown-toggle text-secondary"
						id="dropdownUser2" data-bs-toggle="dropdown" aria-expanded="false">
						<img src="https://github.com/mdo.png" alt="" width="32"
						height="32" class="rounded-circle me-2"> <strong>Mon
							compte</strong>
					</a>
					<ul class="dropdown-menu text-small shadow"
						aria-labelledby="dropdownUser2">
						<li><a class="dropdown-item" href="#">Mon profil</a></li>
						<li><a class="dropdown-item" href="#">Mes commandes</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item" href="#">Me déconnecter</a></li>
					</ul>
				</div>
				<!-- End Dropdown Mon compte  -->

			</div>
			<!-- End Sidebar 3/12 col  -->

			<!--  9/12 col  -->
			<div class="col-lg-9 ">

				<div class="container-fluid pt-5 ">

					<!-- TODO MAKE A LOOP TO PRINT DEPENDING EVERY PRODUCT IN DB **** -->
					<!-- TODO IN LOOP BUT A COND IF MORE THAN 3 PRODUCTS CREATE A NEW ROW **** -->
					
					<div class="row px-xl-5 pb-3 d-flex justify-content-center">
					
					<!-- forEach -->	
					<c:forEach var="produits" items="${PRODUITS_LIST}" varStatus="p" end="14" >
					
						<!-- 1st Product showing -->
					<div
						class="col-lg-3 col-md-5 pb-1 card mb-4 mx-4 rounded-3 shadow-sm">
						<div class="card-header py-2 text-center">
							<h5 class="my-0 fw-normal">${produits.nom}</h5>
						</div>
						<div class="card-body text-center">
							<img class="card-img-top" src="${produits.image}"
								alt="Image Produit" style="height: 6rem;width: auto;">
							<h4 class="card-title pricing-card-title">${produits.prix}</h4>
							<ul class="list-unstyled my-2">
								<li>En stock: ${produits.quantite}</li>
							</ul>
							<button type="button" class="w-60 btn btn-md btn-light">J'achète</button>
						</div>
					</div>
					
					<c:if test = "${p.count % 3==0}" > 
					
						</div>
						
						<div class="row px-xl-5 pb-3 d-flex justify-content-center">
						
						</c:if>

					<!-- End 1st Product showing -->
						</c:forEach>
						<!-- End forEach -->

					
					<!-- End 1st ROW -->
				</div>
				
			</div>
			<!-- Product showing 9 col  -->
		</div>
	</div>
	<!-- End Container Sidebar & product displayal  -->


	<%@include file="includes/footer.jsp"%>

</body>
</html>