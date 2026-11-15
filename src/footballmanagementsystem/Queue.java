package footballmanagementsystem;

import java.util.LinkedList;

public class Queue<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void enqueue(T data) {
        list.addLast(data);
    }

    public T dequeue() {
        if (list.isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        } else {
            return list.removeFirst();
        }
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void printQueue() {
        for (T item : list) {
            System.out.print(item.toString() + " -> ");
        }
        System.out.println("null");
    }
    
    @Override
    public String toString() {
        if (list.isEmpty()) {
            return "No scheduled matches.";
        }
        StringBuilder sb = new StringBuilder();
        for (T item : list) {
            sb.append(item.toString()).append("\n");
        }
        return sb.toString().trim();
    }
}

