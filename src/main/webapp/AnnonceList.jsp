<%@ page import="org.iut.montreuil.bean.Annonce" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Liste des annonces</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="d-flex justify-content-center align-items-center vh-100">
<div class="container text-center">
    <div class="row justify-content-center">
        <div class="col-md-6 col-lg-6">
            <div class="card shadow-lg p-4">
                <h1>Liste des annonces </h1>
                <ol class="list-group list-group-numbered">
                    <%
                        List<Annonce> annonces = (List<Annonce>) request.getAttribute("annonces");
                        for(Annonce annonce : annonces) {
                            %>
                                <li class="list-group-item d-flex justify-content-between align-items-start">
                                    <div class="ms-2 me-auto">
                                        <div class="fw-bold"><%=annonce.getTitre()%></div>
                                        <div><%=annonce.getDescription()%></div>
                                    </div>
                                    <form action="AnnonceUpdate" method="GET">
                                        <input type="hidden" name="id" value="<%= annonce.getId() %>" />
                                        <button type="submit" class="btn btn-warning me-2">Modifier</button>
                                    </form >
                                    <form action="AnnonceDelete" method="POST">
                                        <input type="hidden" name="id" value="<%= annonce.getId() %>">
                                        <button type="submit" class="btn btn-danger">Supprimer</button>
                                    </form>
                                </li>
                            <%
                        }
                    %>
                </ol>

                <form action="AnnonceAdd.jsp">
                    <div class="d-grid gap-2 d-md-flex justify-content-md-start">
                        <button type="submit" class="btn btn-primary m-3">Ajouter une annonce</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
