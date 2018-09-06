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

    // void delete_before(int value){
    //     struct singly_node * pre_temp2;
    //     if (head == NULL)
    //         cout << "EMPTY LIST" << endl;
    //     else if (head->next == NULL)//1 node only present
    //         cout << "only ONE NODE Present" << endl;
    //     else {//more than 1 nodes present
    //         pre_temp = head;
    //         temp = head->next;

    //         int val;
    //         cout << "Insert NODE VALUE whose PRECEEDING NODE is to be DELETED\t";
    //         cin >> val;

    //         if( temp->data == val){//node to be deleted is before 2nd node, 1st node to be deleted
    //             cout << pre_temp->data << " DELETED" << endl;
    //             head = temp;
    //             delete pre_temp;
    //         }else if( pre_temp->data == val){//NODE to be DELETED is BEFORE 1st NODE, i.e. it doesn't exist
    //             cout << "NO NODE BEFORE 1st NODE" << endl;
    //         }
    //         else{//other node to be deleted
    //             temp = temp->next;
    //             while( temp->next != NULL && temp->data !=val ){
    //                 pre_temp = pre_temp->next;
    //                 temp = temp->next;
    //             }
    //             if( temp->data == val){//value found
    //                 pre_temp2 = pre_temp->next;
    //                 pre_temp->next = temp;
    //                 cout << pre_temp2->data << " DELETED" << endl;
    //                 delete pre_temp2;
    //             }
    //             else{//value not found
    //                 cout << val << " NOT FOUND" << endl;
    //             }
    //         }
    //     }

    // }

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
            // linked_list.delete_before(i+1);
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