import fw.Annotation;

public class Controller {

    @Annotation("/produit/liste")
    public String listerProduits() {
        return "<h1>Liste des produits</h1>";
    }
}
