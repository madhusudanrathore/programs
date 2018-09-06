class StackUsingArray{
	protected int top, stack_size=5, value, arr[];

	StackUsingArray(){
		this.top=-1;
		this.arr=new int [this.stack_size];
	}
	void push(int value){
		if( this.top==this.stack_size-1 ){
			System.out.println("PUSH OPERATION:\tOVERFLOW");
		}else{
			System.out.println( "PUSH OPERATION:\t" + value + " INSERTED" );
			this.arr[++this.top]=value;
		}
	}
	void pop(){
		if( this.top>-1 ){
			System.out.println( "POP OPERATION:\t" + this.arr[this.top--] + " DELETED" );
		}else{
			System.out.println( "POP OPERATION:\tUNDERFLOW");
		}
	}
	void display(){
		if( this.top>-1 ){
			System.out.print("PRINTING STACK:\t");
			for (int i = this.top; i > -1; --i)
				System.out.print( this.arr[i] + " " );
			System.out.println();
		}
		else{
			System.out.println("EMPTY STACK");
		}

	}
	public static void main(String[] args) {
		StackUsingArray stack=new StackUsingArray();

		for(int i=0; i<stack.stack_size+3; ++i)
			stack.push(i);
		
		stack.display();

		for(int i=0; i<stack.stack_size+3; ++i)
			stack.pop();

		stack.display();
	}
}