<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@include file="includes/head.jsp"%>
    <title>Gérer compte</title>
  </head>
  <body>
    <!-- Header -->
	<%@include file="includes/header.jsp"%>

    <!-- Main content -->
    <form class="container" action="compteControleur" method="post">
        <h2 class="text-center">Gérer compte</h2>
        <div class="row justify-content-center">
            <div class="col-lg-6">
                <!-- action -->
                <input type="hidden" class="form-control" name="action" value="update">

                <!-- Info générale -->
                <h4 class="mt-4">Information générale</h4>

                <div class="mb-1">
                    <label class="form-label">Nom</label>
                    <input type="text" class="form-control" name="nom" value=${user != null ? user.getNom() : param.nom}>
                    <div class="text-end text-danger fs-6">${errorNom}</div>
                </div>
                
                <div class="mb-1">
                    <label class="form-label">Prenom</label>
                    <input type="text" class="form-control" name="prenom" value=${user != null ? user.getPrenom() : param.prenom}>
                    <div class="text-end text-danger fs-6">${errorPrenom}</div>
                </div>
                
                <div class="mb-1">
                    <label class="form-label">Date de naissance</label>
                    <input type="date" class="form-control" name="dateDeNaissance" value=${user != null ? user.getDateNaissance() : param.dateDeNaissance}>
                    <div class="text-end text-danger fs-6">${errorDateDeNaissance}</div>
                </div>
                
                <div class="mb-1">
                    <label class="form-label">Téléphone</label>
                    <input type="tel" class="form-control" name="telephone" value=${user != null ? user.getTelephone() : param.telephone}>
                    <div class="text-end text-danger fs-6">${errorTelephone}</div>
                </div>

                <div class="mb-1">
                    <label class="form-label">Courriel</label>
                    <input type="email" class="form-control" name="courriel" value=${user != null ? user.getCourriel() : param.courriel}>
                    <div class="text-end text-danger fs-6">${errorCourriel}</div>
                </div>

                <div class="mb-1">
                    <label class="form-label">Confirmer courriel</label>
                    <input type="email" class="form-control" name="confirmerCourriel" value=${user != null ? user.getCourriel() : param.confirmerCourriel}>
                    <div class="text-end text-danger fs-6">${errorConfirmerCourriel}</div>
                </div>
    
                <div class="mb-1">
                    <label class="form-label">Mot de passe</label>
                    <input type="text" class="form-control" name="motDePasse" value=${user != null ? user.getMotPass() : param.motDePasse}>
                    <div class="text-end text-danger fs-6">${errorMotDePasse}</div>
                </div>
        
                <div class="mb-1">
                    <label class="form-label">Confirmer mot de passe</label>
                    <input type="text" class="form-control" name="confirmerMotDePasse" value=${user != null ? user.getMotPass() :param.confirmerMotDePasse}>
                    <div class="text-end text-danger fs-6">${errorConfirmerMotDePasse}</div>
                </div>

                <!-- Adresse -->
                <h4 class="mt-4">Adresse</h4>


                <div class="mb-1">
                    <label class="form-label">Adresse</label>
                    <input type="text" class="form-control" name="adresse" value=${adresse != null ? adresse.getAdresse() : param.adresse}>
                    <div class="text-end text-danger fs-6">${errorAdresse}</div>
                </div>

                <div class="mb-1">
                    <label class="form-label">Ville</label>
                    <input type="text" class="form-control" name="ville" value=${adresse != null ? adresse.getVille() : param.ville}>
                    <div class="text-end text-danger fs-6">${errorVille}</div>
                </div>

                <div class="mb-1">
                    <label class="form-label">Province</label>
                    <input type="text" class="form-control" name="province" value=${adresse != null ? adresse.getProvince() : param.province}>
                    <div class="text-end text-danger fs-6">${errorProvince}</div>
                </div>

                <div class="mb-1">
                    <label class="form-label">Pays</label>
                    <input type="text" class="form-control" name="pays" value=${adresse != null ? adresse.getPays() : param.pays}>
                    <div class="text-end text-danger fs-6">${errorPays}</div>
                </div>

                <div class="mb-1">
                    <label class="form-label">Code Postal</label>
                    <input type="text" class="form-control" name="codePostal" value=${adresse != null ? adresse.getCodePostal() : param.codePostal}>
                    <div class="text-end text-danger fs-6">${errorCodePostal}</div>
                </div>

                <!-- Adresse de livraison -->
                <h4 class="mt-4">Adresse de livraison</h4>



                <div class="mb-1">
                    <label class="form-label">Adresse</label>
                    <input type="text" class="form-control" name="adresseLivraison" value=${adresseLiv != null ? adresseLiv.getAdresse() : param.adresseLivraison}>
                    <div class="text-end text-danger fs-6">${errorAdresseLivraison}</div>
                </div>
    
                <div class="mb-1">
                    <label class="form-label">Ville</label>
                    <input type="text" class="form-control" name="villeLivraison" value=${adresseLiv != null ? adresseLiv.getVille() : param.villeLivraison}>
                    <div class="text-end text-danger fs-6">${errorVilleLivraison}</div>
                </div>
    
                <div class="mb-1">
                    <label class="form-label">Province</label>
                    <input type="text" class="form-control" name="provinceLivraison" value=${adresseLiv != null ? adresseLiv.getProvince() : param.provinceLivraison}>
                    <div class="text-end text-danger fs-6">${errorProvinceLivraison}</div>
                </div>
    
                <div class="mb-1">
                    <label class="form-label">Pays</label>
                    <input type="text" class="form-control" name="paysLivraison" value=${adresseLiv != null ? adresseLiv.getPays() : param.paysLivraison}>
                    <div class="text-end text-danger fs-6">${errorPaysLivraison}</div>
                </div>
    
                <div class="mb-1">
                    <label class="form-label">Code Postal</label>
                    <input type="text" class="form-control" name="codePostalLivraison" value=${adresseLiv != null ? adresseLiv.getCodePostal() : param.codePostalLivraison}>
                    <div class="text-end text-danger fs-6">${errorCodePostalLivraison}</div>
                </div>

                <!-- Submit button -->
                <button type="submit" class="btn btn-primary mt-3">Modifier</button>

            </div>

        </div>

        
    </form>

  </body>
</html>