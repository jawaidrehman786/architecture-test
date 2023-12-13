package com.smallwordtest;

public class PhraseInverter {

    public static String invertPhrase(String phrase) {
        // Check for null or empty phrase
        if (phrase == null || phrase.isEmpty()) {
            return "";
        }

        // Split the phrase into words
        String[] words = phrase.split("\\s+");
        StringBuilder invertedPhrase = new StringBuilder();

        // Loop through words in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            String word = words[i];

            // Check if the word is hyphenated
            if (word.contains("?") || word.contains(",")) {
                // Split hyphenated word into parts
                String[] hyphenatedWords = word.split("\\s+|(?<=\\w)(?=\\?)|(?<=\\?)(?=\\w)");
                   System.out.println(hyphenatedWords.length);

                // Invert and append hyphenated parts
                for (int j = hyphenatedWords.length -1; j >= 0; j--) {
                    invertedPhrase.append(hyphenatedWords[j]);
                    if (j > 1) {
                        invertedPhrase.append("?");
                    }
                }
            } else {
                invertedPhrase.append(word);
            }

            // Add a space after each word except the last one
            if (i > 0) {
                invertedPhrase.append(" ");
            }
        }

        return invertedPhrase.toString();
    }

    public static void main(String[] args) {
        String phrase = "Are you twenty-one years old?";
        String invertedPhrase = invertPhrase(phrase);
        System.out.println("Original phrase: " + phrase);
        System.out.println("Inverted phrase: " + invertedPhrase); // Output: old? years one-twenty you are how are-you how Hello?
    }

}
