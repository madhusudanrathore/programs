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

        if (this.head==null){
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
                this.temp = this.temp.next;

            new_node.next=null;
            new_node.prev=this.temp;
            this.temp.next=new_node;

            System.out.println( "INSERT END:\t" + value );
        }
    }
    void insert_before(){
        if (this.head == null)//empty
            System.out.println << "Empty, Create first" << endl;
        else {//not empty
            struct node *new_node = new struct node;
            int val;
            this.temp = this.head;
            System.out.println << "Enter Value Before which DATA is to be added\t";
            cin >> val;
            if (this.temp.data == val)//to be added before first element
                this.insert_beg();
            else {//
                while (this.temp.data != val && this.temp.next != null) {
                    this.temp = this.temp.next;
                }
                if (this.temp.data == val) {//node found
                    System.out.println << "Enter Data to be Added\t";
                    cin >> new_node.data;
                    new_node.next = this.temp;
                    new_node.prev = this.temp.prev;
                    this.temp.prev.next = new_node;
                    this.temp.prev = new_node;
                }
                else if(this.temp.data != val){//node not found
                    System.out.println << val << " Not Found" << endl;
                }
            }
        }
    }
    void delete_beg(){
        if(this.head==null){ // empty list
            System.out.println( "EMPTY LIST" );
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
            System.out.println( "EMPTY LIST" );
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
    void display() {
        this.temp=this.head;
        if (this.head==null){
            System.out.println( "EMPTY" );
        }else{
            System.out.print( "PRINTING LIST:\tNULL <=> " );
            
            while (this.temp!=null) {
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

            // linked_list.insert_before(i+1);
            // linked_list.insert_after(i+6);
        }
        linked_list.display();

        // for(int i=0; i<5; ++i){
        //     linked_list.delete_before(i+1);
        //     linked_list.delete_after(i+6);
        // }
        // linked_list.display();

        // for(int i=0; i<5; ++i){
        //     linked_list.delete_beg();
        //     linked_list.delete_end();
        // }
        // linked_list.display();

        // linked_list.delete_specific(100);
        // linked_list.display();
    }
}

        // void insert_after(){
        //     if (this.head == null)//empty list
        //         System.out.println << "Empty, Create first" << endl;
        //     else {//more than 1 element
        //         struct node *new_node = new struct node;
        //         int val;
        //         this.temp = this.head;
        //         System.out.println << "Enter Value After which DATA is to be added\t";
        //         cin >> val;

        //         while (this.temp.data != val && this.temp.next != null) {
        //             this.temp = this.temp.next;
        //         }
        //         if (this.temp.next == null && this.temp.data == val )
        //             this.insert_end();

        //         else if (this.temp.data == val) {
        //             System.out.println << "Enter Data to be Added\t";
        //             cin >> new_node.data;

        //             new_node.next = this.temp.next;
        //             new_node.prev = this.temp;
        //             this.temp.next.prev = new_node;
        //             this.temp.next = new_node;
        //         }
        //         else{
        //             System.out.println << val << " Not Found" << endl;
        //         }
        //     }
        // }

        // void delete_before(){
        //     if (this.head == null)//empty list
        //         System.out.println << "Empty, Create first" << endl;
        //     else {//list not empty
        //         int val;
        //         this.temp = this.head;
        //         System.out.println << "Enter Value Before which DATA is to be DELETED\t";
        //         cin >> val;

        //         if (this.temp.data == val)//first node
        //             System.out.println << "NO NODE before First Element" << endl;
        //         else if (this.temp.next.data == val)//delete first node
        //             this.delete_beg();
        //         else {//find node
        //             while (this.temp.data != val && this.temp.next != null) {
        //                 this.temp = this.temp.next;
        //             }
        //             if (this.temp.data == val) {//found
        //                 pre_this.temp = this.temp.prev;
        //                 pre_this.temp.prev.next = this.temp;
        //                 this.temp.prev = pre_this.temp.prev;

        //                 delete pre_this.temp;
        //             }
        //             else{
        //                 System.out.println << val << " Not Found" << endl;
        //             }

        //         }
        //     }
        // }

        // void delete_after() {
        //     if (this.head == null)
        //         System.out.println << "Empty, Create first" << endl;
        //     else {
        //         int val;
        //         this.temp = this.head;
        //         System.out.println << "Enter NODE Value AFTER which DATA is to be DELETED\t";
        //         cin >> val;
        //         while (this.temp.next != null && this.temp.data != val) {
        //             this.temp = this.temp.next;
        //         }
        //         if (this.temp.next == null && this.temp.data == val)//last node
        //             System.out.println << "Last Element, Cannot Delete" << endl;
        //         else if (this.temp.data != val) {
        //             System.out.println << val << " Not Found" << endl;
        //         }
        //         else{
        //             next_this.temp = this.temp.next;
        //             this.temp.next = next_this.temp.next;
        //             next_this.temp.next.prev = this.temp;
        //         }
        //     }
        // }

        // void delete_specific() {
        //     if (this.head == null)
        //         System.out.println << "empty" << endl;
        //     else {
        //         int val;
        //         System.out.println << "Enter Value to be Deleted\t";
        //         cin >> val;
        //         this.temp = this.head;

        //         if (this.temp.data == val)//first node is to be deleted then use DELETE at BEGINNING
        //             delete_beg();

        //         else {// find node
        //             while (this.temp != null) {
        //                 if(this.temp.data!=val)
        //                     this.temp = this.temp.next;
        //                 else break;
        //             }
        //             if (this.temp != null) {
        //                 this.temp.prev.next = this.temp.next;
        //                 this.temp.next.prev = this.temp.prev;
        //                 delete this.temp;
        //                 System.out.println << val << " Deleted" << endl;
        //             }
        //             else System.out.println << val << " Not Found" << endl;
        //         }
        //     }
        // }