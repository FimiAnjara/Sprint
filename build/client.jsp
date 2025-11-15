<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello Framework</title>
</head>
<body>
    <%
        String nom = (String) request.getAttribute("nom");
        if (nom == null) {
            nom = "Non spécifié";
        }
    %>
    <h1>Hello depuis le Framework MVC</h1>
    <p>Nom: <%= nom %></p>
</body>
</html>