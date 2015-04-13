package controllers.technical;

import com.fasterxml.jackson.databind.JsonNode;
import controllers.technical.security.CommonSecurityController;
import controllers.technical.security.SecurityController;
import dto.technical.DTO;
import play.mvc.Controller;
import services.TranslationService;
import services.impl.TranslationServiceImpl;
import util.ErrorMessage;
import util.exception.MyRuntimeException;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * Created by florian on 10/11/14.
 */
public abstract class AbstractController extends Controller {

    //controllers
    protected final CommonSecurityController securityController = new SecurityController();
    //service
    protected final TranslationService translationService = new TranslationServiceImpl();

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
        if(validate.size()>0){
            String message = "";
            for (ConstraintViolation<T> tConstraintViolation : validate) {

                String messageTranslated = translationService.getTranslation(tConstraintViolation.getMessage(), lang());

                messageTranslated=messageTranslated.replace("{field}",tConstraintViolation.getInvalidValue()+"");

                if (tConstraintViolation.getConstraintDescriptor().getAnnotation() instanceof javax.validation.constraints.Size) {
                    messageTranslated=messageTranslated.replace("{min}",((javax.validation.constraints.Size) tConstraintViolation.getConstraintDescriptor().getAnnotation()).min()+"");
                    messageTranslated=messageTranslated.replace("{max}",((javax.validation.constraints.Size) tConstraintViolation.getConstraintDescriptor().getAnnotation()).max()+"");
                }
                message+= messageTranslated;
            }

            throw new MyRuntimeException(message);
        }
        return dto;
    }
}
