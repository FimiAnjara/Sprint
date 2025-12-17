package model;
public class Client {
    String nom;
    String prenom;
    String email;
    int age;
    TypeClient typeClient;
    // setters and getters
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
    public String getEmail() {
        return email;
    }
    public TypeClient getTypeClient() {
        return typeClient;
    }
    public void setTypeClient(TypeClient typeClient) {
        this.typeClient = typeClient;
    }
}