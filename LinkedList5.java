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

    public void deleteLastOccurrence(int key) {
        if (head == null) {
            return;
        }

        Node prevToDelete = null;
        Node toDelete = null;
        Node current = head;

        while (current != null) {
            if (current.data == key) {
                prevToDelete = toDelete;
                toDelete = current;
            }
            current = current.next;
        }

        if (toDelete != null) {
            // If toDelete is the head node
            if (prevToDelete == null) {
                head = head.next;
            } else {
                prevToDelete.next = toDelete.next;
            }
        }
    }
}

public class LinkedList5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the linked list: ");
        int size = scanner.nextInt();

        LinkedList list = new LinkedList();

        System.out.println("Enter the elements:");
        for (int i = 0; i < size; i++) {
            int data = scanner.nextInt();
            list.append(data);
        }

        System.out.print("Enter the key to be deleted: ");
        int key = scanner.nextInt();

        System.out.println("Original linked list:");
        list.display();

        list.deleteLastOccurrence(key);

        System.out.println("Linked list after deleting the last occurrence of key:");
        list.display();
    }
}
