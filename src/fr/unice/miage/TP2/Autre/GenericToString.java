package fr.unice.miage.TP2.Autre;

/**
 * @version 1.00 23 Mars 2001
 * @author Michel Buffa
 * Inspiré par la classe Reflectiontest.java de
 * Cay S. Horstmann & Gary Cornell, publiée dans le livre Core Java, Sun Press
 */

import java.awt.*;
import java.lang.reflect.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class GenericToString {
    public static String toString(Object root, int depth) throws IllegalAccessException {
        String string = "\n";

        if (depth < 1) {
            return null;
        } else {
            string += root.getClass();

            string += "[";

            for (Field field : getAllFields(root.getClass())) {
                string += " ";
                string += field.getName();
                string += "=";

                field.setAccessible(true);
                if (!field.getType().isPrimitive()) {
                    if (field.getType().isArray()) {
                        string += "{";
                        if (field.getType().getComponentType().isPrimitive()) {
                            for (int i = 0; i < Array.getLength(field.get(root)); i++) {
                                string += Array.get(field.get(root), i) + ";";
                            }
                        }
                        else {
                            for (int i = 0; i < Array.getLength(field.get(root)); i++) {
                                string += toString(Array.get(field.get(root), i), depth - 1) + ";";
                            }
                        }
                        string += "}";
                    }
                    else {
                        string += toString(field.get(root), depth -1);
                    }
                } else {
                    string += field.get(root);
                }

                string += "; ";
            }

            string += "]\n";

            return string;
        }
    }

    public static ArrayList<Field> getAllFields(Class<?> type) {
        ArrayList<Field> fields = new ArrayList<>();

        for (Field field : type.getFields()) {
            if (!fields.contains(field)) {
                fields.add(field);
            }
        }

        for (Field field : type.getDeclaredFields()) {
            if (!fields.contains(field)) {
                fields.add(field);
            }
        }

        return fields;
    }

    public static void main(String[] args) throws IllegalAccessException {
        Polygon polygon = new Polygon(new int[]{10, 20, 30}, new int[]{20, 30, 40}, 3);
        polygon.getBounds();
        System.out.println(toString(polygon, 2));
    }
}