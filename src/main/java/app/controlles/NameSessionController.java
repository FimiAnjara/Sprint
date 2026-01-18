package controllers;

import annotation.Controller;
import annotation.Annotation;
import annotation.Param;
import utilitaire.SessionManager;
import java.util.ArrayList;
import java.util.List;

@Controller
public class NameSessionController {
    // Route pour recevoir le nom depuis le formulaire et le stocker en session
    @Annotation("/name/add")
    public String addName(@Param("name") String name) {
        SessionManager sm = SessionManager.getInstance();
        List<String> names = (List<String>) sm.getAttribute("names");
        if (names == null) {
            names = new ArrayList<>();
        }
        if (name != null && !name.isEmpty()) {
            names.add(name);
        }
        sm.setAttribute("names", names);
        return "<p>Nom ajouté : " + name + "</p><a href='/name/list'>Voir tous les noms</a>";
    }

    // Route pour afficher tous les noms stockés en session
    @Annotation("/name/list")
    public String listNames() {
        SessionManager sm = SessionManager.getInstance();
        List<String> names = (List<String>) sm.getAttribute("names");
        StringBuilder sb = new StringBuilder();
        sb.append("<h2>Liste des noms :</h2><ul>");
        if (names != null) {
            for (String n : names) {
                sb.append("<li>").append(n).append("</li>");
            }
        }
        sb.append("</ul><a href='/FormClient.html'>Ajouter un nom</a>");
        return sb.toString();
    }
}
