package be.flo.project.controller.technical;

import be.flo.project.controller.technical.security.CommonSecurityController;
import com.fasterxml.jackson.databind.JsonNode;
import be.flo.project.dto.technical.DTO;
import org.dozer.config.BeanContainer;
import play.Logger;
import play.mvc.Controller;
import be.flo.project.service.TranslationService;
import be.flo.project.service.impl.TranslationServiceImpl;
import be.flo.project.util.ErrorMessage;
import be.flo.project.util.exception.MyRuntimeException;

import java.util.Set;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


/**
 * Created by florian on 10/11/14.
 */
public abstract class AbstractController extends Controller {

    //controllers
    protected final CommonSecurityController securityController = new CommonSecurityController();
    //service
    protected final TranslationService translationService = new TranslationServiceImpl();
    //dozer
    private Mapper mapper;

    public Mapper getMapper() {
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

    /**
     * this function control the dto (via play.validation annotation) and return it if it's valid, or throw a runtimeException with an error message if not.
     */
    protected <T extends DTO> T extractDTOFromRequest(Class<T> DTOclass) {

        //extract the json node
        JsonNode node = request().body().asJson();
        //extract dto
        T dto = DTO.getDTO(node, DTOclass);
        if (dto == null) {
            throw new MyRuntimeException(ErrorMessage.JSON_CONVERSION_ERROR, DTOclass.getName());
        }


        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> validate = validator.validate(dto);
//
        if (validate.size() > 0) {
            String message = "";
            for (ConstraintViolation<T> tConstraintViolation : validate) {

                String messageTranslated = translationService.getTranslation(tConstraintViolation.getMessage(), lang());

                messageTranslated = messageTranslated.replace("{field}", tConstraintViolation.getInvalidValue() + "");

                if (tConstraintViolation.getConstraintDescriptor().getAnnotation() instanceof javax.validation.constraints.Size) {
                    messageTranslated = messageTranslated.replace("{min}", ((javax.validation.constraints.Size) tConstraintViolation.getConstraintDescriptor().getAnnotation()).min() + "");
                    messageTranslated = messageTranslated.replace("{max}", ((javax.validation.constraints.Size) tConstraintViolation.getConstraintDescriptor().getAnnotation()).max() + "");
                }
                message += messageTranslated;
            }

            throw new MyRuntimeException(message);
        }
        return dto;
    }


}
