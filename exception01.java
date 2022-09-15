import java.util.InputMismatchException;
import java.util.Scanner;

public class exception01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numerator, divisor;
        double sum;
        try {
            System.out.println("Enter a numerator:");
            numerator = input.nextInt();
            System.out.println("Enter a divisor:");
            divisor = input.nextInt();
            System.out.printf("%d / %d = %d", numerator, divisor, numerator / divisor);
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Invalid input!");
        } catch (Exception e){
            System.out.printf("ERROR: %s", e.getMessage());
        }



    }
}
