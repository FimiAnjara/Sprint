<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="client/add" method="post">
    <input type="text" name="nom" placeholder="Nom" value="Dupont">
    <input type="text" name="prenom" placeholder="Prénom" value="Jean">
    <input type="email" name="email" placeholder="Email" value="jean@test.com">
    <input type="number" name="age" placeholder="Âge" value="30">
    
    <!-- Champs multiples -->
    <select name="interets[]" multiple>
        <option value="sport">Sport</option>
        <option value="lecture">Lecture</option>
        <option value="musique">Musique</option>
    </select>
    
    <button type="submit">Ajouter</button>
</form>
</body>
</html>