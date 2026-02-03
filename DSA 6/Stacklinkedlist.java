public Node{
    private Node top
    int data ;
    Node next;      
    Node(int data){
        this.data = data;
        this.next = null;
    }class StackMethods{
        private Node top;
    }
    //push
    public static void push(int data){
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }   
    //pop
    public static int pop(){
        if(top == null){
            System.out.println(" no data ");
            return ;
        }
        int poppedData = top.data;
        top = top.next;
        
    }
    //peak
    public static void topvalue (){
        if(top == null){
            System.out.println("no data");
        }
        else{
            System.out.println("Top element is: " + top.data);
        }
    }
    public static void display(){
        Node temp = top;

        
        while(temp != null){
            System.out.print (temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class Stacklinkedlist
{
public static void main(String[] args) {
    
}
} 
