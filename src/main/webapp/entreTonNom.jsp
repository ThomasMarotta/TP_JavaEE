<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Entrez votre nom</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="d-flex justify-content-center align-items-center vh-100">
<div class="container text-center">
    <div class="row justify-content-center">
        <div class="col-md-6 col-lg-4">
            <div class="card shadow-lg p-4">
                <h2 class="mb-4">Entrez votre nom</h2>
                <form action="Hello" method="GET">
                    <div class="mb-3">
                        <label for="name" class="form-label">Votre nom :</label>
                        <input type="text" id="name" name="name" class="form-control" required>
                    </div>
                    <button type="submit" class="btn btn-primary w-100">Envoyer</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>