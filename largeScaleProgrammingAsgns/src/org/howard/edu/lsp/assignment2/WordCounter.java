// Name: Najaat Idris Sampong
package org.howard.edu.lsp.assignment2;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WordCounter {

    public static void main(String[] args) {
        // Relative path to the input file
        String inputFile = "src/org/howard/edu/lsp/assignment2/words.txt";

        // Read the file and count the words
        try {
            Map<String, Integer> wordCount = countWords(inputFile);
            displayWordCount(wordCount);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    private static Map<String, Integer> countWords(String filePath) throws IOException {
        Map<String, Integer> wordCount = new HashMap<>();
        Set<String> trivialWords = createTrivialWordsSet();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into words using regex
                String[] words = line.split("\\s+");

                for (String word : words) {
                    // Remove non-letter characters and convert to lowercase
                    word = word.replaceAll("[^a-zA-Z']", "").toLowerCase();

                    // Ignore trivial words (3 letters or fewer)
                    if (!trivialWords.contains(word)) {
                        // Update word count in the map
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        }

        return wordCount;
    }

    private static Set<String> createTrivialWordsSet() {
        // Set of trivial words (3 letters or fewer)
        Set<String> trivialWords = Set.of("a", "an", "the", "and", "of", "it", "is", "to", "in");

        return trivialWords;
    }

    private static void displayWordCount(Map<String, Integer> wordCount) {
        System.out.println("Word\t\tCount");
        System.out.println("----\t\t-----");

        // TreeMap for sorting the results
        TreeMap<String, Integer> sortedWordCount = new TreeMap<>(wordCount);

        // Display the word count
        for (Map.Entry<String, Integer> entry : sortedWordCount.entrySet()) {
            System.out.printf("%-15s\t%d\n", entry.getKey(), entry.getValue());
        }
    }
}


