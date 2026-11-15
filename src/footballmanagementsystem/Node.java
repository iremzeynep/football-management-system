package footballmanagementsystem;

public class Node {
    public String id;
    public String name;
    public Node next;
    public int data;
    public String info;
    public Node left;
    public Node right;
    

    public Node(String id, String name) {
        this.id = id;
        this.name = name;
        this.next = null;
        
    }
       public Node(String value) {
        this.info = value;
        this.left = null;
        this.right = null;
    }

     public Node(int d){
        data = d;
        next=null;
    }


    
}
