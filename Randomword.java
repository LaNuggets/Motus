package Motus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Randomword {

    public static String pickRandomWord(String filePath) {
        ArrayList<String> words = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Random rand = new Random();
        int randomIndex = rand.nextInt(words.size());
        return words.get(randomIndex);
    }
}

