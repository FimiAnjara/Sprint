<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="client/upload-session-demo" method="POST" enctype="multipart/form-data">
    <input type="text" name="name" placeholder="Nom" required>
    <input type="file" name="file1">
    <button type="submit">Uploader</button>
    </form>
</body>
</html>