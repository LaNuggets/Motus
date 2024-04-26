package Motus;
import java.awt.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.display();
        int wordLength = menu.wordLength();
        int life = menu.numberOfTry();

        String filePath = "Motus/Mots.txt";
        String randomWord = Randomword.pickRandomWord(filePath);

        // Afficher les traits pour chaque lettre du mot
        StringBuilder trait = new StringBuilder();
        trait.append("===================\n");
        for (int i = 0; i < randomWord.length(); i++) {
            trait.append("| _ ");
        }

        trait.append("|\n");
        trait.append("===================");
        System.out.println("Mot à deviner : \n" + trait.toString());
    }
    }
}
