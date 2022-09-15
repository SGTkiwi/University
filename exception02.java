import java.util.InputMismatchException;
import java.util.Scanner;

public class exception02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int i = 0;
        int max = -999;
        while (i != -1) {
            try {
                System.out.println("Enter a positive integer:");
                i = input.nextInt();
                max = Math.max(max, i);
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Invalid input!");
                break;
            }
        }
        if (max < 0) {
            System.out.println("No valid input entered!");
        } else {
            System.out.printf("The maximum integer is %d.", max);
        }
    }

    private static int getSumSquares(String[] strings) {
        int sum = 0;
        for (int i = 0; i < strings.length; i++) {
            try {
                sum += Math.pow(Integer.parseInt(strings[i]), 2) ;
            } catch (Exception e) {
                continue;
            }
        }
        return sum;
    }
}
