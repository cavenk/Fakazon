<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>

    <!-- For bootsrap -->
	<%@include file="includes/head.jsp"%>
  </head>
  <body>
    <!-- Header -->
	<%@include file="includes/header.jsp"%>

    <!-- Main content -->
    <form class="container" action="connexionControleur" method="post">
        <h2 class="text-center">Login</h2>
        <div class="row justify-content-center">
            <div class="col-lg-6">

                <div class="mb-1">
                    <label class="form-label">Courriel</label>
                    <input type="email" class="form-control" name="courriel" value="${param.courriel}">
                    <c:if test="${courrielError != null}" > 
                        <div class="text-end text-danger fs-6">${courrielError} </div>
                    </c:if>
                </div>

                <div class="mb-1">
                    <label class="form-label">Mot de passe</label>
                    <input type="text" class="form-control" name="motDePasse" value="${param.motDePasse}">
                    <c:if test="${motDePasseError != null}" > 
                        <div class="text-end text-danger fs-6">${motDePasseError} </div>
                    </c:if>
                </div>

                <input type="hidden" name="origin" value="${requestScope['jakarta.servlet.forward.request_uri']}"  >

                <!-- Link to register page -->
                <p class="text-center">Vous n'êtes pas membre? <a href="register.jsp">Créer un compte</a></p>
                
                <!-- Submit button -->
                <button type="submit" class="btn btn-primary mt-3">Login</button>

            </div>

        </div>

        
    </form>

    <!-- Bootstrap script -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
  </body>
</html>