import java.util.Scanner;
public class StringBuilder_Reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String :  ");
        String str=sc.nextLine();
        StringBuilder sb= new StringBuilder(str);
        System.out.print("Reversed string :"+sb.reverse());
    }
}
