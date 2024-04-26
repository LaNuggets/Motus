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
}