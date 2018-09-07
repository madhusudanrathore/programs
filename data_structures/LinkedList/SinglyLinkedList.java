class SinglyNode{
    int data=0;
    SinglyNode next=null;

    SinglyNode(int value){
    	this.data=value;
    }
}

class SinglyLinkedList{
    SinglyNode head=null, temp=null, pre_temp=null;

    SinglyLinkedList(){
    	SinglyNode new_node=new SinglyNode(100);
    	this.head=new_node;
    }

    void insert_beg(int value){
    	SinglyNode new_node=new SinglyNode(value);
    	new_node.next=head;
		this.head=new_node;
		System.out.println( "INSERT BEGINNING: " + value );
	}

    void insert_end(int value){
		SinglyNode new_node=new SinglyNode(value);
		this.temp=this.head;

		while(this.temp.next!=null)
		    this.temp=this.temp.next;

		this.temp.next=new_node;
		System.out.println( "INSERT END: " + value );
    }

    void insert_before(int value){
        SinglyNode new_node = new SinglyNode(value);
        this.pre_temp=this.head;
        this.temp=this.head;

        if(this.temp.data==value){//if element found at head
            new_node.next=this.temp;
            this.head=new_node;

            new_node.data=value;
            System.out.println( "INSERT BEFORE " + value + " ,INSERTED " + new_node.next.data );
        }
        else if(this.temp.data!=value && this.temp.next==null) //if only 1 element and not found
            System.out.println( "INSERT BEFORE " + value + ", NOT FOUND" );
        else{ //if more than 1 element
            this.temp=this.temp.next;
            while(this.temp!=null){
                if(this.temp.data!=value){
                    this.temp=this.temp.next;
                    this.pre_temp=this.pre_temp.next;
                }else break;
            }
            if(this.temp!=null){
                new_node.next =this.temp;
                this.pre_temp.next=new_node;
                System.out.println( "INSERT BEFORE " + value + " ,INSERTED " + new_node.next.data );
            }else System.out.println( "INSERT BEFORE " + value + ", NOT FOUND" );
        }
    }

    void insert_after(int value){
        this.temp=this.head;

        while(this.temp!=null){
            if(this.temp.data!=value)
                this.temp=this.temp.next;
            else break;
        }
        if(this.temp!=null){
            SinglyNode new_node = new SinglyNode(value);
            new_node.next=this.temp.next;
            this.temp.next=new_node;
            System.out.println( "INSERT AFTER " + value + ", INSERTED " + this.temp.data );
        }else System.out.println( "INSERT AFTER " + value + ", NOT FOUND" );
    }

    void delete_beg(){
        if(this.head==null){
            System.out.println( "DELETE BEGINNING, EMPTY" );
        }else{
            this.temp=this.head;
            System.out.println( "DELETE BEGINNING: " + this.temp.data + " DELETED" );
            this.head=this.head.next;
            this.temp=null;
            System.gc();
        }
    }

    void delete_end(){
        if(this.head==null){
            System.out.println( "DELETE END, EMPTY" );
        }else{
            this.pre_temp=this.head;
            this.temp=this.head;
            if(this.head.next==null){ //1 element only
                System.out.println( "DELETE END: " + this.head.data + " DELETED" );
                this.temp=null;
                this.head=null;
            }
            else{ //more than 1 element
                this.temp=this.temp.next;
                while(this.temp.next!=null){
                    this.pre_temp=this.temp;
                    this.temp=this.temp.next;
                }
                System.out.println( "DELETE END " + this.temp.data + " DELETED" );
                this.pre_temp.next=null;
                this.temp=null;
            }
            System.gc();
        }
    }

    void delete_specific(int value){
        if(this.head.data==value){ // first element to be deleted
            this.temp=this.head;
            this.head=this.temp.next;
            System.out.println( "DELETE SPECIFIC, " + this.head.data + " DELETED" );
            this.temp=null;
            System.gc();
        }
        else{
            this.temp=this.head.next;
            this.pre_temp=this.head;
            while(this.temp!=null){
                if(this.temp.data!=value){
                    this.temp=this.temp.next;
                    this.pre_temp=this.pre_temp.next;
                }
                else break;
            }
            if(this.temp==null)
                System.out.println( "DELETE SPECIFIC, " + value + " NOT FOUND" );
            else{
                this.pre_temp.next=this.temp.next;
                System.out.println( "DELETE SPECIFIC, " + value + " DELETED" );
                this.temp=null;
                System.gc();
            }
        }
    }

    void delete_before(int value){
        SinglyNode pre_temp2=null;
        if(this.head.next==null)//1 node only present
            System.out.println( "DELETE BEFORE " + value + ",ONE NODE Present" );
        else {//more than 1 nodes present
            pre_temp=this.head;
            this.temp=this.head.next;

            if( pre_temp.data==value){//node to be DELETED is BEFORE 1st node, i.e. it doesn't exist
                System.out.println( "DELETE BEFORE " + value + ", IS 1st NODE" );
            }else if(this.temp.data==value){//node to be deleted is before 2nd node, 1st node to be deleted
                System.out.println( "DELETE BEFORE " + value + ", " + pre_temp.data + ", DELETED" );
                this.head = this.temp;
                pre_temp=null;
            }
            else{//other node to be deleted
                this.temp=this.temp.next;
                while(this.temp.next!=null && this.temp.data!=value ){
                    pre_temp=pre_temp.next;
                    this.temp=this.temp.next;
                }
                if(this.temp.data==value){//value found
                    pre_temp2=pre_temp.next;
                    pre_temp.next=this.temp;
                    System.out.println( "DELETE BEFORE " + value + ", " + pre_temp2.data + ", DELETED" );
                    pre_temp2=null;
                }
                else{//value not found
                    System.out.println( " NOT FOUND" );
                }
            }
            System.gc();
        }
    }

    void delete_after(int value){
        if(this.head.next==null && this.head.data==value){
            System.out.println( "DELETE AFTER " + value + ", ONLY ONE NODE" );
        }else{
            this.temp=this.head;

            while(this.temp.next!=null && this.temp.data!=value)
                this.temp=this.temp.next;

            if(this.temp.next!=null && this.temp.data==value){
                this.pre_temp=this.temp.next;
                this.temp.next=this.pre_temp.next;
                System.out.println( "DELETE AFTER " + value + ", " +this.pre_temp.data + " DELETED" );
                this.pre_temp=null;
                System.gc();
            }
            else if(this.temp.next==null && this.temp.data==value) System.out.println( "DELETE AFTER " + value + ", IS LAST NODE" );
            else System.out.println( value + " NOT FOUND" );
        }
    }

    void display(){
        this.temp=this.head;

        while(this.temp!=null){
            System.out.print(this.temp.data);
            if(this.temp.next!=null)
                System.out.print( " -> " );
            else
                System.out.println( " -> NULL" );

            this.temp=this.temp.next;
        }
    }

    public static void main(String[] args){
    	SinglyLinkedList linked_list=new SinglyLinkedList();

    	for(int i=0; i<5; ++i){
    		linked_list.insert_beg(i+1);
            linked_list.insert_end(i+6);

            linked_list.insert_before(i+1);
            linked_list.insert_after(i+6);
    	}
        linked_list.display();

        for(int i=0; i<5; ++i){
            linked_list.delete_before(i+1);
            linked_list.delete_after(i+6);
        }
        linked_list.display();

        for(int i=0; i<5; ++i){
            linked_list.delete_beg();
            linked_list.delete_end();
        }
        linked_list.display();

        linked_list.delete_specific(100);
        linked_list.display();
    }
}