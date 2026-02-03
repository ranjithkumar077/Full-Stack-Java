import java.util.Scanner;
public class RemoveSpaces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String : ");
        String str = sc.nextLine();
        sc.close();
        String noSpaces = str.replace(" ", "");
        System.out.println("OUTPUT : ");
        System.out.println("String without spaces: "+noSpaces);
        sc.close();
    }
}
