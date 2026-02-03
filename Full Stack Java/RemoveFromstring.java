import java.util.Scanner;
public class RemoveFromstring {
    //remove the specfied word or space to remove 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String : ");
        String str = sc.nextLine();
        System.out.print("enter what to remove from the String :");
        String temp = sc.nextLine();
        sc.close();
        String Del_string = str.replaceAll(temp, "");
        System.out.println("OUTPUT : ");
        System.out.println("String after remove : "+Del_string);
        
    }
}
