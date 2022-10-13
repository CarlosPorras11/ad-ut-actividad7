package org.iesfm.app;

import org.iesfm.service.FileService;

public class Actividad7 {

    private final static String NOMBRE_FICHERO_RESULTADO = "/home/Carlos/Documentos/Actividad7/result.txt";
    public static void main(String[] args) {
        String folderName = args[0];
        FileService fileService = new FileService();
        fileService.createFileWithFileList(folderName, NOMBRE_FICHERO_RESULTADO);
    }

}
