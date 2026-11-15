package footballmanagementsystem;

public class LinkedList {
    public Node head;
    public int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return (this.head == null);
    }

    public void addNode(Node newNode) {
        Node current = this.head;
        if (current == null) {
            this.head = newNode;
            this.size++;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            this.size++;
        }
    }

    public void deleteNode(String key) {
        Node current = this.head;
        Node previous = null;

        if (current != null && current.id.equals(key)) {
            this.head = current.next;
            this.size--;
            return;
        }

        while (current != null && !current.id.equals(key)) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node with id " + key + " not found.");
            return;
        }

        previous.next = current.next;
        this.size--;
    }

    public void printList() {
        Node currNode = this.head;
        System.out.println("LinkedList: ");
        while (currNode != null) {
            System.out.print(" {id: " + currNode.id + "   " + currNode.name + "}  --->");
            currNode = currNode.next;
        }
        System.out.println("");
    }

   
}
