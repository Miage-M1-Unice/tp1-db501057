package fr.unice.miage;

import java.io.File;
import java.io.FileFilter;

public class Main {


    public class FilterFileInterne implements FileFilter {
        @Override
        public boolean accept(File dir, String name) {
            String fileName = dir.getName();
            String[] splitName = fileName.split("\\.");
            String fileExtension = splitName[splitName.length - 1];
            return fileExtension.equals(name);
        }
    }


    public void getRepository(){
        File f = new File("./src/fr/unice/miage/");
        String[] flist = f.list();
        for (int i = 0; i < flist.length; i++){
            System.out.println(flist[i]);
        }
    }

    public void getRepoContentRecu(String pathName){
        FiltertFile filter = new FiltertFile();
        File f = new File(pathName);
        File[] flist = f.listFiles();
        for (int i = 0; i < flist.length; i++){
            if(flist[i].isDirectory()){
                getRepoContentRecu(flist[i].getPath());
            } else {
                if (filter.accept(flist[i], "java")) {
                    System.out.println(flist[i].getName());
                }
            }
        }
    }


    public static void main(String[] args){
        Main main = new Main();
        main.getRepoContentRecu("./");
    }

}
