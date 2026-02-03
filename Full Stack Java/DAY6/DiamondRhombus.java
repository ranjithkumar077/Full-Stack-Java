import java.util.Scanner;
public class DiamondRhombus {
    public static void main(String[] args) {
        //Scanner sc =new Scanner(System.in);
        //System.out.println("Enter the No Of Rows to Print : ");
        int rows =11;
        int cols=11;
        int spaces=0;
        if(rows%2==0||cols==0){
            System.out.println("Cannnot print the Diamond Shapes ");
        }
        System.out.println("*");
        for (int space=0;space<=spaces-1;space++){
            System.out.println(" "); 
        }
        for(int row=1;row<=rows;row++){

            for(int col=1;col<=cols-1;col++)
                System.out.print("*");

        }
        System.out.print(" ");
    }
    
}
