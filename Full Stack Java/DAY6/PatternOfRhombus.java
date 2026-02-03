import java.util.Scanner;
public class PatternOfRhombus{
    public static void main (String[] args ){
        Scanner sc=new Scanner(System.in);
        System.out.print("enter the row ");
        int rows=sc.nextInt();

        for(int i=0;i<=rows;i++){

            for(int j=0;j<=rows-1;j++){
                System.out.print(" ");   
            }
            System.out.print("*");
            for (int j=0;j<=2*(rows-1)-1;k++){
                System.out.print("*");
            }
            System.out.println();
        }
        sc.close();
    }
}