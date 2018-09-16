class Node{
    int data=0;
    Node next=null;

    Node(int value){
        this.data=value;
    }
}

class StackUsingLinkedList{
    protected Node top, temp;
    protected int stack_size=5;

    StackUsingLinkedList(){
        this.top=null;
    }
    void push(int value){
        Node new_node=new Node(value);
        System.out.println( "PUSH OPERATION:\t" + value + " INSERTED" );

        if( this.top==null ){
            this.top=new_node;
        }else{
            new_node.next=this.top;
            this.top=new_node;
        }
    }
    void pop(){
        if( this.top==null ){
            System.out.println( "POP OPERATION:\tUNDERFLOW");
        }else{
            this.temp=this.top;
            this.top=this.temp.next;
            System.out.println( "POP OPERATION:\t" + this.temp.data + " DELETED" );
            this.temp=null;
            System.gc();
        }
    }
    void display(){
        if( this.top==null ){
            System.out.println("PRINTING STACK:\tEMPTY STACK");
        }
        else{
            this.temp=this.top;
            System.out.print("PRINTING STACK:\t");
            while( this.temp!=null ){
                System.out.print( this.temp.data + " " );
                this.temp=this.temp.next;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        StackUsingLinkedList stack=new StackUsingLinkedList();

        for(int i=0; i<stack.stack_size; ++i)
            stack.push(i+1);
        
        stack.display();

        for(int i=0; i<stack.stack_size; ++i)
            stack.pop();

        stack.display();
    }
}