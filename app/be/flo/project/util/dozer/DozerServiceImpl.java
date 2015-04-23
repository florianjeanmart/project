package be.flo.project.util.dozer;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.config.BeanContainer;
import org.springframework.stereotype.Component;
import play.Logger;

/**
 * Created by florian on 23/04/15.
 */
@Component
public class DozerServiceImpl {


    private DozerBeanMapper mapper;

    public Mapper getMapper(){
        if (mapper == null) {
            //initialize mapper
            Logger.info("MAPPER INITIALIZATION");

            DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();

            try {

                BeanContainer.getInstance().setClassLoader(new MyDozerClassLoader());
                dozerBeanMapper.addMapping(getClass().getResourceAsStream("/dozer.xml"));

                mapper = dozerBeanMapper;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return mapper;
    }
}
