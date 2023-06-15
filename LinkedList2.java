import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void removeDuplicates() {
        if (head == null) {
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }
}

public class LinkedList2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the linked list: ");
        int size = scanner.nextInt();

        LinkedList list = new LinkedList();

        System.out.println("Enter the elements in non-decreasing order:");
        for (int i = 0; i < size; i++) {
            int data = scanner.nextInt();
            list.append(data);
        }

        System.out.println("Original linked list:");
        list.display();

        list.removeDuplicates();

        System.out.println("Linked list after removing duplicates:");
        list.display();
    }
}
