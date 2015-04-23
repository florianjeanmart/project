package be.flo.project.service.impl;

import be.flo.project.model.entities.StoredFile;
import be.flo.project.service.StoredFileService;
import org.springframework.stereotype.Repository;
import play.db.jpa.JPA;

@Repository
public class StoredFileServiceImpl extends CrudServiceImpl<StoredFile> implements StoredFileService {

    @Override
    public StoredFile findByStoredName(String storedName) {

        return getSingleOrNull(JPA.em().createNamedQuery(StoredFile.FIND_BY_STORED_NAME,StoredFile.class)
                .setParameter(StoredFile.PARAM_NAME,storedName));
    }
}
