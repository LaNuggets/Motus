package Motus;

class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.display();
        int wordLength = menu.wordLength();
        Randomword rand = new Randomword();
        String chosenWord = Randomword.pickWords(wordLength);
        int life = menu.numberOfTry();
        Game game = new Game(life, wordLength, chosenWord);
        game.play(life);
    }
}