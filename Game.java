import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Timer;
import java.util.TimerTask;

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
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int second = 10;
            public void run() {
                if (second > 0){
//                    System.out.print(STR."\rTime remining \{second}");
                    second --;
                }else {
                    System.out.println("\rTime's up! You lose!");
                    timer.cancel();
                    System.exit(0);
                }
            }
        },0, 1000);
        String userWord = this.guessedWord();
        String wordToGuess = this.word.toLowerCase();
        userWord = this.letterMatch(wordToGuess,userWord);
        life--;
        while(!userWord.equals(wordToGuess) && life > 0){
            life--;
            userWord = this.guessedWord().toLowerCase();
            userWord = this.letterMatch(wordToGuess,userWord);
        }
        timer.cancel();
        if (life == 0){
            System.out.println("You lose !");
            System.out.println(STR."The word was \{wordToGuess}");
        }else {
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
        Scanner scanner = new Scanner(System.in);
        String ANSI_GREEN_BACKGROUND = "\u001B[42m";
        String ANSI_RED_BACKGROUND = "\u001B[41m";
        String ANSI_ORANGE_BACKGROUND = "\u001B[43m";
        String ANSI_RESET = "\u001B[0m";

        StringBuilder trait = new StringBuilder();
        trait.append("===================\n");
        for (int i = 0; i < this.wordLength; i++) {
            char userLetter = userWord.charAt(i);
            if (randomWord.charAt(i) == userLetter) {
                trait.append("| " + ANSI_GREEN_BACKGROUND + userLetter + ANSI_RESET + " "); // vrai
            } else if (randomWord.contains(String.valueOf(userLetter))) {
                trait.append("| " + ANSI_ORANGE_BACKGROUND + userLetter + ANSI_RESET + " "); // faux mais présent
            } else {
                trait.append("| " + ANSI_RED_BACKGROUND + userLetter + ANSI_RESET + " "); // faux
            }
        }
        trait.append("|\n");
        trait.append("===================");
        System.out.println("Word to guess: \n" + trait.toString());
        return userWord;
    }

}