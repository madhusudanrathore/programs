class Node{
    int data=0;
    Node next=null;

    Node(int value){
        this.data=value;
    }
}

class QueueUsingLinkedList{
    protected Node front, rear, temp;
    protected int queue_size=5;

    QueueUsingLinkedList(){
        this.front=this.rear=null;
    }
    void enqueue(int value){
        Node new_node=new Node(value);

        if( this.front==null && this.rear==null ){
            this.front=this.rear=new_node;
        }else{
            this.rear.next=new_node;
            this.rear=new_node;
        }
        System.out.println( "ENQUEUE OPERATION:\t" + value + " INSERTED" );
    }
    void dequeue(){
        if( this.front==null ){
            System.out.println( "DEQUEUE OPERATION:\tUNDERFLOW");
        }else{
            this.temp=this.front;
            this.front=this.front.next;
            System.out.println( "DEQUEUE OPERATION:\t" + this.temp.data + " DELETED" );
            this.temp=null;
            System.gc();
        }
    }
    void display(){
        if( this.front==null ){
            System.out.println("EMPTY QUEUE");
        }
        else{
            System.out.print("PRINTING QUEUE:\t");
            this.temp=this.front;
            while(this.temp!=null){
                System.out.print( this.temp.data + " " );
                this.temp=this.temp.next;
            }

            System.out.println();
        }
    }
    public static void main(String[] args) {
        QueueUsingLinkedList queue=new QueueUsingLinkedList();

        for(int i=0; i<queue.queue_size; ++i)
            queue.enqueue(i+1);
        
        queue.display();

        for(int i=0; i<queue.queue_size; ++i)
            queue.dequeue();

        queue.display();
    }
}