
/**
 * @version 1.00 23 Mars 2001
 * @author Michel Buffa
 * Inspiré par la classe Reflectiontest.java de
 * Cay S. Horstmann & Gary Cornell, publiée dans le livre Core Java, Sun Press
 */


import java.lang.reflect.*;
import java.io.*;


public class AnalyseurDeClasse {

    public static void analyseClasse(String nomClasse) throws ClassNotFoundException {
        // Récupération d'un objet de type Class correspondant au nom passé en
        // paramètres
        ClassLoader classLoader = AnalyseurDeClasse.class.getClassLoader();
        Class cl = classLoader.loadClass(nomClasse);

        afficheEnTeteClasse(cl);

        System.out.println();
        afficheAttributs(cl);

        System.out.println();
        afficheConstructeurs(cl);

        System.out.println();
        afficheMethodes(cl);

        // L'accolade fermante de fin de classe !
        System.out.println("}");
    }

    /** Retourne la classe dont le nom est passé en paramètre */
    public static Class getClasse(String nomClasse) throws ClassNotFoundException {
        return nomClasse.getClass();
    }

    /**
     * Cette méthode affiche par ex "public class Toto extends Tata implements Titi,
     * Tutu {"
     */
    public static void afficheEnTeteClasse(Class cl) {
        // Affichage du modifier et du nom de la classe
        // CODE A ECRIRE

        // Récupération de la superclasse si elle existe (null si cl est le type Object)
        Class supercl = cl.getSuperclass();
        System.out.println("The super class is " + supercl);

        // On ecrit le "extends " que si la superclasse est non nulle et
        // différente de Object
        /*Class classExtend = cl.getEnclosingClass();
        System.out.println("The extend class is " + classExtend);*/

        Class[] interfaces = cl.getInterfaces();
        System.out.println("Interfaces");
        for (int i = 0; i < interfaces.length; i++) {
            System.out.println("\t" + interfaces[i]);
        }

        // Enfin, l'accolade ouvrante !
        System.out.print(" {\n");
    }

    public static void afficheAttributs(Class cl) {
        Field[] attributes = cl.getFields();
        System.out.println("Fields");
        for (int i = 0; i < attributes.length; i++){
            System.out.println("\t" + attributes[i]);
        }
    }

    public static void afficheConstructeurs(Class cl) {
        Constructor[] constructors = cl.getConstructors();
        System.out.println("Conctructor");
        for (int i = 0; i < constructors.length; i++){
            System.out.println("\t" + constructors[i]);
        }
        System.out.println("{}");
    }

    public static void afficheMethodes(Class cl) {
        Method[] methods = cl.getMethods();
        System.out.println("Methods");
        for (int i = 0; i < methods.length; i++){
            System.out.println("\t" + methods[i]);
        }
        System.out.println("{}");
    }

    public static String litChaineAuClavier() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    /*public static void main(String[] args) {
        boolean ok = false;

        while (!ok) {
            try {
                System.out.print("Entrez le nom d'une classe (ex : java.util.Date): ");
                String nomClasse = litChaineAuClavier();

                analyseClasse(nomClasse);

                ok = true;
            } catch (ClassNotFoundException e) {
                System.out.println("Classe non trouvée.");
            } catch (IOException e) {
                System.out.println("Erreur d'E/S!");
            }
        }
    }*/
}
