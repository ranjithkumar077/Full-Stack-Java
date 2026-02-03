import java.util.Scanner;

public class RhombusPattern {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows for the rhombus: ");
        int rows = scanner.nextInt();

        // Outer loop for the number of rows
        for (int i = 1; i <= rows; i++) {
            // Inner loop to print leading spaces
            // The number of spaces decreases with each row
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            // Inner loop to print stars for the rhombus
            // The number of stars remains constant for each row of a solid rhombus
            for (int k = 1; k <= rows; k++) {
                System.out.print("*");
            }
            // Move to the next line after each row is printed
            System.out.println();
        }
        scanner.close();
    }
}