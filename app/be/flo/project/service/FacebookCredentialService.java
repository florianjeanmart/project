package be.flo.project.service;

import be.flo.project.model.entities.FacebookCredential;

/**
 * Created by florian on 3/05/15.
 */
public interface FacebookCredentialService extends CrudService<FacebookCredential>{
    FacebookCredential findByUserId(String userId);

    boolean controlFacebookAccess(FacebookCredential facebookCredential, String accessToken);
}
