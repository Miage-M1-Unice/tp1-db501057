package fr.unice.miage;

import java.io.File;

public class Main {


    public void getRepository(){
        String[] tabRepos;
        File f = new File("./src/fr/unice/miage/");
        String[] flist = f.list();
        for (int i = 0; i < flist.length; i++){
            System.out.println(flist[i]);
        }
    }

    public void getRepoContentRecu(String pathName){
        String[] tabRepos;
        File f = new File(pathName);
        File[] flist = f.listFiles();
        for (int i = 0; i < flist.length; i++){
            if(flist[i].isDirectory()){
                //System.out.println(flist[i]);
                getRepoContentRecu(flist[i].getPath());
            } else {
                System.out.println(flist[i].getName());
            }
            //System.out.println(flist[i]);
        }
    }


    public static void main(String[] args){
        Main main = new Main();
        main.getRepoContentRecu("./");
    }

}
