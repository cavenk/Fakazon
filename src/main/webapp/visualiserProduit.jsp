<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// RechercheProduit pd = new RechercheProduit

%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Visualiser un produit</title>

<%@include file="includes/head.jsp"%>

<!-- STYLES CSS -->
<style type="text/css">
.table tbody td {
	vertical-align: middle;
}

.btn-incre, .btn-decre {
	box-shadow: none;
	font-size: 25px;
}
</style>


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

			<!-- PUT YOUR CONTENT IF ITS NOT PRODUCTS 9/12 col  -->
			<div class="col-lg-9 ">

				<div class="container-fluid pt-5 ">

					<!-- TODO MAKE A LOOP TO PRINT DEPENDING EVERY PRODUCT IN DB **** -->
					<!-- TODO IN LOOP BUT A COND IF MORE THAN 3 PRODUCTS CREATE A NEW ROW **** -->
					<div class="row px-xl-5 pb-3 d-flex justify-content-center">

						<!-- 1st Product showing -->
						<div
							class="col-lg-3 col-md-5 pb-1 card mb-4 mx-4 rounded-3 shadow-sm">
							<div class="card-header py-2 text-center">
								<h5 class="my-0 fw-normal">Titre Produit</h5>
							</div>
							<div class="card-body text-center">
								<img class="card-img-top" src="Images/logo.png"
									alt="Image Produit" height="100vw">
								<h4 class="card-title pricing-card-title">
									$0<small class="text-muted fw-light">/mo</small>
								</h4>
								<ul class="list-unstyled my-2">
									<li>Détails produits</li>
									<li>Détails produits</li>
								</ul>
								<button type="button" class="w-60 btn btn-md btn-light">J'achète</button>
							</div>
						</div>
						<!-- End 1st Product showing -->

						<!-- 2sd Product showing -->
						<div
							class="col-lg-3 col-md-5 pb-1 card mb-4 mx-4 rounded-3 shadow-sm">
							<div class="card-header py-2 text-center">
								<h5 class="my-0 fw-normal">Titre Produit</h5>
							</div>
							<div class="card-body text-center">
								<img class="card-img-top" src="Images/logo.png"
									alt="Image Produit" height="100vw">
								<h4 class="card-title pricing-card-title">
									$0<small class="text-muted fw-light">/mo</small>
								</h4>
								<ul class="list-unstyled my-2">
									<li>Détails produits</li>
									<li>Détails produits</li>
								</ul>
								<button type="button" class="w-60 btn btn-md btn-light">J'achète</button>
							</div>
						</div>
						<!-- End 2sd Product showing -->

						<!-- 3rd Product showing -->
						<div
							class="col-lg-3 col-md-5 pb-1 card mb-4 mx-4 rounded-3 shadow-sm">
							<div class="card-header py-2 text-center">
								<h5 class="my-0 fw-normal">Titre Produit</h5>
							</div>
							<div class="card-body text-center">
								<img class="card-img-top" src="Images/logo.png"
									alt="Image Produit" height="100vw">
								<h4 class="card-title pricing-card-title">
									$0<small class="text-muted fw-light">/mo</small>
								</h4>
								<ul class="list-unstyled my-2">
									<li>Détails produits</li>
									<li>Détails produits</li>
								</ul>
								<button type="button" class="w-60 btn btn-md btn-light">J'achète</button>
							</div>
						</div>
						<!-- End 3rd Product showing -->

					</div>
					<!-- End 1st ROW -->

					<!-- TODO IN LOOP BUT A COND IF MORE THAN 3 PRODUCTS CREATE A NEW ROW **** -->
					<div class="row px-xl-5 pb-3 d-flex justify-content-center">

						<!-- 4th Product showing in 2sd row -->
						<div
							class="col-lg-3 col-md-5 pb-1 card mb-4 mx-4 rounded-3 shadow-sm">
							<div class="card-header py-2 text-center">
								<h5 class="my-0 fw-normal">Titre Produit</h5>
							</div>
							<div class="card-body text-center">
								<img class="card-img-top" src="Images/logo.png"
									alt="Image Produit" height="100vw">
								<h4 class="card-title pricing-card-title">
									$0<small class="text-muted fw-light">/mo</small>
								</h4>
								<ul class="list-unstyled my-2">
									<li>Détails produits</li>
									<li>Détails produits</li>
								</ul>
								<button type="button" class="w-60 btn btn-md btn-light">J'achète</button>
							</div>
						</div>
						<!-- End 4th Product showing in 2sd row -->

					</div>
					<!-- End 2sd ROW -->

				</div>
			</div>
			<!-- Product showing 9 col  -->
		</div>
	</div>
	<!-- End Container Sidebar & product displayal  -->


	<%@include file="/includes/footer.jsp"%>

</body>
</html>