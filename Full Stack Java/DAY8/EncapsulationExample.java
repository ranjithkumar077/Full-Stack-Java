import java.lang.Math;
public class EncapsulationExample {
    public static void main(String[] args) {
       
Account acc=new Account("3586558858555588");
float balance=acc.getbalance();
System.out.println("Balance: "+acc.getbalance());



        class Account{
            private float balance=1000.0f;
            String AccountNumber;
            protected float getbalance()
            {
                return balance;
            }
            protected float updatebalance(float amount){
               
             if(amount<0 && Math.abs(amount)>this.balance){ 
                this.balance+=amount;
                return this.balance;                        
        }}


     //   private String secretData;

    //     public EnapsulationExample(String data) {
    //         this.secretData = data;
    //     }

    //     // Getter method to access the private variable
    //     public String getSecretData() {
    //         return secretData;
    //     }

    //     // Setter method to modify the private variable
    //     public void setSecretData(String data) {
    //         this.secretData = data;
    //     }

    //     public static void main(String[] args) {
    //         EncapculationExample example = new EncapculationExample("Initial Secret");
            
    //         // Accessing the private variable using getter
    //         System.out.println("Secret Data: " + example.getSecretData());
            
    //         // Modifying the private variable using setter
    //         example.setSecretData("Updated Secret");
    //         System.out.println("Secret Data: " + example.getSecretData());
        }
    }
