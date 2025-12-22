package main.java.app.controlles.Client;

import annotation.*;
import utilitaire.Param;

import java.util.Map;

import View.ModelView;

@Controller
public class Client {
    @Annotation("/client")
    public ModelView listerClients() {
        return new ModelView("/FormClient.jsp", null);
    }

    @Post("/client/detail/{id}")
    public ModelView detailClient(String nom, @Param("nom") String pp, String prenom) {
        return new ModelView("/client.jsp", Map.of("nom", pp, "prenom", "Jean"));
    }

    @Post("/client/add")
    public ModelView addClient(Map<String, Object> values) {
        System.out.println("=== DONNÉES RECUES ===");
        for (Map.Entry<String, Object> entry : values.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        System.out.println("======================");
        System.out.println(values);
   

        return new ModelView("/client.jsp",values);
    }

    @Get("/client/detail/{id}")
    public ModelView clientDetail() {
        return new ModelView("/client.jsp", Map.of("nom", "Dupont", "prenom", "Jean"));
    }
}
