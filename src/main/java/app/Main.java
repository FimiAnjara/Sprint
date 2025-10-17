import java.util.ResourceBundle.Control;
import fw.Annotation;

public class Main {
    public static void main(String[] args) {
        Class<Controller> controllerClass = Controller.class;
        for (var method : controllerClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Annotation.class)) {
                Annotation annotation = method.getAnnotation(Annotation.class);
                System.out.println("Méthode: " + method.getName() + ", URL: " + annotation.value());
            }
        }

    }
}
