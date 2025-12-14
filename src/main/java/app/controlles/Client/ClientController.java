package controlles.Client;

import annotation.*;

import model.Client;
import model.TypeClient;

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
   

        return new ModelView("/client.jsp",values);
    }

    @Post("/client/add")
    public ModelView addclient(Client client, @Param("interets[]") String[] interets,int bb) {
        System.out.println("=== CLIENT RECUE ===");
        System.out.println("Nom: " + client.getNom());
        System.out.println("Prénom: " + client.getPrenom());
        System.out.println("Email: " + client.getEmail());
        System.out.println("Age: " + client.getAge());
        System.out.println("Intérêts: ");
        
        System.out.println("====================");

        return new ModelView("/client.jsp",Map.of("nom",client.getNom(),"prenom",client.getPrenom(),"interets",interets));
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
        client.setTypeClient(new TypeClient(1,"Particulier"));
        return client;
    }

    @Post("/client/upload")
    public ModelView uploadFiles(Map<String, byte[]> files, String name) {
        System.out.println("Fichiers reçus: " + files.size());
        
        files.forEach((paramName, fileContent) -> {
            System.out.println("Fichier: " + paramName + " (" + fileContent.length + " bytes)");
        });
        
        return new ModelView("/success.jsp");
    }
    
}