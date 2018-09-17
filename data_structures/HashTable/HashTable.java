import java.util.Random;

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

    void display(){
        this.temp=this.head;
        if(this.head==null){
            System.out.println( "DISPLAY:\tEMPTY LIST" );
        }else{
            System.out.print( "PRINTING LIST:\tnull <=> " );
            
            while(this.temp!=null){
                System.out.print( this.temp.data + " <=> " );
                this.temp=this.temp.next;
            }
            
            System.out.println( " null" );
        }
    }
}

public class HashTable{
	protected int size=100;
	protected DoublyLinkedList hashtable;
	
	HashTable(){
		// HASH TABLE wiint hold HEAD REFERENCES to DOUBLY LINKED LISTS
		this.hashtable=new DoublyLinkedList[size];
		
		for (int k=0; k < 10000; k++)
			this.hash_sample_insert();
	}
	
	void hash_sample_insert() {
		Random rand = new Random();
		int val, key;
		
		val=rand.nextInt(9235); // between 0 to 9234

		key=((val%size) + (val % (size - 1))) % size;//hash function using DOUBLE HASHING

		// if(hashtable[key].head==null){ // empty first location of LIST
		// 	hashtable[key].create(val);
		// }else{ // non empty first location of LIST, thus enter at beginning
		// 	hashtable[key].insert_beg(val);
		// }
		hashtable[key].insert_beg(val);
	}

	// void hash_insert_beg() {
	// 	int val, key;

	// 	System.out.println( "Enter a VALUE to be mapped in HASH TABLE" << endl;
	// 	cin >> val;

	// 	key=((val%size) + (val % (size - 1))) % size;//hash function using DOUBLE HASHING
	// 	System.out.println( "KEY=" << key << endl;

	// 	if (hashtable[key].head==null)//empty first location of LIST
	// 		hashtable[key].create(val);

	// 	else//non empty first location of LIST, thus enter at beginning
	// 		hashtable[key].insert_beg(val);
	// }

	// void hash_insert_end() {
	// 	int val, key;

	// 	System.out.println( "Enter a VALUE to be mapped in HASH TABLE" << endl;
	// 	cin >> val;

	// 	key=((val%size) + (val % (size - 1))) % size;//hash function using DOUBLE HASHING
	// 	System.out.println( "KEY=" << key << endl;

	// 	if (hashtable[key].head==null)//empty first location of LIST
	// 		hashtable[key].create(val);

	// 	else//non empty first location of LIST, thus enter at end
	// 		hashtable[key].insert_end(val);
	// }

	// void hash_delete_beg() {
	// 	int val, key;

	// 	System.out.println( "Enter a VALUE to be DELETED from HASH TABLE" << endl;
	// 	cin >> val;

	// 	key=val % 9;


	// 	if (hashtable[key].head==null) {//empty location
	// 		System.out.println( "Empty Hash" << endl;
	// 	}
	// 	else {
	// 		hashtable[key].delete_beg(key);
	// 	}
	// }

	// void hash_search() {
	// 	int val, key;

	// 	System.out.println( "Enter a VALUE to be searched in HASH TABLE" << endl;
	// 	cin >> val;

	// 	key=((val%size) + (val % (size - 1))) % size;//hash function using DOUBLE HASHING
	// 	hashtable[key].search(val, key);
	// }

	void hash_display() {
		for (int i=0; i < size; i++) {
			System.out.println( "HT[" + (i+1) + "]\t" );
			hashtable[i].display();
		}
	}

	public static void main(String[] args){

		HashTable table=new HashTable();

		// hash_insert_beg();
		// hash_insert_end();
		// hash_delete_beg();
		hash_display();
		// hash_search();
	}
}