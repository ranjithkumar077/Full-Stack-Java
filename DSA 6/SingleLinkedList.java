class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class Listoffunction {
    static Node head = null;
    public static void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    public static void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode; 
    }


    public static void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class SingleLinkedList {
    public static void main(String[] args) {
        Listoffunction.addFirst(10);
        Listoffunction.addFirst(20);
        Listoffunction.addFirst(30);
        Listoffunction.addFirst(40);

        Listoffunction.display();
    }
}
