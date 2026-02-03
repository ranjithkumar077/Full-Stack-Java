import java.util.Scanner;
public class Task {
    public int Sumofnumbers(int a){
        int sum = 0;
        while (a > 0) {
            sum += a % 10;
            a /= 10;
        }
        return sum;
    }
    
    public void printWords(String str) {
        String[] words = str.split(" ");
        for (String word : words) {
            System.out.println(word);
        }
    }
    
    public void reverseString(String str) {
        StringBuilder reversed = new StringBuilder(str);
        reversed.reverse();
        System.out.println(reversed.toString());
    }
    
    public static void main(String[] args) {
        String aboutMe = "My name is RanjithKumar and I am 20 years old";
        Task task = new Task();
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int sum = task.Sumofnumbers(a);
        System.out.println(sum);
        scanner.close();
        task.printWords(aboutMe);
        task.reverseString(aboutMe);
    }
}
