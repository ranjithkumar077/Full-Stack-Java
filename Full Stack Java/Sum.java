import java.util.Scanner;
public class Sum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number separate by the comma : ");
        String input=sc.nextLine();
        sc.close();
        String sp=" ";
        String[] parts=input.split(",");
        int num1= Integer.parseInt(parts[0].trim());
        int num2= Integer.parseInt(parts[1].trim());
        int res= num1+num2;
        System.out.println("First number : "+num1);
        System.out.println("Second number : "+num2);
        System.out.println(num1+sp+"+"+sp+num2+sp+"="+sp+res);
        
    }
}
