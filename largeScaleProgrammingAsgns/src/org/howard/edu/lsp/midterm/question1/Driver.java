package org.howard.edu.lsp.midterm.question1;
public class Driver {
    /**
     * Main method to invoke the encrypt method and display the result.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Input text
        String originalText = "I love CSCI363";
        // Encrypt the input text
        String encryptedText = SecurityOps.encrypt(originalText);
        // Print the encrypted text
        System.out.println("Encrypted text: " + encryptedText);
    }
}