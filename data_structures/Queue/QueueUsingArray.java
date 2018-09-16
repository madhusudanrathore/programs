class QueueUsingArray{
	protected int front, rear, queue_size=5, arr[];

	QueueUsingArray(){
		this.front=this.rear=-1;
		this.arr=new int [this.queue_size];
	}
	void enqueue(int value){
		if( this.rear==this.queue_size-1 ){
			System.out.println("ENQUEUE OPERATION:\tOVERFLOW");
			return;
		}else if( this.front==-1 && this.rear==-1 ){
			this.front=this.rear=0;
		}else{
			++this.rear;
		}
		System.out.println( "ENQUEUE OPERATION:\t" + value + " INSERTED" );
		this.arr[this.rear]=value;
	}
	void dequeue(){
		if( this.front==-1 || this.front>this.rear ){
			System.out.println( "DEQUEUE OPERATION:\tUNDERFLOW");
		}else{
			System.out.println( "DEQUEUE OPERATION:\t" + this.arr[this.front++] + " DELETED" );
		}
	}
	void display(){
		if( this.front>this.rear ){
			System.out.println("EMPTY QUEUE");
		}
		else{
			System.out.print("PRINTING QUEUE:\t");

			for (int i=this.front; i<=this.rear; ++i)
				System.out.print( this.arr[i] + " " );

			System.out.println();
		}
	}
	public static void main(String[] args) {
		QueueUsingArray queue=new QueueUsingArray();

		for(int i=0; i<queue.queue_size+3; ++i)
			queue.enqueue(i+1);
		
		queue.display();

		for(int i=0; i<queue.queue_size+3; ++i)
			queue.dequeue();

		queue.display();
	}
}