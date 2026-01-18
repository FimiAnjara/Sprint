<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="utilitaire.UploadedFile" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Upload Succès</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 1200px;
            margin: 50px auto;
            padding: 20px;
            background-color: #f5f5f5;
        }
        
        .container {
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }
        
        h1 {
            color: #333;
            border-bottom: 3px solid #007bff;
            padding-bottom: 10px;
        }
        
        .success-message {
            color: #155724;
            background-color: #d4edda;
            border: 1px solid #c3e6cb;
            padding: 15px;
            border-radius: 4px;
            margin-bottom: 30px;
        }
        
        .files-container {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
            gap: 20px;
            margin-top: 30px;
        }
        
        .file-card {
            border: 1px solid #ddd;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
            transition: transform 0.3s ease;
        }
        
        .file-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 4px 12px rgba(0,0,0,0.15);
        }
        
        .file-image {
            width: 100%;
            height: 250px;
            object-fit: cover;
            background-color: #f0f0f0;
            transition: opacity 0.3s ease;
        }
        
        .file-card:hover .file-image {
            opacity: 0.8;
        }
        
        .file-info {
            padding: 15px;
            background-color: #f9f9f9;
        }
        
        .file-info h3 {
            margin: 0 0 10px 0;
            color: #333;
            word-break: break-all;
            font-size: 14px;
        }
        
        .file-detail {
            font-size: 13px;
            color: #666;
            margin: 5px 0;
        }
        
        .file-detail strong {
            color: #333;
        }
        
        .download-btn {
            display: inline-block;
            margin-top: 10px;
            padding: 8px 15px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            transition: background-color 0.3s ease;
            font-size: 12px;
        }
        
        .download-btn:hover {
            background-color: #0056b3;
        }
        
        .back-btn {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #6c757d;
            color: white;
            text-decoration: none;
            border-radius: 4px;
        }
        
        .back-btn:hover {
            background-color: #5a6268;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>✓ Upload Réussi</h1>
        
        <div class="success-message">
            <strong><%= request.getAttribute("message") %></strong>
        </div>

        <%-- Affichage de la liste des noms stockés --%>
        <%
            java.util.List names = (java.util.List) utilitaire.SessionManager.getInstance().getAttribute("names");
            if (names != null && !names.isEmpty()) {
        %>
        <div class="success-message">
            <strong>Noms enregistrés :</strong>
            <ul>
                <% for (Object n : names) { %>
                    <li><%= n %></li>
                <% } %>
            </ul>
        </div>
        <% } %>
        
        <%
            List<UploadedFile> files = (List<UploadedFile>) request.getAttribute("files");
            if (files != null && !files.isEmpty()) {
        %>
            <div class="files-container">
                <%
                    for (UploadedFile file : files) {
                        String contentType = file.getContentType();
                        boolean isImage = contentType != null && contentType.startsWith("image/");
                        long fileSize = file.getFileSize();
                        String sizeDisplay;
                        if (fileSize < 1024) {
                            sizeDisplay = fileSize + " bytes";
                        } else if (fileSize < 1024 * 1024) {
                            sizeDisplay = String.format("%.2f KB", fileSize / 1024.0);
                        } else {
                            sizeDisplay = String.format("%.2f MB", fileSize / (1024.0 * 1024.0));
                        }
                %>
                    <div class="file-card">
                        <% if (isImage) { %>
                            <img src="/Sprint/uploads/<%= file.getFileName() %>" alt="<%= file.getFileName() %>" class="file-image" style="cursor: pointer;" onclick="window.open(this.src)">
                        <% } else { %>
                            <div class="file-image" style="display: flex; align-items: center; justify-content: center; background-color: #e9ecef;">
                                <span style="font-size: 48px;">📄</span>
                            </div>
                        <% } %>
                        
                        <div class="file-info">
                            <h3 title="<%= file.getFileName() %>"><%= file.getFileName() %></h3>
                            <% if (file.getFileExtension() != null && !file.getFileExtension().isEmpty()) { %>
                                <div class="file-detail">
                                    <strong>Extension:</strong> <%= file.getFileExtension() %>
                                </div>
                            <% } %>
                            <% if (file.getContentType() != null) { %>
                                <div class="file-detail">
                                    <strong>Type:</strong> <%= file.getContentType() %>
                                </div>
                            <% } %>
                            <div class="file-detail">
                                <strong>Taille:</strong> <%= sizeDisplay %>
                            </div>
                            <a href="/Sprint/uploads/<%= file.getFileName() %>" download class="download-btn">Télécharger</a>
                        </div>
                    </div>
                <%
                    }
                %>
            </div>
        <% } %>
        
        <a href="/Sprint/FormClient.jsp" class="back-btn">Retour</a>
    </div>
</body>
</html>
