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
				<a class="navbar-brand" href="cart.jsp"><img
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

</body>
</html>