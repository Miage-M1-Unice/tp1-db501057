package fr.unice.miage;

import java.io.File;
import java.io.FilenameFilter;

public class FiltertFile implements FilenameFilter {


    @Override
    public boolean accept(File dir, String name) {
        String fileName = dir.getName();
        String[] splitName = fileName.split("\\.");
        String fileExtension = splitName[splitName.length - 1];
		return fileExtension.equals(name);
    }
}
