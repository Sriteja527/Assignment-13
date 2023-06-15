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

    public Node reverseAlternateKNodes(Node head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }

        Node current = head;
        Node prev = null;
        Node next = null;

        // Reverse first k nodes
        int count = 0;
        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        // Skip next k nodes
        count = 0;
        while (current != null && count < k - 1) {
            current = current.next;
            count++;
        }

        // Recursively reverse the remaining linked list starting from the next k node
        if (current != null) {
            current.next = reverseAlternateKNodes(current.next, k);
        }

        // Set the new head after reversing
        head.next = prev;

        return head;
    }
}

public class LinkedList4 {
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

        list.head = list.reverseAlternateKNodes(list.head, k);

        System.out.println("Linked list after reversing every alternate " + k + " nodes:");
        list.display();
    }
}
