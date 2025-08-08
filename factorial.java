import java.util.Scanner;

public class factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number ");
        String input = sc.nextLine();
        System.out.println("You entered: " + input);
        sc.close(); 
        System.out.println(input.getClass());
    }
}
