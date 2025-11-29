package main.java.app.controlles.Client;

import annotation.Controller;
import utilitaire.Param;

import java.util.Map;

import View.ModelView;
import annotation.Annotation;

@Controller
public class Client {
    @Annotation("/client")
    public ModelView listerClients() {
        return new ModelView("/FormClient.jsp",null);
    }    

    @Annotation("/client/detail")
    public ModelView detailClient(String nom,@Param("nom") String pp,String prenom) {
        return new ModelView("/client.jsp", Map.of("nom", "Dupont", "prenom", "Jean"));
    }

    @Annotation("/client/{id}/detail")
    public ModelView clientDetail() {
        return new ModelView("/client.jsp", Map.of( "nom", "Dupont", "prenom", "Jean"));
    } 
}
