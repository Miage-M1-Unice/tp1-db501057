package fr.unice.miage.TP2;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;


public class GeneriqueToString {

    public GeneriqueToString(){};

    public String toString(Object object, int profondeur) throws IllegalAccessException {
        Class c = object.getClass();
        String className = c.getName();
        Field[] field = c.getDeclaredFields();
        ArrayList<Field> fieldArray = getFields(c);
        return "";
    }

    private ArrayList<Field> getFields(Class clasS){
        ArrayList<Field> fields = new ArrayList<>(Arrays.asList(clasS.getFields()));
        Field[] fieldDeclared = clasS.getDeclaredFields();

        for (int i = 0; i < fieldDeclared.length; i++) {
            if (!fields.contains(fieldDeclared[i])){
                fields.add(fieldDeclared[i]);
            }
        }
        return fields;
    }

}
