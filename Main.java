class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.display();
        int wordLength = menu.wordLength();
        int life = menu.numberOfTry();
        Game game = new Game(wordLength, life, "vache");
        String letter =game.chooseLettre();
       System.out.println(game.checkLetter(letter));
    }
}