import java.util.Scanner;

public class Menu {

    public Menu() {
    }

    public void display() {
        System.out.println("Welcome to Motus");
    }

    public int wordLength() {
        int maxLength = 0;
        System.out.println("Please enter a word length:");
        Scanner sc = new Scanner(System.in);
        while (true) {
            maxLength = sc.nextInt();
            if (maxLength >= 4 && maxLength <= 12) {
                break;
            } else {
                System.out.println("Please enter a word length between 4 and 12");
            }
        }
        sc.close();
        return maxLength;
    }
}


