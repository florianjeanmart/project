package be.flo.project.controller.technical.security.annotation;

import be.flo.project.controller.technical.security.role.RoleEnum;
import play.mvc.With;

import java.lang.annotation.*;


/**
 * Created by gaston on 8/25/14.
 */

@With(SecurityAnnotationAction.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Inherited
@Documented
public @interface SecurityAnnotation {
	RoleEnum role() default RoleEnum.CUSTOMER;
}
