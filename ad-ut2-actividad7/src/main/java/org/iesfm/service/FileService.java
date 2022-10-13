package org.iesfm.service;

import org.iesfm.dao.FileDAO;
import org.iesfm.dao.FileDAOImpl;
import org.iesfm.entity.FileInfoEntity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    FileDAO fileDAO = new FileDAOImpl();
    public void createFileWithFileList(String folderName, String nombreFicheroResultado) {
        File folder = new File(folderName);
        if (folder.exists() && folder.isDirectory()) {
            List<FileInfoEntity> fileInfoEntityList = fileDAO.createInfoEntity(folder);
            try {
                fileDAO.insertListInFile(fileInfoEntityList, nombreFicheroResultado);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.err.println("El parametro pasado al programa no es una carpeta");
        }
    }
}
