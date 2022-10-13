package org.iesfm.dao;

import org.iesfm.entity.FileInfoEntity;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface FileDAO {

    List<FileInfoEntity> createInfoEntity(File folder);

    void insertListInFile(List<FileInfoEntity> fileInfoEntityList, String nombreFicheroResultado) throws IOException;
}
