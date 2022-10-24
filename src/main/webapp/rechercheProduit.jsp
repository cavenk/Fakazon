<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String toastMessage = (String) request.getAttribute("toast");
%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Rechercher un produit</title>

	<%@include file="includes/head.jsp"%>

</head>
<body>

	<!-- Header -->
	<%@include file="includes/header.jsp"%>

	<!-- Main -->
	<div class="container-fluid mb-5 mt-1">
        <div class="row border-top px-xl-6"> 
       	    <!-- Sidebar  -->
            <%@include file="includes/sidebar.jsp"%>

            <!-- Main content -->
            <div class="col-lg-9 ">
                <div class="container-fluid pt-5 ">
                    <!-- Your content -->
                    <!-- PUT YOUR CONTENT, WILL APPEAR TO THE RIGHT OF SIDEBAR 9/12 col  -->
					<div class="row px-xl-5 pb-3 d-flex justify-content-center">

						<c:if test="${PRODUITS_LIST.size() == 0}" >
							<p class="text-center fs-1">Aucun produit trouver</p>
						</c:if>
						
						<c:if test="${PRODUITS_LIST.size() > 0}" >
							<!-- forEach -->
							<c:forEach var="produits" items="${PRODUITS_LIST}" varStatus="p" end="14">
							
								<!-- 1st Product showing -->
								<div class="col-lg-3 col-md-5 pb-1 card mb-4 mx-4 rounded-3 shadow-sm">
									<div class="card-header py-2 text-center">
										<h5 class="my-0 fw-normal">${produits.nom}</h5>
									</div>
									<div class="card-body text-center">
										<img class="card-img-top" src="${produits.image}" alt="Image Produit" style="height: 6rem; width: auto;">
										<h4 class="card-title pricing-card-title">${produits.prix}</h4>
										<ul class="list-unstyled my-2">
											<li>En stock: ${produits.quantite}</li>
										</ul>
										<button type="button" class="w-60 btn btn-md btn-light">J'achète</button>
									</div>
								</div>
							</c:forEach>
						</c:if>
					</div>
                </div>
            </div>
        </div>
    </div>  

    <!-- Footer -->
    <%@include file="includes/footer.jsp"%>


    <!-- Toast -->
    <div class="toast-container position-fixed bottom-0 end-0 p-3">
        <div id="liveToast" class="toast" role="alert" aria-live="assertive" aria-atomic="true">
            <div class="toast-header">
                <strong class="me-auto fs-4 ">Fakazon</strong>
                <small></small>
                <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
            </div>
            <div id="toastText" class="toast-body"><%= toastMessage == null ? "" : toastMessage %></div>
        </div>
    </div>

	<!-- Script Javascript -->
    <script src="./javascript/index.js"></script> 
</body>
</html>