package services;

import models.entities.StoredFile;

public interface StoredFileService extends CrudService<StoredFile> {

    public StoredFile findByStoredName(String storedName);
}
