import java.util.Scanner;

public class HollowDiamondPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows for the diamond (half height): ");
        int n = sc.nextInt();

        // Upper half of the diamond
        for (int i = 1; i <= n; i++) {
            // Print leading spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // Print first star
            System.out.print("*");
            // Print inner spaces
            for (int j = 1; j <= 2 * (i - 1) - 1; j++) {
                System.out.print(" ");
            }
            // Print second star (if not the first row)
            if (i > 1) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Lower half of the diamond
        for (int i = n - 1; i >= 1; i--) {
            // Print leading spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // Print first star
            System.out.print("*");
            // Print inner spaces
            for (int j = 1; j <= 2 * (i - 1) - 1; j++) {
                System.out.print(" ");
            }
            // Print second star (if not the first row)
            if (i > 1) {
                System.out.print("*");
            }
            System.out.println();
        }
        sc.close();
    }
}