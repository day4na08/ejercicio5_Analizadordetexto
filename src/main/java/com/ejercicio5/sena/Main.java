package com.ejercicio5.sena;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\Aprendiz\\Downloads\\ejercicio5\\src\\main\\java\\com\\ejercicio5\\sena\\archivo.txt"); 
            TextAnalyzer analyzer = new TextAnalyzer(file);
            analyzer.analyze();
            analyzer.printStatistics();
        } catch (FileNotFoundException e) {
            System.err.println("Error: No se encontró el archivo");
        }
    }
}