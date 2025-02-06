<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: thomas
  Date: 31/01/2025
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Interface d'enregistrement d'une annonce</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="d-flex justify-content-center align-items-center vh-100">
    <div class="container text-center">
        <div class="row justify-content-center">
            <div class="col-md-6 col-lg-6">
                <div class="card shadow-lg p-4">
                    <form action="AnnonceAdd" method="POST">
                        <h2 class="mb-4">Interface d'enregristrement d'une annonce</h2>
                        <div class="form-floating mb-3">
                            <input class="form-control" placeholder="entrez un titre" id="titre" name="titre" required></input>
                            <label for="titre">Titre</label>
                        </div>
                        <div class="form-floating mb-3">
                            <textarea class="form-control" placeholder="entrez une description" id="description" name="description" required></textarea>
                            <label for="description">Description</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input class="form-control" placeholder="entrez une adresse" id="adresse" name="adresse" required></input>
                            <label for="adresse">Adresse</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input class="form-control" placeholder="entrez une adresse email" id="mail" name="mail" required></input>
                            <label for="mail">Adresse email</label>
                        </div>
                        <button type="submit" class="btn btn-primary w-100">Envoyer</button>
                    </form>

                    <c:if test="${not empty request.message}">
                        <div class="alert alert-success" role="alert">
                                ${request.message}
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
