package main.java.app.controlles.Client;

import fw.annotation.Controller;
import View.ModelView;
import fw.annotation.Annotation;

@Controller
public class Client {
    @Annotation("/client/liste")
    public ModelView listerClients() {
        return new ModelView("/client.jsp");
    }    

    @Annotation("/client/detail")
    public ModelView detailClient() {
        return new ModelView("/client.jsp");
    }
}
