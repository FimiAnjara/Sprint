package controllers;
import annotation.Controller;
import annotation.Annotation;

@Controller
public class TestController {

    @Annotation("/produit/liste")
    public String listerProduits() {
        return "<h1>Liste des produits</h1>";
    }

    @Annotation("/produit/detail")
    public String detailProduit() {
        return "<h1>Détail du produit</h1>";
    }

    @Annotation("/url/{id}")
    public String urlWithId(String id) {
        return "<h1>URL avec ID: " + id + "</h1>";
    }

    @Annotation("/produit/{id}/detail")
    public String produitDetail(String id) {
        return "<h1>Détail du produit ID: " + id + "</h1>";
    }
}
