<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@include file="includes/head.jsp"%>
    <title>Créer compte</title>
  </head>
  <body>
    <!-- Header -->
	<%@include file="includes/header.jsp"%>

    <!-- Main content -->
    <form class="container" action="compteControleur" method="post">
        <h2 class="text-center">Créer compte</h2>
        <div class="row justify-content-center">
            <div class="col-lg-6">
                <!-- action -->
                <input type="hidden" class="form-control" name="action" value="create">

                <!-- Info générale -->
                <h4 class="mt-4">Information générale</h4>

                <div class="mb-1">
                    <label class="form-label">Nom</label>
                    <input type="text" class="form-control" name="nom" value=${param.nom}>
                    <div class="text-end text-danger fs-6">${errorNom}</div>
                </div>
                
                <div class="mb-1">
                    <label class="form-label">Prenom</label>
                    <input type="text" class="form-control" name="prenom" value=${param.prenom}>
                    <div class="text-end text-danger fs-6">${errorPrenom}</div>
                </div>
                
                <div class="mb-1">
                    <label class="form-label">Date de naissance</label>
                    <input type="date" class="form-control" name="dateDeNaissance" value=${param.dateDeNaissance}>
                    <div class="text-end text-danger fs-6">${errorDateDeNaissance}</div>
                </div>
                
                <div class="mb-1">
                    <label class="form-label">Téléphone</label>
                    <input type="tel" class="form-control" name="telephone" value=${param.telephone}>
                    <div class="text-end text-danger fs-6">${errorTelephone}</div>
                </div>

                <div class="mb-1">
                    <label class="form-label">Courriel</label>
                    <input type="email" class="form-control" name="courriel" value=${param.courriel}>
                    <div class="text-end text-danger fs-6">${errorCourriel}</div>
                </div>

                <div class="mb-1">
                    <label class="form-label">Confirmer courriel</label>
                    <input type="email" class="form-control" name="confirmerCourriel" value=${param.confirmerCourriel}>
                    <div class="text-end text-danger fs-6">${errorConfirmerCourriel}</div>
                </div>
    
                <div class="mb-1">
                    <label class="form-label">Mot de passe</label>
                    <input type="text" class="form-control" name="motDePasse" value=${param.motDePasse}>
                    <div class="text-end text-danger fs-6">${errorMotDePasse}</div>
                </div>
        
                <div class="mb-1">
                    <label class="form-label">Confirmer mot de passe</label>
                    <input type="text" class="form-control" name="confirmerMotDePasse" value=${param.confirmerMotDePasse}>
                    <div class="text-end text-danger fs-6">${errorConfirmerMotDePasse}</div>
                </div>

                <!-- Adresse -->
                <h4 class="mt-4">Adresse</h4>

                <div class="mb-1">
                    <label class="form-label">Adresse</label>
                    <input type="text" class="form-control" name="adresse" value=${param.adresse}>
                    <div class="text-end text-danger fs-6">${errorAdresse}</div>
                </div>

                <div class="mb-1">
                    <label class="form-label">Ville</label>
                    <input type="text" class="form-control" name="ville" value=${param.ville}>
                    <div class="text-end text-danger fs-6">${errorVille}</div>
                </div>

                <div class="mb-1">
                    <label class="form-label">Province</label>
                    <input type="text" class="form-control" name="province" value=${param.province}>
                    <div class="text-end text-danger fs-6">${errorProvince}</div>
                </div>

                <div class="mb-1">
                    <label class="form-label">Pays</label>
                    <input type="text" class="form-control" name="pays" value=${param.pays}>
                    <div class="text-end text-danger fs-6">${errorPays}</div>
                </div>

                <div class="mb-1">
                    <label class="form-label">Code Postal</label>
                    <input type="text" class="form-control" name="codePostal" value=${param.codePostal}>
                    <div class="text-end text-danger fs-6">${errorCodePostal}</div>
                </div>

                <!-- Adresse de livraison -->
                <h4 class="mt-4">Adresse de livraison</h4>

                <div class="mb-1">
                    <label class="form-label">Adresse</label>
                    <input type="text" class="form-control" name="adresseLivraison" value=${param.adresseLivraison}>
                    <div class="text-end text-danger fs-6">${errorAdresseLivraison}</div>
                </div>
    
                <div class="mb-1">
                    <label class="form-label">Ville</label>
                    <input type="text" class="form-control" name="villeLivraison" value=${param.villeLivraison}>
                    <div class="text-end text-danger fs-6">${errorVilleLivraison}</div>
                </div>
    
                <div class="mb-1">
                    <label class="form-label">Province</label>
                    <input type="text" class="form-control" name="provinceLivraison" value=${param.provinceLivraison}>
                    <div class="text-end text-danger fs-6">${errorProvinceLivraison}</div>
                </div>
    
                <div class="mb-1">
                    <label class="form-label">Pays</label>
                    <input type="text" class="form-control" name="paysLivraison" value=${param.paysLivraison}>
                    <div class="text-end text-danger fs-6">${errorPaysLivraison}</div>
                </div>
    
                <div class="mb-1">
                    <label class="form-label">Code Postal</label>
                    <input type="text" class="form-control" name="codePostalLivraison" value=${param.codePostalLivraison}>
                    <div class="text-end text-danger fs-6">${errorCodePostalLivraison}</div>
                </div>

                <!-- Submit button -->
                <button type="submit" class="btn btn-primary mt-3">Enregistrer</button>

            </div>

        </div>

        
    </form>

  </body>
</html>