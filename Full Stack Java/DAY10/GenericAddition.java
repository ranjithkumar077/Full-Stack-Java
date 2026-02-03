public class GenericAddition {

    /**
     * A generic method to add two numbers of any type that extends Number.
     * 
     * The bound <T extends Number> ensures that num1 and num2 have the 
     * doubleValue() method we need to perform the calculation.
     */
    public static <T extends Number> Integer addNumbers(T num1, T num2) {
        // We cannot use 'num1 + num2' directly because Java doesn't know 
        // how to use the '+' operator on a generic 'T'.
        
        // Instead, we convert both to double to perform the arithmetic.
        Integer sum = num1.intValue() + num2.intValue();
        
        return sum;
    }

    public static void main(String[] args) {
        // Example with Integers
        // Integer int1 = 10;
        // Integer int2 = 20;
        // double sumInts = addNumbers(int1, int2);
        // System.out.println("Sum of Integers (10 + 20): " + sumInts); // Output: 30.0

        // Example with Doubles
        Integer dbl1 = 15;
        Integer dbl2 = 2;
        double sum = addNumbers(dbl1, dbl2);
        System.out.println("Sum of Integers : " + sum); 
        // This approach would not work for types that do not extend Number:
        // String s1 = "Hello";
        // String s2 = "World";
        // addNumbers(s1, s2); // Compile-time error
    }
}
