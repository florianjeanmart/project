package services.impl;

import com.avaje.ebean.Ebean;
import models.entities.Account;
import models.entities.StoredFile;
import play.Logger;
import services.StoredFileService;

import java.util.List;

public class StoredFileServiceImpl extends CrudServiceImpl<StoredFile> implements StoredFileService {

    @Override
    public StoredFile findByStoredName(String storedName) {

        return Ebean.createNamedQuery(StoredFile.class, StoredFile.FIND_BY_STORED_NAME)
                .setParameter(StoredFile.PARAM_NAME,storedName)
                .findUnique();
    }
}
