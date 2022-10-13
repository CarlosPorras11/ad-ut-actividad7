package org.iesfm.dao;

import org.iesfm.entity.FileInfoEntity;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileDAOImpl implements FileDAO {
    @Override
    public List<FileInfoEntity> createInfoEntity(File folder) {
        List<FileInfoEntity> fileInfoEntityList = new ArrayList<>();
        for (File file : folder.listFiles()) {
            FileInfoEntity fileInfoEntity = new FileInfoEntity();
            fileInfoEntity.setName(file.getName());
            fileInfoEntity.setType(file.isDirectory() ? "D" : "F");
            if (file.canExecute()) {
                fileInfoEntity.getPermissions().add("X");
            }
            if (file.canWrite()) {
                fileInfoEntity.getPermissions().add("W");
            }
            if (file.canRead()) {
                fileInfoEntity.getPermissions().add("R");
            }
            fileInfoEntity.setSize(file.length());
            fileInfoEntityList.add(fileInfoEntity);
        }
        return fileInfoEntityList;
    }

    @Override
    public void insertListInFile(List<FileInfoEntity> fileInfoEntityList, String nombreFicheroResultado) throws IOException {
        File ficheroResultado = new File(nombreFicheroResultado);
        try (PrintWriter pw = new PrintWriter(ficheroResultado)) {
            if (!ficheroResultado.exists()) {
                ficheroResultado.createNewFile();
            }
            for (FileInfoEntity fileInfoEntity : fileInfoEntityList) {
                System.out.println(fileInfoEntity.toPrint());
                pw.println(fileInfoEntity.toPrint());
            }

        }
    }
}
