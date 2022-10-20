
<!-- Navbar -->
<nav class="navbar navbar-expand-lg ">
	<div class="container-fluid topnav">

		<!-- Logo -->
		<a class="navbar-brand" href="#"><img alt="Logo image of Fakazon"
			src="Images/logo.png" height="70"></a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
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
						<li><a class="dropdown-item" href="#">Me d�connecter</a></li>
					</ul></li>

				<li class="nav-item active"><a class="nav-link" href="#">Contactez-Nous
				</a></li>

			</ul>
			<form class="d-flex" role="search" method="GET" action="rechercheProduitControleur" >
				<input class="form-control me-2" type="search"
					placeholder="Nom de produit" aria-label="Search" name="searchInput">
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
