package controllers.rest;

import com.avaje.ebean.annotation.Transactional;
import controllers.technical.security.SecurityRestController;
import dto.FilesUploadedDTO;
import models.entities.StoredFile;
import play.Logger;
import play.mvc.Http.MultipartFormData;
import play.mvc.Result;
import play.mvc.Security;
import services.StoredFileService;
import services.impl.StoredFileServiceImpl;
import util.ErrorMessage;
import util.KeyGenerator;
import util.exception.MyRuntimeException;
import util.file.FileUtil;

import java.io.File;
import java.io.InputStream;
import java.util.List;

public class FilesController extends AbstractRestController {

    private StoredFileService storedFileService = new StoredFileServiceImpl();

    /**
     * @return
     */
    @Transactional(readOnly = false)
    @Security.Authenticated(SecurityRestController.class)
    public Result upload() {

        Logger.info("0");

        MultipartFormData body = request().body().asMultipartFormData();
        List<MultipartFormData.FilePart> files = body.getFiles();

        FilesUploadedDTO filesUploadedDTO = null;

        if (files != null) {

            Logger.info("1");

            File file = files.get(0).getFile();
            String fileName = files.get(0).getFilename();

            Logger.info("2");

            //generate the key => test if the key is already used
            String storageKey = null;

            Logger.info("3");

            while (storageKey == null || storedFileService.findByStoredName(storageKey) != null) {
                storageKey = KeyGenerator.generateRandomKey(100);
            }

            Logger.info("4");

            //create the entity
            StoredFile storedFile = new StoredFile(fileName, storageKey, 0, securityController.getCurrentUser());

            Logger.info("5");

            //and save
            storedFileService.saveOrUpdate(storedFile);

            Logger.info("6");

            //save the file
            FileUtil.save(file, storageKey);

            Logger.info("7");

            //complete the result
            filesUploadedDTO = new FilesUploadedDTO(storedFile.getId(), storedFile.getOriginalName());

            Logger.info("8");

        }
        return ok(filesUploadedDTO);
    }

    /*
      download a file by is storedFileId
     */
    @Transactional(readOnly = true)
    @Security.Authenticated(SecurityRestController.class)
    public Result download(long storedFileId) {

        //get the storedFile
        StoredFile storedFile = storedFileService.findById(storedFileId);

        if (storedFile == null) {
            throw new RuntimeException("File " + storedFileId + " was not found");
        }

        //control
        if (!storedFile.getAccount().equals(securityController.getCurrentUser())) {
            throw new MyRuntimeException(ErrorMessage.NOT_YOUR_FILE, storedFileId+"");
        }

        //create an inputStream
        InputStream inputStream = FileUtil.getFileInputStream(storedFile.getStoredName());

        //launch the download
        response().setContentType("application/octet-stream");
        response().setHeader("Content-disposition", "attachment; filename=" + storedFile.getOriginalName());

        return ok(inputStream);
    }


}
