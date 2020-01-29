package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        String fileName = args[0];
        String zip = args[1];
        String newZip = zip;

        HashMap<String, ByteArrayOutputStream> zipEntryMap = new HashMap<>();
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zip))) {
            ZipEntry zipEntry;
            while ((zipEntry = zis.getNextEntry()) != null) {
                if (!zipEntry.getName().equals(fileName)) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int count = 0;
                    while ((count = zis.read(buffer)) != -1) {
                        byteArrayOutputStream.write(buffer, 0, count);
                    }
                    byteArrayOutputStream.close();
                    // zipInputStream.closeEntry();
                    zipEntryMap.put(zipEntry.getName(), byteArrayOutputStream);
                }
            }


        }
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(newZip))) {
            zos.putNextEntry(new ZipEntry("new/" + fileName));
            Files.copy(Paths.get(fileName), zos);
            for (Map.Entry<String, ByteArrayOutputStream> entry : zipEntryMap.entrySet()) {
                zos.putNextEntry(new ZipEntry(entry.getKey()));
                zos.write(entry.getValue().toByteArray());
            }
        }
    }
}
