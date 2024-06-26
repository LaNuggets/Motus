import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Menu {

    public Menu(){
    }

    public void display(){
        System.out.println("Welcome to Motus game");
    }

    public int wordLength(){
        String regex = "^[0-9]|1[0-1]$";
        Pattern pattern = Pattern.compile(regex);
        int maxLengthInt = 0;
        System.out.println("Please enter a word length:");
        Scanner sc = new Scanner(System.in);
        while(true){
            String maxLength = sc.nextLine();
            Matcher matcher = pattern.matcher(maxLength);
            if (matcher.matches()){
                maxLengthInt = Integer.parseInt(maxLength);
                if(maxLengthInt >=4 && maxLengthInt <= 11){
                    break;
                } else {
                    System.out.println("Please enter a word length between 4 and 11");
                }
            } else {
                System.out.println("Please enter a number between 4 and 11");
            }
        }
        return maxLengthInt;
    }

    public int numberOfTry(){
        String regex = "^[0-9]|1[0-1]$";
        Pattern pattern = Pattern.compile(regex);
        int lifeInt = 0;
        System.out.println("Please enter number of try you want:");
        Scanner sc = new Scanner(System.in);
        while(true){
            String life = sc.nextLine();
            Matcher matcher = pattern.matcher(life);
            if (matcher.matches()){
                lifeInt = Integer.parseInt(life);
                if(lifeInt <= 7 && lifeInt >= 1){
                    break;
                } else {
                    System.out.println("Your number of try must be between 1 and 7");
                }
            } else {
                System.out.println("Please enter a number between 1 and 7");
            }
        }
        return lifeInt;
    }
}