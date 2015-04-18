package be.flo.project.controller.technical.security.annotation;

import be.flo.project.controller.technical.security.CommonSecurityController;
import be.flo.project.service.TranslationService;
import be.flo.project.service.impl.TranslationServiceImpl;
import play.libs.F;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.SimpleResult;

public class SecurityAnnotationAction extends Action<SecurityAnnotation> {

    //controllers
    protected CommonSecurityController securityController = new CommonSecurityController();

    private TranslationService translationService = new TranslationServiceImpl();

    @Override
    public F.Promise<SimpleResult> call(final Http.Context context) throws Throwable {

        if (securityController.isAuthenticated(context) &&
                securityController.getCurrentUser().getRoles().contains(configuration.role())) {
            return delegate.call(context);
        }
        return F.Promise.promise(new F.Function0<SimpleResult>() {
            @Override
            public SimpleResult apply() throws Throwable {
                return securityController.onUnauthorized(context);
            }
        });
    }
}