package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        String resultFileName = args[0];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        File f = new File(resultFileName);


        List<String> archivesNameList = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            archivesNameList.add(args[i]);
        }
        archivesNameList.sort(Comparator.naturalOrder());

        Vector<InputStream> inputStreamVector = new Vector<>();
        for (String archiveName : archivesNameList) {
            inputStreamVector.add(new FileInputStream(archiveName));
        }
        ;

        try (ZipInputStream zis = new ZipInputStream(new SequenceInputStream(inputStreamVector.elements()))) {
            ZipEntry zipEntry;
            while ((zipEntry = zis.getNextEntry()) != null) {
                byte[] buffer = new byte[1024];
                int count = 0;
                while ((count = zis.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, count);
                }
            }
        }

        try (FileOutputStream fos = new FileOutputStream(resultFileName)) {

            fos.write(byteArrayOutputStream.toByteArray());
        }
        byteArrayOutputStream.close();
    }
}
