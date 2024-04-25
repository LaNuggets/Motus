public class Main {
    public static void main(String[] args) {
        String filePath = "Motus/Mots.txt";
        String randomWord = Randomword.pickRandomWord(filePath);
        System.out.println("Mot aléatoire : " + randomWord);
    }
}
