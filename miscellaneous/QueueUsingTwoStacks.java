class Node{
    Node next;
    int data;
}
class Stack{
    private Node head;
    private Node temp;
    private int size;
    Stack(){
        head = null;
        size = 0;
    }
    boolean isEmpty(){
        return ( head == null );
    }
    void push( int i ){
        ++size;
        Node new_node = new Node();
        new_node.data = i;
        if( this.isEmpty() )
            new_node.next = null;
        else    new_node.next = head;

        head = new_node;
    }
    int pop(){
        if ( this.isEmpty() )
            return -1;
        else {
            --size;
            this.temp = this.head;
            this.head = this.head.next;
            return this.temp.data;
        }
    }
    int size(){ return this.size; }
    void print(){
        temp = head;
        while( temp != null ){
            System.out.print( temp.data + " ");
            temp = temp.next;
        }
        System.out.println("\n");
    }
}
class Queue{
    private Stack stack1;
    private Stack stack2;
    public Queue() {
        stack1 = new Stack();
        stack2 = new Stack();
    }
    private void moveStack1ToStack2() {
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
    }
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
    public int size() {
        return stack1.size() + stack2.size();     
    }
    public void enqueue(int item) {
        stack1.push(item);
    }
    public int dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Underflow");
        if (stack2.isEmpty()) moveStack1ToStack2();
        return stack2.pop();
    }
    public void disp(){
        if (isEmpty()) throw new NoSuchElementException("Underflow");
        if (stack2.isEmpty()) moveStack1ToStack2();
        stack2.print();
    }
}
public class QueueUsingTwoStacks{
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(2);
        q.enqueue(56);
        q.enqueue(67);
        q.enqueue(24);
        q.enqueue(5);
        q.disp();
        q.dequeue();
        q.disp();
    }
}