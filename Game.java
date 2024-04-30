package Motus;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {
    int numberOfTry;
    int wordLength;
    String word;

    public Game(int numberOfTry, int wordLength, String word){
        this.wordLength = wordLength;
        this.numberOfTry = numberOfTry;
        this.word = word;
    }

    public String guessedWord(){
        String word;
        String regex ="[a-zA-Z]+";
        Pattern pattern = Pattern.compile(regex);
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a word: :");
        while(true){
            word = sc.nextLine();
            Matcher matcher = pattern.matcher(word);
            if(matcher.matches() && word.length() == this.wordLength){
                break;
            }else{
                System.out.println(STR."Please choose a word with \{this.wordLength} letter :");
            }
        }
        return word.toLowerCase();
    }

    public void play(int life){
        this.hiddenWord();
        String userWord = this.guessedWord().toLowerCase();
        String wordToGuess = this.word.toLowerCase();
        userWord = this.letterMatch(wordToGuess,userWord);
        life--;
        while(!userWord.equals(wordToGuess) && life>0){
            life--;
            userWord = this.guessedWord().toLowerCase();
            userWord = this.letterMatch(wordToGuess,userWord);

        }
        if (life == 0){
            System.out.println("You lose !");
            System.out.println(STR."The word was \{wordToGuess}");
        } else {
            System.out.println("You win!");

        }
    }

    public void hiddenWord() {
        StringBuilder trait = new StringBuilder();
        trait.append("===================\n");
        for (int i = 0; i < this.wordLength; i++) {
            trait.append("| _ ");
        }
        trait.append("|\n");
        trait.append("===================");
        System.out.println("Word to guess : \n" + trait.toString());
    }


    public String letterMatch(String randomWord, String userWord) {
        String ANSI_GREEN_BACKGROUND = "\u001B[42m";
        String ANSI_RED_BACKGROUND = "\u001B[41m";
        String ANSI_ORANGE_BACKGROUND = "\u001B[43m";
        String ANSI_RESET = "\u001B[0m";

        StringBuilder trait = new StringBuilder();
        trait.append("===================\n");

        boolean[] alreadyMatched = new boolean[randomWord.length()]; // Tableau pour suivre les lettres déjà trouvées

        for (int i = 0; i < userWord.length(); i++) {
            char userLetter = userWord.charAt(i);
            boolean matched = false;

            for (int j = 0; j < randomWord.length(); j++) {
                if (userLetter == randomWord.charAt(j) && !alreadyMatched[j]) {
                    if (i == j) {
                        trait.append("| " + ANSI_GREEN_BACKGROUND + userLetter + ANSI_RESET + " "); // lettre correctement placée
                    } else {
                        trait.append("| " + ANSI_ORANGE_BACKGROUND + userLetter + ANSI_RESET + " "); // lettre mal placée
                    }
                    alreadyMatched[j] = true;
                    matched = true;
                    break;
                }
            }

            if (!matched) {
                trait.append("| " + ANSI_RED_BACKGROUND + userLetter + ANSI_RESET + " "); // lettre non présente
            }
        }

        trait.append("|\n");
        trait.append("===================");
        System.out.println("Word to guess: \n" + trait.toString());
        return userWord;
    }

}