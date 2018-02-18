package by.itacademy;

import by.itacademy.config.ServiceConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextHolder {
    private static final AnnotationConfigApplicationContext APPLICATION_CONTEXT;

    static {
        APPLICATION_CONTEXT = new AnnotationConfigApplicationContext(ServiceConfiguration.class);
    }

    public static <T> T getBean(Class<T> beenClass) {
        return APPLICATION_CONTEXT.getBean(beenClass);
    }

    public static void destroy() {
        APPLICATION_CONTEXT.close();
    }
}
