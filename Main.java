import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.display();
        int wordLength = menu.wordLength();
        ArrayList<String> words = Randomword.pickWordsByLength("Motus/Mots.txt", wordLength);

        if (words.isEmpty()) {
            System.out.println("No words of length " + wordLength + " found.");
        } else {
            Random rand = new Random();
            int randomIndex = rand.nextInt(words.size());
            String randomWord = words.get(randomIndex);
            System.out.println("Random word of length " + wordLength + ": " + randomWord);
        }
    }
}

