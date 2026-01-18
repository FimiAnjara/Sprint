package controlles.Client;

import annotation.*;

import model.Client;
import model.TypeClient;
import utilitaire.UploadedFile;
import utilitaire.SessionManager;
import java.io.IOException;

import java.util.Map;

import View.ModelView;

@Controller
public class ClientController {
    @Annotation("/client")
    public ModelView listerClients() {
        return new ModelView("/FormClient.jsp", null);
    }

    @Post("/client/detail/{id}")
    public ModelView detailClient(String nom, @Param("nom") String pp, String prenom) {
        return new ModelView("/client.jsp", Map.of("nom", pp, "prenom", "Jean"));
    }

    @Post("/client/add1")
    public ModelView addClient(Map<String, Object> values) {
        System.out.println("=== DONNÉES RECUES ===");
        for (Map.Entry<String, Object> entry : values.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        System.out.println("======================");
        System.out.println(values);

        return new ModelView("/client.jsp", values);
    }

    @Post("/client/add")
    public ModelView addclient(Client client, @Param("interets[]") String[] interets, int bb) {
        System.out.println("=== CLIENT RECUE ===");
        System.out.println("Nom: " + client.getNom());
        System.out.println("Prénom: " + client.getPrenom());
        System.out.println("Email: " + client.getEmail());
        System.out.println("Age: " + client.getAge());
        System.out.println("Intérêts: ");

        System.out.println("====================");

        return new ModelView("/client.jsp",
                Map.of("nom", client.getNom(), "prenom", client.getPrenom(), "interets", interets));
    }

    @Get("/client/detail/{id}")
    public ModelView clientDetail() {
        return new ModelView("/client.jsp", Map.of("nom", "Dupont", "prenom", "Jean"));
    }

    @Json
    @Get("/client/json")
    public Client getClientJson() {
        Client client = new Client();
        client.setNom("Dupont");
        client.setPrenom("Jean");
        client.setEmail("jean@gmail.com");
        client.setAge(30);
        client.setTypeClient(new TypeClient(1, "Particulier"));
        return client;
    }

    @Post("/client/upload")
    public ModelView uploadFiles(Map<UploadedFile, byte[]> files, String name) {
        System.out.println("Fichiers reçus: " + files.size());
        // Chemin absolu vers le répertoire uploads dans webapp de Tomcat
        String uploadDir = "uploads";
        System.out.println("Chemin de sauvegarde: " + uploadDir);
        
        // Créer le répertoire s'il n'existe pas
        java.io.File dir = new java.io.File(uploadDir);
        if (!dir.exists()) {
            boolean created = dir.mkdirs();
            System.out.println("✓ Répertoire créé: " + uploadDir + " - succès: " + created);
        }
        java.util.List<UploadedFile> uploadedFilesList = new java.util.ArrayList<>();
        
        for (Map.Entry<UploadedFile, byte[]> entry : files.entrySet()) {
            UploadedFile uploadedFile = entry.getKey();
            byte[] fileContent = entry.getValue();
            System.out.println("--- Fichier reçu ---");
            System.out.println("Nom: " + uploadedFile.getFileName());
            System.out.println("Extension: " + uploadedFile.getFileExtension());
            System.out.println("Type: " + uploadedFile.getContentType());
            System.out.println("Taille: " + uploadedFile.getFileSize() + " bytes");
            System.out.println("Contenu (bytes): " + fileContent.length);
            try {
                uploadedFile.saveTo(uploadDir);
                System.out.println("✓ Fichier sauvegardé avec succès");
                uploadedFilesList.add(uploadedFile);
            } catch (IOException e) {
                System.err.println("✗ Erreur lors de la sauvegarde: " + e.getMessage());
                e.printStackTrace();
            }
        }
        
       
        SessionManager sm = SessionManager.getInstance();
 
        java.util.List<String> names = (java.util.List<String>) sm.getAttribute("names");
        if (names == null) {
            names = new java.util.ArrayList<>();
        }
        if (name != null && !name.isEmpty()) {
            names.add(name);
        }
        sm.setAttribute("names", names);

        String message = files.size() + " fichier(s) reçu(s) avec succès pour " + name;
        return new ModelView("/uploadSuccess.jsp", Map.of(
            "message", message,
            "files", uploadedFilesList
        ));
    }

    @Get("/client/names")
    public ModelView listNames() {
        SessionManager sm = SessionManager.getInstance();
        java.util.List<String> names = (java.util.List<String>) sm.getAttribute("names");
        return new ModelView("/client.jsp", Map.of("names", names));
    }

}