<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
    String nom = request.getParameter("nom");
    String prenom = request.getParameter("prenom");
    String dateDeNaissance = request.getParameter("dateDeNaissance");
    String telephone = request.getParameter("telephone");
    String courriel = request.getParameter("courriel");
    String confirmerCourriel = request.getParameter("confirmerCourriel");
    String motDePasse = request.getParameter("motDePasse");
    String confirmerMotDePasse = request.getParameter("confirmerMotDePasse");

    String adresse = request.getParameter("adresse");
    String ville = request.getParameter("ville");
    String province = request.getParameter("province");
    String pays = request.getParameter("pays");
    String codePostal = request.getParameter("codePostal");

    String adresseLivraison = request.getParameter("adresseLivraison");
    String villeLivraison = request.getParameter("villeLivraison");
    String provinceLivraison = request.getParameter("provinceLivraison");
    String paysLivraison = request.getParameter("paysLivraison");
    String codePostalLivraison = request.getParameter("codePostalLivraison");

    String errorNom = (String) request.getAttribute("errorNom");
    String errorPrenom = (String) request.getAttribute("errorPrenom");
    String errorDateDeNaissance = (String) request.getAttribute("errorDateDeNaissance");
    String errorTelephone = (String) request.getAttribute("errorTelephone");
    String errorCourriel = (String) request.getAttribute("errorCourriel");
    String errorConfirmerCourriel = (String) request.getAttribute("errorConfirmerCourriel");
    String errorMotDePasse = (String) request.getAttribute("errorMotDePasse");
    String errorConfirmerMotDePasse = (String) request.getAttribute("errorConfirmerMotDePasse");

    String errorAdresse = (String) request.getAttribute("errorAdresse");
    String errorVille = (String) request.getAttribute("errorVille");
    String errorProvince = (String) request.getAttribute("errorProvince");
    String errorPays = (String) request.getAttribute("errorPays");
    String errorCodePostal = (String) request.getAttribute("errorCodePostal");

    String errorAdresseLivraison = (String) request.getAttribute("errorAdresseLivraison");
    String errorVilleLivraison = (String) request.getAttribute("errorVilleLivraison");
    String errorProvinceLivraison = (String) request.getAttribute("errorProvinceLivraison");
    String errorPaysLivraison = (String) request.getAttribute("errorPaysLivraison");
    String errorCodePostalLivraison = (String) request.getAttribute("errorCodePostalLivraison");


    
   
