import java.util.Scanner;

public class Game {
    int numberOfTry;
    int wordLength;
    String word;

    public Game(int wordLength, int numberOfTry, String word){
        this.wordLength = wordLength;
        this.numberOfTry = numberOfTry;
        this.word = word;
    }

    public String chooseLettre(){
        char lettre;
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez entrer une lettre :");
        while(true){
            lettre = sc.next().charAt(0);
            if(Character.isLetter(lettre)){
                    break;
            }else{
                System.out.println("Veuillez entrer une lettre de l'alphabet et une seul :");
                sc.nextLine();
            }
        }
        return lettre+"";
    }

    public boolean checkLetter(String Letter){
        return this.word.toLowerCase().contains(Letter.toLowerCase());
    }

    public void play(){
        System.out.println(STR."Le mot que vous chercher contien \{this.word.length()} lettre");
    }
}