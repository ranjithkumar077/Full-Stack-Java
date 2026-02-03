import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;;

public class ArrayList1 {    
    public static void main(String[] args) {
        ArrayList<Integer> nums  = new ArrayList<>(Arrays.asList(100,2,3));
        Test t = new Test();
       nums.add(20);
       nums.add(30);
       nums.add(40);
        System.out.println("nUms: " + nums);
        System.out.println("Size: " + nums.size());
        nums.remove(2);
        System.out.println("After removing index 2: " + nums);  
        System.out.println("Size after removal: " + nums.size());
        System.out.println("Element at index 1: " + nums.get(1));   
        nums.set(1, 200);
        System.out.println("After setting index 1 to 200: " + nums);
        System.out.println("Size remains: " + nums.size());
        
        }
    }

class Test {

}
 {

}