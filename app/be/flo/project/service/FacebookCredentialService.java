package be.flo.project.service;

import be.flo.project.model.entities.FacebookCredential;

/**
 * Created by florian on 3/05/15.
 */
public interface FacebookCredentialService extends CrudService<FacebookCredential>{
    FacebookCredential findByUserId(long userId);

    boolean controlFacebookAccess(long userId, String accessToken);
}
