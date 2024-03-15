package org.howard.edu.lsp.midterm.question1;

public class SecurityOps {
    /**
     * Encrypts the input text by rearranging characters based on their index.
     *
     * @param text The text to encrypt.
     * @return The encrypted text.
     */
    public static String encrypt(String text) {
        StringBuilder evenChars = new StringBuilder();
        StringBuilder oddChars = new StringBuilder();

        // Remove punctuation and whitespace
        text = text.replaceAll("[^a-zA-Z0-9]", "");

        // Separate even and odd-index characters while preserving capitalization
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (i % 2 == 0) {
                evenChars.append(c);
            } else {
                oddChars.append(c);
            }
        }

        // Concatenate even and odd characters and return the encrypted text
        return evenChars.toString() + oddChars.toString();
    }
}