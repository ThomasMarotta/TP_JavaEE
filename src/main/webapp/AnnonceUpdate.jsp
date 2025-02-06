<%@ page import="org.iut.montreuil.bean.Annonce" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Interface de modification d'une annonce</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="d-flex justify-content-center align-items-center vh-100">
<div class="container text-center">
    <div class="row justify-content-center">
        <div class="col-md-6 col-lg-6">
            <div class="card shadow-lg p-4">
                <form action="AnnonceUpdate" method="POST">
                    <%
                        Annonce annonce = (Annonce) request.getAttribute("annonce");
                    %>
                    <input type="hidden" name="id" value="<%= annonce.getId() %>">
                    <h2 class="mb-4">Interface de modification d'une annonce</h2>
                    <div class="form-floating mb-3">
                        <input class="form-control" placeholder="entrez un titre" id="titre" name="titre" value="<%= annonce.getTitre() %>" required>
                        <label for="titre">Titre</label>
                    </div>
                    <div class="form-floating mb-3">
                        <textarea class="form-control" placeholder="entrez une description" id="description" name="description" required><%= annonce.getDescription() %></textarea>
                        <label for="description">Description</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input class="form-control" placeholder="entrez une adresse" id="adresse" name="adresse" value="<%= annonce.getAdresse() %>" required>
                        <label for="adresse">Adresse</label>
                    </div>
                    <div class="form-floating mb-3">
                        <input class="form-control" placeholder="entrez une adresse email" id="mail" name="mail" value="<%= annonce.getEmail() %>" required>
                        <label for="mail">Adresse email</label>
                    </div>
                    <button type="submit" class="btn btn-primary w-100">Envoyer la modification</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>