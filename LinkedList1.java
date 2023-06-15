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
}

public class LinkedList1 {
    public static LinkedList createNewList(LinkedList list1, LinkedList list2) {
        if (list1.head == null || list2.head == null) {
            return null;
        }

        LinkedList newList = new LinkedList();
        Node node1 = list1.head;
        Node node2 = list2.head;

        while (node1 != null && node2 != null) {
            if (node1.data > node2.data) {
                newList.append(node1.data);
            } else {
                newList.append(node2.data);
            }
            node1 = node1.next;
            node2 = node2.next;
        }

        return newList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the linked lists: ");
        int size = scanner.nextInt();

        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        System.out.println("Enter elements for the first linked list:");
        for (int i = 0; i < size; i++) {
            int data = scanner.nextInt();
            list1.append(data);
        }

        System.out.println("Enter elements for the second linked list:");
        for (int i = 0; i < size; i++) {
            int data = scanner.nextInt();
            list2.append(data);
        }

        LinkedList newList = createNewList(list1, list2);

        if (newList != null) {
            System.out.println("New linked list:");
            newList.display();
        } else {
            System.out.println("One or both of the linked lists are empty.");
        }
    }
}
