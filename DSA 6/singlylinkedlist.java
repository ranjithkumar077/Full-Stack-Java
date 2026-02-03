class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class ListOfFunctions {
    static Node head;

    // Insert at a given index
    public static void indexInsert(int index, int data) {
        Node newNode = new Node(data);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            if (temp == null) {
                System.out.println("Index out of bounds");
                return;
            }
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Count nodes
    public static int count() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Display list WITHOUT destroying it
    public static void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Insert at beginning
    public static void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert at end
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

    // Reverse the list
    public static void reversedlist() {
        Node prev = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    // Search for a value
    public static boolean search(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key)
                return true;
            temp = temp.next;
        }
        return false;
    }

    // Delete at index
    public static void deleteIndex(int index) {
        if (head == null) return;

        if (index == 0) {
            head = head.next;
            return;
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            if (temp == null || temp.next == null) return;
            temp = temp.next;
        }

        temp.next = temp.next.next;
    }

    // Delete node by value
    public static void deleteByValue(int value) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        // If the value is at the head
        if (head.data == value) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }

        // If found, delete it
        if (temp.next != null) {
            temp.next = temp.next.next;
        } else {
            System.out.println("Value not found in the list");
        }
    }
}

public class singlylinkedlist {
    public static void main(String[] args) {

        ListOfFunctions.addFirst(10);
        ListOfFunctions.addFirst(20);
        ListOfFunctions.addFirst(30);
        ListOfFunctions.addFirst(25);

        ListOfFunctions.display();   

        ListOfFunctions.deleteByValue(30);

        ListOfFunctions.display();   
    }
}
