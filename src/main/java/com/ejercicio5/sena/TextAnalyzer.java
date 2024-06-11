package com.ejercicio5.sena;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TextAnalyzer {
    private File file;
    private List<String> words;
    private List<String> sentences;
    private Map<String, Integer> wordFrequency;

    public TextAnalyzer(File file) {
        this.file = file;
        this.words = new ArrayList<>();
        this.sentences = new ArrayList<>();
        this.wordFrequency = new HashMap<>();
    }

    public void analyze() throws FileNotFoundException {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] wordsInLine = line.split("\\s+");
                for (String word : wordsInLine) {
                    words.add(word);
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
                sentences.add(line);
            }
        }
    }

    public void printStatistics() {
        int totalWords = words.size();
        int totalSentences = sentences.size();
        String mostFrequentWord = getMostFrequentWord();
        double averageWordLength = getAverageWordLength();

        System.out.println("Estadísticas del texto:");
        System.out.println("Número total de palabras: " + totalWords);
        System.out.println("Número total de oraciones: " + totalSentences);
        System.out.println("Palabra más frecuente: " + mostFrequentWord);
        System.out.println("Longitud promedio de las palabras: " + averageWordLength);
    }

    private String getMostFrequentWord() {
        String mostFrequentWord = null;
        int maxFrequency = 0;
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                mostFrequentWord = entry.getKey();
            }
        }
        return mostFrequentWord;
    }

    private double getAverageWordLength() {
        int totalCharacters = 0;
        for (String word : words) {
            totalCharacters += word.length();
        }
        return (double) totalCharacters / words.size();
    }
}
