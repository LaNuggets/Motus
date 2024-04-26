package Motus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Randomword {

    public static ArrayList<String> pickWordsByLength(String filePath, int length) {
        ArrayList<String> words = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().length() == length) {
                    words.add(line.trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return words;
    }

    public static String pickWords( int wordLength) {
        ArrayList<String> words = Randomword.pickWordsByLength("Motus/Mots.txt", wordLength);
        String randomWord = "";
        if (words.isEmpty()) {
            System.out.println("No words of length " + wordLength + " found.");
        } else {
            Random rand = new Random();
            int randomIndex = rand.nextInt(words.size());
            randomWord = words.get(randomIndex);
        }
        return randomWord;
    }
}