%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
  </head>
  <body>
    <!-- Header -->
	<%@include file="includes/header.jsp"%>

    <!-- Main content -->
    <form class="container" action="/fakazon/compte" method="post">
        <h2 class="text-center">Créer compte</h2>
        <div class="row justify-content-center">
            <div class="col-lg-6">
                <!-- Info générale -->
                <h4 class="mt-4">Information générale</h4>

                <div class="mb-1">
                    <label class="form-label">Nom</label>
                    <input type="text" class="form-control" name="nom" value=<%= nom == null ? "" : nom %>>
                    <div class="text-end text-danger fs-6"><%= errorNom == null ? "" : errorNom %> </div>
                </div>
                
                <div class="mb-1">
                    <label class="form-label">Prenom</label>
                    <input type="text" class="form-control" name="prenom" value=<%= prenom == null ? "" : prenom %>>
                    <div class="text-end text-danger fs-6"><%= errorPrenom == null ? "" : errorPrenom %> </div>
                </div>
                
                <div class="mb-1">
                    <label class="form-label">Date de naissance</label>
                    <input type="date" class="form-control" name="dateDeNaissance" value=<%= dateDeNaissance == null ? "" : dateDeNaissance %>>
                    <div class="text-end text-danger fs-6"><%= errorDateDeNaissance == null ? "" : errorDateDeNaissance %> </div>
                </div>
                
                <div class="mb-1">
                    <label class="form-label">Téléphone</label>
                    <input type="tel" class="form-control" name="telephone" value=<%= telephone == null ? "" : telephone %>>
                    <div class="text-end text-danger fs-6"><%= errorTelephone == null ? "" : errorTelephone %> </div>
                </div>

                <div class="mb-1">
                    <label class="form-label">Courriel</label>
                    <input type="email" class="form-control" name="courriel" value=<%= courriel == null ? "" : courriel %>>
                    <div class="text-end text-danger fs-6"><%= errorCourriel == null ? "" : errorCourriel %> </div>
                </div>

                <div class="mb-1">
                    <label class="form-label">Confirmer courriel</label>
                    <input type="email" class="form-control" name="confirmerCourriel" value=<%= confirmerCourriel == null ? "" : confirmerCourriel %>>
                    <div class="text-end text-danger fs-6"><%= errorConfirmerCourriel == null ? "" : errorConfirmerCourriel %> </div>
                </div>
    
                <div class="mb-1">
                    <label class="form-label">Mot de passe</label>
                    <input type="text" class="form-control" name="motDePasse" value=<%= motDePasse == null ? "" : motDePasse %>>
                    <div class="text-end text-danger fs-6"><%= errorMotDePasse == null ? "" : errorMotDePasse %> </div>
                </div>
        
                <div class="mb-1">
                    <label class="form-label">Confirmer mot de passe</label>
                    <input type="text" class="form-control" name="confirmerMotDePasse" value=<%= confirmerMotDePasse == null ? "" : confirmerMotDePasse %>>
                    <div class="text-end text-danger fs-6"><%= errorConfirmerMotDePasse == null ? "" : errorConfirmerMotDePasse %> </div>
                </div>

                <!-- Adresse -->
                <h4 class="mt-4">Adresse</h4>

                <div class="mb-1">
                    <label class="form-label">Adresse</label>
                    <input type="text" class="form-control" name="adresse" value=<%= adresse == null ? "" : adresse %>>
                    <div class="text-end text-danger fs-6"><%= errorAdresse == null ? "" : errorAdresse %> </div>
                </div>

                <div class="mb-1">
                    <label class="form-label">Ville</label>
                    <input type="text" class="form-control" name="ville" value=<%= ville == null ? "" : ville %>>
                    <div class="text-end text-danger fs-6"><%= errorVille == null ? "" : errorVille %> </div>
                </div>

                <div class="mb-1">
                    <label class="form-label">Province</label>
                    <input type="text" class="form-control" name="province" value=<%= province == null ? "" : province %>>
                    <div class="text-end text-danger fs-6"><%= errorProvince == null ? "" : errorProvince %> </div>
                </div>

                <div class="mb-1">
                    <label class="form-label">Pays</label>
                    <input type="text" class="form-control" name="pays" value=<%= pays == null ? "" : pays %>>
                    <div class="text-end text-danger fs-6"><%= errorPays == null ? "" : errorPays %> </div>
                </div>

                <div class="mb-1">
                    <label class="form-label">Code Postal</label>
                    <input type="text" class="form-control" name="codePostal" value=<%= codePostal == null ? "" : codePostal %>>
                    <div class="text-end text-danger fs-6"><%= errorCodePostal == null ? "" : errorCodePostal %> </div>
                </div>

                <!-- Adresse de livraison -->
                <h4 class="mt-4">Adresse de livraison</h4>

                <div class="mb-1">
                    <label class="form-label">Adresse</label>
                    <input type="text" class="form-control" name="adresseLivraison" value=<%= adresseLivraison == null ? "" : adresseLivraison %>>
                    <div class="text-end text-danger fs-6"><%= errorAdresseLivraison == null ? "" : errorAdresseLivraison %> </div>
                </div>
    
                <div class="mb-1">
                    <label class="form-label">Ville</label>
                    <input type="text" class="form-control" name="villeLivraison" value=<%= villeLivraison == null ? "" : villeLivraison %>>
                    <div class="text-end text-danger fs-6"><%= errorVilleLivraison == null ? "" : errorVilleLivraison %> </div>
                </div>
    
                <div class="mb-1">
                    <label class="form-label">Province</label>
                    <input type="text" class="form-control" name="provinceLivraison" value=<%= provinceLivraison == null ? "" : provinceLivraison %>>
                    <div class="text-end text-danger fs-6"><%= errorProvinceLivraison == null ? "" : errorProvinceLivraison %> </div>
                </div>
    
                <div class="mb-1">
                    <label class="form-label">Pays</label>
                    <input type="text" class="form-control" name="paysLivraison" value=<%= paysLivraison == null ? "" : paysLivraison %>>
                    <div class="text-end text-danger fs-6"><%= errorPaysLivraison == null ? "" : errorPaysLivraison %> </div>
                </div>
    
                <div class="mb-1">
                    <label class="form-label">Code Postal</label>
                    <input type="text" class="form-control" name="codePostalLivraison" value=<%= codePostalLivraison == null ? "" : codePostalLivraison %>>
                    <div class="text-end text-danger fs-6"><%= errorCodePostalLivraison == null ? "" : errorCodePostalLivraison %> </div>
                </div>

                <!-- Submit button -->
                <button type="submit" class="btn btn-primary mt-3">Enregistrer</button>

            </div>

        </div>

        
    </form>

    <!-- Bootstrap script -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
  </body>
</html>