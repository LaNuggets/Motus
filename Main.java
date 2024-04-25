class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.display();
        int wordLength = menu.wordLength();
        Randomword rand = new Randomword();
        System.out.println(rand.pickWords(wordLength));
    }
}