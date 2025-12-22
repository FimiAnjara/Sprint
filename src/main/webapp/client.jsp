<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Hello Framework</title>
</head>
<body>
    <%
        String nom = (String) request.getAttribute("nom");
        String prenom = (String) request.getAttribute("prenom");
        String[] interets = (String[]) request.getAttribute("interets[]");
        if (nom == null) {
            nom = "Non spécifié";
        }
        if (prenom == null) {
            prenom = "Non spécifié";
        }
    %>
    <h1>Hello depuis le Framework MVC</h1>
    <p>Nom: <%= nom %></p>
    <p>Prénom: <%= prenom %></p>
    <p>Intérêts:</p>
    <ul>    
        <%
            if (interets != null) {
                for (String interet : interets) {
        %>
                    <li><%= interet %></li>
        <%
                }
            }
        %>
    </ul>
</body>
</html>