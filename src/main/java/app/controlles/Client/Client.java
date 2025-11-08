package main.java.app.controlles.Client;

import fw.annotation.Controller;
import fw.annotation.Annotation;

@Controller
public class Client {
    @Annotation("/client/liste")
    public int listerClients() {
        return 1;
    }    
}
