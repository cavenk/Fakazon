<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page Panier</title>
<%@include file="includes/head.jsp" %>
</head>
<body>
 <%@include file="/includes/navbar.jsp" %> 

  <div class="container">
    <div class="d-flex py-3">
      <h3>Total Price: $ {PRICEVARIABLE}</h3>
    </div>
    <table class="table table-loght">
      <thead>
        <tr>
          <th scope="col">Nom du Produit</th>
          <th scope="col">Prix</th>
          <th scope="col">Quantite</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>Apple IPhone 14</td>
          <td>1379$</td>
          <td>{QUANTITE PRODUIT}</td>
          <td>
              <form method="post" class="form-inline"> 
                <input type="hidden" name="id" value="1" class="form-input">
                <div class="form-group d-flex justify-content-between">
                <a class="btn btn-sm btn-decre" href=""><i class="fas fa-minus-square"></i></a>               
                <input type="text" name="quantite" class="form-control" value="1" readonly>
                <a class="btn btn-sm btn-incre" href=""><i class="fas fa-plus-square"></i></a>
                </div>
              </form>
          </td>
              <td><a class="btn btn-sm btn-danger" href="">Remove</a></td>
                <td>
                  <a class="mx-3 btn btn-primary" href="rechercheProduit.jsp">continuer a magasiner</a>
                  <a class="mx-3 btn btn-primary" href="#">Acheter</a>
                 </td>
              
        </tr>
        </tbody>
    </table>
  </div>
<%@include file="/includes/footer.jsp" %>
</body>
</html>