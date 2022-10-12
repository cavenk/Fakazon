<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fakazon - Commerce en ligne</title>

<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">

<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
	crossorigin="anonymous" type="text/javascript"></script>

<style type="text/css">
.topnav a:hover {
	border-bottom: 3px solid rgba(128, 128, 128, 0.156);
}
</style>
</head>
<body>

	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg ">
		<div class="container-fluid topnav">

			<!-- Logo -->
			<a class="navbar-brand" href="#"><img alt="Logo image of Fakazon"
				src="Images/logo.png" height="70"></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<!-- Fin Logo -->

			<!-- Navbar menu-->
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-0 mb-lg-0">

					<li class="nav-item active"><a class="nav-link" href="#">Accueil
					</a></li>

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Mon compte </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">Voir mon profil</a> <a
								class="dropdown-item" href="#">Mes commandes</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">Me déconnecter</a></li>
						</ul></li>

					<li class="nav-item active"><a class="nav-link" href="#">Contactez-Nous
					</a></li>

				</ul>
				<form class="d-flex" role="search" action="">
					<input class="form-control me-2" type="search"
						placeholder="Rechercher un produit" aria-label="Search">
					<button class="btn btn-light" type="submit">Rechercher</button>
				</form>
				<!-- End Navbar menu  -->

				<!-- Img aimer un produit -->
				<a class="navbar-brand" href="#"><img
					alt="Image d'un petit coeur" src="Images/aimerProduitImg.png"
					height="30"></a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<!-- Fin Img aimer un produit -->

				<!-- Img Panier -->
				<a class="navbar-brand" href="#"><img
					alt="Image d'un petit panier" src="Images/cart.png" height="40"></a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<!-- Fin Img Panier -->
			</div>
		</div>
	</nav>
	<!-- End Navbar  -->


	<!-- Container Sidebar & product displayal  -->
	<div class="container-fluid">
	
	<!-- Sidebar -->
	<div class="d-flex flex-column flex-shrink-0 p-3 bg-light"
		style="width: 260px;">
		<a href="/"
			class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-dark text-secondary text-decoration-none">
			<svg class="bi me-2" width="40" height="32">
				<use xlink:href="#bootstrap"></use></svg> <span class="fs-4">Nos
				catégories</span>
		</a>
		<hr>
		<ul class="nav nav-pills flex-column mb-auto">

			<li><a href="#" class="nav-link link-dark text-secondary"> <svg
						class="bi me-2" width="16" height="16">
						<use xlink:href=""></use></svg> Toutes les marques
			</a></li>
			<li><a href="#" class="nav-link link-dark text-secondary"> <svg
						class="bi me-2" width="16" height="16">
						<use xlink:href="#speedometer2"></use></svg> Apple
			</a></li>
			<li><a href="#" class="nav-link link-dark text-secondary"> <svg
						class="bi me-2" width="16" height="16">
						<use xlink:href="#table"></use></svg> Samsung
			</a></li>
			<li><a href="#" class="nav-link link-dark text-secondary"> <svg
						class="bi me-2" width="16" height="16">
						<use xlink:href="#grid"></use></svg> Google
			</a></li>
			<li><a href="#" class="nav-link link-dark text-secondary"> <svg
						class="bi me-2" width="16" height="16">
						<use xlink:href="#people-circle"></use></svg> Motorola
			</a></li>
			<li><a href="#" class="nav-link link-dark text-secondary"> <svg
						class="bi me-2" width="16" height="16">
						<use xlink:href="#people-circle"></use></svg> TCL
			</a></li>
			<li><a href="#" class="nav-link link-dark text-secondary"> <svg
						class="bi me-2" width="16" height="16">
						<use xlink:href="#people-circle"></use></svg> Nokia
			</a></li>
		</ul>
		<hr>
		<div class="dropdown">
			<a href="#"
				class="d-flex align-items-center link-dark text-decoration-none dropdown-toggle text-secondary"
				id="dropdownUser2" data-bs-toggle="dropdown" aria-expanded="false">
				<img src="https://github.com/mdo.png" alt="" width="32" height="32"
				class="rounded-circle me-2"> <strong>Mon compte</strong>
			</a>
			<ul class="dropdown-menu text-small shadow"
				aria-labelledby="dropdownUser2">
				<li><a class="dropdown-item" href="#">Mon profil</a></li>
				<li><a class="dropdown-item" href="#">Mes commandes</a></li>
				<li><hr class="dropdown-divider"></li>
				<li><a class="dropdown-item" href="#">Me déconnecter</a></li>
			</ul>
		</div>
		<!-- End Sidebar -->
		</div>
		
		<!-- Product displayal -->
		<div class="row row-cols-1 row-cols-md-4 mb-3 text-center">
		<div class="col">
        <div class="card mb-3 rounded-3 shadow-sm">
          <div class="card-header py-3">
            <h4 class="my-0 fw-normal">Titre Produit</h4>
          </div>
          <div class="card-body">
          <img class="card-img-top" src="logo.png" alt="Image Produit">
            <h1 class="card-title pricing-card-title">$0<small class="text-muted fw-light">/mo</small></h1>
            <ul class="list-unstyled mt-3 mb-4">
              <li>Détails produits</li>
              <li>Détails produits</li>
              <li>Détails produits</li>
            </ul>
            <button type="button" class="w-75 btn btn-lg btn-light">J'achète</button>
          </div>
        </div>
      </div>
      </div>
		<!-- End Product displayal -->
		
	<!-- End Container Sidebar & product displayal  -->
	</div>
	
	<!-- Footer -->
	<div class="container text-secondary ">
		<footer class="py-5 ">
			<div class="row d-flex ">
				<div class="col-3 ">
					<h5>À propos de nous</h5>
					<ul class="nav flex-column">
						<li class="nav-item mb-2 "><a href="#"
							class="nav-link p-0 text-muted">Mission</a></li>
						<li class="nav-item mb-2"><a href="#"
							class="nav-link p-0 text-muted">Vision</a></li>
						<li class="nav-item mb-2"><a href="#"
							class="nav-link p-0 text-muted">Carrières</a></li>
						<li class="nav-item mb-2"><a href="#"
							class="nav-link p-0 text-muted">Infolettre</a></li>
						<li class="nav-item mb-2"><a href="#"
							class="nav-link p-0 text-muted">Commandites et partenaires</a></li>
					</ul>
				</div>

				<div class="col-3">
					<h5>Service à la clientèle</h5>
					<ul class="nav flex-column">
						<li class="nav-item mb-2"><a href="#"
							class="nav-link p-0 text-muted">Écrivez-nous</a></li>
						<li class="nav-item mb-2"><a href="#"
							class="nav-link p-0 text-muted">Appelez-nous</a></li>
						<li class="nav-item mb-2"><a href="#"
							class="nav-link p-0 text-muted">Politiques</a></li>
						<li class="nav-item mb-2"><a href="#"
							class="nav-link p-0 text-muted">FAQs</a></li>
					</ul>
				</div>

				<div class="col-2">
					<h5>Notre magasin</h5>
					<ul class="nav flex-column">
						<li class="nav-item mb-2"><a href="#"
							class="nav-link p-0 text-muted">Nous trouvez</a></li>
						<li class="nav-item mb-2"><a href="#"
							class="nav-link p-0 text-muted">Cartes cadeaux</a></li>
					</ul>
				</div>

				<div class="col-md-4 ">
					<form action="">
						<h5>Adhérer à notre infolettre</h5>
						<p>Restez à l'affut de toutes nouveautés</p>
						<div class="d-flex w-100 gap-1">
							<label for="newsletter1" class="visually-hidden">Email
								address</label> <input id="newsletter1" type="text" class="form-control"
								placeholder="Email address">
							<button class="btn btn-light" type="button">Envoyé</button>
						</div>
					</form>
				</div>
			</div>

			<div
				class="d-flex justify-content-between py-4 my-4 border-top text-secondary">
				<p>© 2022 Fakazon, Inc. Tous droits réservés.</p>
				<ul class="list-unstyled d-flex">
					<li class="ms-3"><a class="link-dark" href="#"><svg
								class="bi" width="24" height="24">
								<use xlink:href="#twitter"></use></svg></a></li>
					<li class="ms-3"><a class="link-dark" href="#"><svg
								class="bi" width="24" height="24">
								<use xlink:href="#instagram"></use></svg></a></li>
					<li class="ms-3"><a class="link-dark" href="#"><svg
								class="bi" width="24" height="24">
								<use xlink:href="#facebook"></use></svg></a></li>
				</ul>
			</div>
		</footer>
	</div>
	<!-- End Footer -->

</body>
</html>