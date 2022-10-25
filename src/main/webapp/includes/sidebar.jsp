<!-- Sidebar 3 col  -->
<div class="col-lg-3 d-none d-lg-block mt-3">

    <!-- Nos catégories  -->
    <div
        class="d-flex align-items-center justify-content-between ht text-bg-ligsecondary text-decoration-none w-100"
        data-toggle="collapse"
        style="height: 65px; margin-top: -1px; padding: 0 30px;">
        <h6 class="m-0">Nos categories</h6>
    </div>

    <!-- Listes des catégos  -->
    <hr>
    <ul class="nav nav-pills flex-column mb-auto">
        <li><a href="rechercheProduitControleur" class="nav-link link-dark text-secondary">
                Toutes les marques </a></li>

        <c:forEach var="category" items="${CATEGORY_LIST}" varStatus="p" end="14">
                <li>
                <a href="rechercheProduitControleur?category=${category.getIdCategorie()}" class="nav-link link-dark text-secondary">${category.getNom()} </a>
                </li>                   
        </c:forEach>
        
        <!-- <li><a href="rechercheProduitControleur?category=2" class="nav-link link-dark text-secondary">
                Samsung </a></li>
        <li><a href="#" class="nav-link link-dark text-secondary">
                Google </a></li>
        <li><a href="#" class="nav-link link-dark text-secondary">
                Motorola </a></li>
        <li><a href="#" class="nav-link link-dark text-secondary">
                TCL </a></li>
        <li><a href="#" class="nav-link link-dark text-secondary">
                Nokia </a></li> -->
    </ul>
    <hr>
    <!-- End Listes des catégos  -->

</div>
<!-- End Sidebar 3/12 col  -->