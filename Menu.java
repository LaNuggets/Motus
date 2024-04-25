import java.util.Scanner;

class Menu {

    public Menu(){
    }

    public void display(){
        System.out.println("Welcome to Motus");
    }

    public int wordLength(){
        int maxLength = 0;
        System.out.println("Please enter a word length:");
        Scanner sc = new Scanner(System.in);
        while(true){
            maxLength = sc.nextInt();
            if(maxLength >=4 &&maxLength <= 11){
                break;
            } else {
                System.out.println("Please enter a word length between 4 and 12");
            }
        }
        return maxLength;
    }

    public int numberOfTry(){
        int life = 0;
        System.out.println("Please enter number of try you want:");
        Scanner sc = new Scanner(System.in);
        while(true){
            life = sc.nextInt();
            if(life<=7 && life>=1){
                break;
            } else {
                System.out.println("Your number of try must be between 1 and 7");
            }
        }
        return life;
    }
}