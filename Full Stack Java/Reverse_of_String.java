import java.util.Scanner;

public class Reverse_of_String {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the String to Reverse: ");
        String str=sc.nextLine();
        String sp=" ";
        String rev ="";
        for(int i=str.length()-1;i>=0;i--){
            rev += str.charAt(i);

        }
        System.out.println("Reversed string:"+sp + rev);
    }
    
}
