import java.util.Scanner;
public class CountVowelsConstants{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String : ");
        String str = sc.nextLine();
        sc.close();
        int vowels = 0;
        int constants = 0;
        int digits = 0;
        str=str.toLowerCase();//to convert the string to upper case str.toUpperCase()
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ("aeiouAIEOU".indexOf(ch) != -1) {
                vowels++;
            }
            else if (ch>='A' && ch<='z') {// upper case (ch>='A' && ch<='Z') and digit (ch>='0' && ch<='9')
                constants++;
            }
            else if (ch>='0' && ch<='9') {//  digit (ch>='0' && ch<='9')
            digits++;
        }
        }
        System.out.println("OUTPUT : ");
        System.out.println("Vowels: "+vowels);
        System.out.println("Constants: "+constants);
        System.out.println("Digits: "+digits);
        sc.close();

    }
}
