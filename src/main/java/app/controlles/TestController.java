package controllers;
import fw.annotation.Controller;
import fw.annotation.Annotation;

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
}
