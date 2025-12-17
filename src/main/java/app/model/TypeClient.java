package model;
public class TypeClient {
    int id;
    String type;
    public TypeClient(int id, String type) {
        this.id = id;
        this.type = type;
    }

    // setters and getters
    public int getId() {
        return id;
    }   
    public void setId(int id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
