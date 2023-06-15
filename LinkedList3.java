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

    public Node reverseKNodes(Node head, int k) {
        Node current = head;
        Node next = null;
        Node prev = null;
        int count = 0;

        // Reverse the first k nodes
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        // If there are more nodes, recursively reverse the remaining
        // part of the linked list and join it with the current head
        if (next != null) {
            head.next = reverseKNodes(next, k);
        }

        return prev;
    }
}

public class LinkedList3 {
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

        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        System.out.println("Original linked list:");
        list.display();

        list.head = list.reverseKNodes(list.head, k);

        System.out.println("Linked list after reversing every " + k + " nodes:");
        list.display();
    }
}
