package main.java.app.controlles.Client;

import annotation.Controller;

import java.util.Map;

import View.ModelView;
import annotation.Annotation;

@Controller
public class Client {
    @Annotation("/client/liste")
    public ModelView listerClients() {
        return new ModelView("/client.jsp");
    }    

    @Annotation("/client/detail")
    public ModelView detailClient() {
        return new ModelView("/client.jsp", Map.of("nom", "Dupont", "prenom", "Jean"));
    }

    @Annotation("/client/{id}/detail")
    public ModelView clientDetail() {
        return new ModelView("/client.jsp", Map.of( "nom", "Dupont", "prenom", "Jean"));
    } 
}
