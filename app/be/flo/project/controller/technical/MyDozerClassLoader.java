package be.flo.project.controller.technical;

import org.dozer.util.DozerClassLoader;
import play.Application;
import play.Play;

import java.net.URL;

/**
 * Created by florian on 16/04/15.
 */
public class MyDozerClassLoader implements DozerClassLoader {


    @Override
    public Class<?> loadClass(String s) {
        try {
            return Play.application().classloader().loadClass(s);
//            return getClass().getClassLoader().loadClass(s);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public URL loadResource(String s) {
        return Play.application().resource(s);

    }
}
