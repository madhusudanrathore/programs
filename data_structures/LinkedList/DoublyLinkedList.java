class DoublyNode{
    int data=0;
    DoublyNode prev=null, next=null;

    DoublyNode(int value){
        this.data=value;
    }
}

class DoublyLinkedList{
    DoublyNode head, temp;

    DoublyLinkedList(){
        DoublyNode new_node=new DoublyNode(100);
        this.head=new_node;
    }

    void insert_beg(int value){
        DoublyNode new_node=new DoublyNode(value);

        if(this.head==null){
            this.head=new_node;
        }else{
            new_node.next=this.head;
            this.head.prev=new_node;
            this.head=new_node;
        }
        System.out.println( "INSERT BEGINNING:\t" + value );
    }
    
    void insert_end(int value){
        DoublyNode new_node=new DoublyNode(value);

        if(this.head==null){
            this.head=new_node;
        }else{
            this.temp=this.head;
            
            while(this.temp.next!=null)
                this.temp=this.temp.next;

            new_node.prev=this.temp;
            this.temp.next=new_node;

            System.out.println( "INSERT END:\t" + value );
        }
    }
    
    void insert_before(int before_value, int value){
        if(this.head==null){ // empty
            System.out.println( "INSERT BEFORE:\tEMPTY LIST" );
        }else if(this.head.data==before_value){ // to be added before first element
            this.insert_beg(value);
        }else{ // search and insert
            this.temp=this.head;

            while(this.temp.data!=before_value && this.temp.next!=null){ // untill node found or null
                this.temp=this.temp.next;
            }
            if(this.temp.data==before_value){ // node found
                DoublyNode new_node=new DoublyNode(value);
                new_node.next=this.temp;
                new_node.prev=this.temp.prev;
                this.temp.prev.next=new_node;
                this.temp.prev=new_node;
                System.out.println( "INSERT BEFORE:\t" + value + " INSERTED" );
            }else if(this.temp.data!=before_value){ // node not found
                System.out.println( "INSERT BEFORE:\t" + before_value + " NOT FOUND" );
            }
        }
    }
    
    // void insert_after(int after_value, int value){
    //     if(this.head==null){ // empty list
    //         System.out.println( "INSERT AFTER:\tEMPTY LIST" );
    //     }else if(this.head.next==null && this.temp.data==after_value){ // after first element
    //             this.insert_end(value);
    //     }else{ // search and insert
    //         this.temp=this.head;

    //         while(this.temp.data!=after_value && this.temp.next!=null){ // untill node found or null
    //             this.temp=this.temp.next;
    //         }

    //         if(this.temp.data==after_value){ // node found
    //             DoublyNode new_node=new DoublyNode(value);
    //             new_node.next=this.temp.next;
    //             new_node.prev=this.temp;
    //             this.temp.next.prev=new_node;
    //             this.temp.next=new_node;
    //             System.out.println( "INSERT AFTER:\t" + value + " INSERTED" );
    //         }else if(this.temp.data!=after_value){ // node not found
    //             System.out.print( "INSERT AFTER:\t" + after_value + " NOT FOUND" );
    //         }
    //     }
    // }
    
    void delete_beg(){
        if(this.head==null){ // empty list
            System.out.println( "DELETE BEGINNING:\tEMPTY LIST" );
        }else{
            this.temp=this.head;
            this.head=this.head.next;
            this.head.prev=null;
            this.temp=null;
            System.gc();
        }
    }
    
    void delete_end(){
        if(this.head==null){ // empty list
            System.out.println( "DELETE END:\tEMPTY LIST" );
        }
        else{
            this.temp=this.head;

            while(this.temp.next!=null)
                this.temp=this.temp.next;

            this.temp.prev.next=null;
            this.temp=null;
            System.gc();
        }
    }

    void delete_specific( int value ){
        if(this.head==null){
            System.out.println( "DELETE SPECIFIC:\tEMPTY LIST" );
        }else if(this.head.data==value){ // first node is to be deleted
            this.head=null;
            System.gc();
        }else{ // find node
            this.temp=this.head;

            while(this.temp!=null){
                if(this.temp.data!=value)
                    this.temp=this.temp.next;
                // else break;
            }
            if(this.temp!=null){
                this.temp.prev.next=this.temp.next;
                this.temp.next.prev=this.temp.prev;
                this.temp=null;
                System.out.println( "DELETE SPECIFIC:\t" + value + " DELETED" );
            }else System.out.println( "DELETE SPECIFIC:\t" + value + " NOT FOUND" );
            System.gc();
        }
    }

    // void delete_before(){
    //     if(this.head==null){ // empty list
    //         System.out.print( "Empty, Create first" );
    //     }else{ // list not empty
    //         this.temp=this.head;

    //         if(this.temp.data==value)//first node
    //             System.out.print( "NO NODE before First Element" );
    //         else if(this.temp.next.data==value)//delete first node
    //             this.delete_beg();
    //         else{//find node
    //             while(this.temp.data!=value && this.temp.next!=null){
    //                 this.temp=this.temp.next;
    //             }
    //             if(this.temp.data==value){//found
    //                 pre_this.temp=this.temp.prev;
    //                 pre_this.temp.prev.next=this.temp;
    //                 this.temp.prev=pre_this.temp.prev;

    //                 delete pre_this.temp;
    //             }
    //             else{
    //                 System.out.print( value + " Not Found" );
    //             }

    //         }
    //     }
    // }

    // void delete_after(){
    //     if(this.head==null)
    //         System.out.print( "Empty, Create first" );
    //     else{
    //         int value;
    //         this.temp=this.head;
    //         System.out.print( "Enter NODE value AFTER which DATA is to be DELETED\t" );
    //         cin >> value;
    //         while(this.temp.next!=null && this.temp.data!=value){
    //             this.temp=this.temp.next;
    //         }
    //         if(this.temp.next==null && this.temp.data==value)//last node
    //             System.out.print( "Last Element, Cannot Delete" );
    //         else if(this.temp.data!=value){
    //             System.out.print( value + " Not Found" );
    //         }
    //         else{
    //             next_this.temp=this.temp.next;
    //             this.temp.next=next_this.temp.next;
    //             next_this.temp.next.prev=this.temp;
    //         }
    //     }
    // }

    void display(){
        this.temp=this.head;
        if(this.head==null){
            System.out.println( "DISPLAY:\tEMPTY LIST" );
        }else{
            System.out.print( "PRINTING LIST:\tNULL <=> " );
            
            while(this.temp!=null){
                System.out.print( this.temp.data + " <=> " );
                this.temp=this.temp.next;
            }
            
            System.out.println( " NULL" );
        }
    }
    
    public static void main(String[] args){
        DoublyLinkedList linked_list=new DoublyLinkedList();

        for(int i=0; i<5; ++i){
            linked_list.insert_beg(i+1);
            linked_list.insert_end(i+6);

            // linked_list.insert_before(i+1, (i+1)*1000);
            // linked_list.insert_after(i+6, (i+6)*1000);
        }
        linked_list.display();

        // for(int i=0; i<5; ++i){
        //     linked_list.delete_before(i+1);
        //     linked_list.delete_after(i+6);
        // }
        // linked_list.display();

        for(int i=0; i<5; ++i){
            linked_list.delete_beg();
            linked_list.delete_end();
        }
        linked_list.display();

        linked_list.delete_specific(100);
        linked_list.display();
    }
}