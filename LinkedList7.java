import java.util.Scanner;

class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;

    public DoublyLinkedList() {
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
            newNode.prev = current;
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

    public void reverse() {
        if (head == null || head.next == null) {
            return;
        }

        Node current = head;
        Node temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }
    }
}

public class LinkedList7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the doubly linked list: ");
        int size = scanner.nextInt();

        DoublyLinkedList list = new DoublyLinkedList();

        System.out.println("Enter the elements:");
        for (int i = 0; i < size; i++) {
            int data = scanner.nextInt();
            list.append(data);
        }

        System.out.println("Original doubly linked list:");
        list.display();

        list.reverse();

        System.out.println("Reversed doubly linked list:");
        list.display();
    }
}
