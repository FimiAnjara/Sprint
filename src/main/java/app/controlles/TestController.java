package controllers;
import fw.annotation.Controller;
import fw.annotation.Annotation;

@Controller
public class TestController {

    @Annotation("/produit/liste")
    public String listerProduits() {
        return "<h1>Liste des produits</h1>";
    }
}
