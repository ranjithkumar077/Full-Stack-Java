import java.util.Scanner;
public class ReverseWordsRunTime {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Space separated words  :  ");
        String str=sc.nextLine();
        sc.close();
        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i=0;i<words.length;i++){
            String Reversed = new StringBuilder(words[i]).reverse().toString();
            result.append(Reversed);
            if (i<words.length-1){
                result.append(" ");
            }
        }
        System.out.println("OUTPUT : ");
        System.out.println("Reversed words: "+result.toString());
        
    }
}
