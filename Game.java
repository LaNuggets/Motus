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
        String regex =".*\\d.*";
        Pattern pattern = Pattern.compile(regex);
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez entrer un mot :");
        while(true){
            word = sc.nextLine();
            Matcher matcher = pattern.matcher(word);
            if(!matcher.matches() && word.length() == wordLength){
                break;
            }else{
                System.out.println(STR."Veuillez entrer un mot de \{this.wordLength} lettre :");
            }
        }
        return word;
    }

    public boolean checkLetter(String Letter){
        return this.word.toLowerCase().contains(Letter.toLowerCase());
    }

    public void play(int life){
        System.out.println(STR."Le mot que vous chercher contien \{this.wordLength} lettre");
        while(life>0){
            String word = this.guessedWord();
            System.out.println(word);
            if(this.checkLetter(word)){
                //Fonction print le mot
            }else {
                //Fonction print le mot
                life--;
            }
        }
    }
    public String hiddenWord() {
        StringBuilder trait = new StringBuilder();
        trait.append("===================\n");
        for (int i = 0; i < this.wordLength; i++) {
            trait.append("| _ ");
        }
        trait.append("|\n");
        trait.append("===================");
        System.out.println("Mot à deviner : \n" + trait.toString());
        return trait.toString();
    }

public String letterMatch(String randomWord, String userWord) {
    Scanner scanner = new Scanner(System.in);
    String ANSI_GREEN = "\u001B[32m";
    String ANSI_RED = "\u001B[31m";
    String ANSI_ORANGE = "\u001B[33m";
    String ANSI_RESET = "\u001B[0m";

    while (!userWord.equals(randomWord)) {
        StringBuilder trait = new StringBuilder();
        trait.append("===================\n");
        for (int i = 0; i < this.wordLength; i++) {
            char userLetter = userWord.charAt(i);
            if (randomWord.charAt(i) == userLetter) {
                trait.append("| " + ANSI_GREEN + userLetter + ANSI_RESET + " "); // vrai
            } else if (randomWord.contains(String.valueOf(userLetter))) {
                trait.append("| " + ANSI_ORANGE + userLetter + ANSI_RESET + " "); // faux mais présent
            } else {
                trait.append("| " + ANSI_RED + userLetter + ANSI_RESET + " "); // faux
            }
        }
        trait.append("|\n");
        trait.append("===================");
        System.out.println("Mot à deviner : \n" + trait.toString());

        System.out.println("Veuillez entrer un nouveau mot :");
        userWord = scanner.nextLine();
    }
    return userWord;
}


}