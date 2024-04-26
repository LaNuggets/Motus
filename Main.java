class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.display();
        int wordLength = menu.wordLength();
        System.out.println("Word length: " + wordLength);
        Randomword rand = new Randomword();
        String chosenWord = Randomword.pickWords(wordLength);
        int life = menu.numberOfTry();
        Game game = new Game(life, wordLength, chosenWord);
        game.hiddenWord();
        System.out.println("Le mot à deviner est : " + chosenWord);

        String essai = game.guessedWord();

        game.letterMatch(chosenWord,essai);
    }
}