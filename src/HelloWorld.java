import java.util.Scanner;

public class HelloWorld {
    public static void main (String[] args){
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        scanner.close();
        System.out.println("Hello, " + name + "!");
    }
}
