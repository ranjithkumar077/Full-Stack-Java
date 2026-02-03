public class compileTimePolymerphism{
public static void main(String[] args) {
        Addition addition = new Addition();
        
        int intResult = addition.add(5, 10);
        float floatResult = addition.add(5.5f, 10.2f);
        String stringResult = addition.add("Ranjith ", "Kumara");
        double doubleResult = addition.add(3.14, 2.71);

        
        System.out.println("Integer Addition: " + intResult);
        System.out.println("Float Addition: " + floatResult);
        System.out.println("Double Addition: " + doubleResult);
        System.out.println("String Addition: " + stringResult);
}
}

    class Addition {
            public int add(int a, int b) {
                return a + b;
            }
            public float add(float a, float b) {
                return a + b;
            }
            public String add(String a, String b) {
                return a + b;
            }
            public double add(double a, double b) {
                return a + b;
            }
    }
    
