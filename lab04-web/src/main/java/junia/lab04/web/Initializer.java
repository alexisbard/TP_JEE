package junia.lab04.web;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer{

    public String[] getRootConfigClasses(){
        return new String[]{AppConfig,DBConfig};
    }


    public String[] getServletConfigClasses () {
        return new String[]{WebConfig};
    }

    public String[] getServletMappings () {
        return new String[]{"/"};
    }
}
