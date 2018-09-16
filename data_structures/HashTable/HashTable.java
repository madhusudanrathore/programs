class Node{
    int data=0;
    Node prev=null, next=null;

    Node(int value){
    	this.data=value;
    }
}

class DoublyLinkedList{
	Node head, temp, pre_temp, next_temp;

	DoublyLinkedList() {
		Node new_node=new Node(100);
		this.head=new_node;
	}

	void insert_beg( int value ) {
		Node new_node=new Node(value);
		new_node.next=this.head;
		new_node.prev=null;
		this.head.prev=new_node;
		this.head=this.new_node;
	}

	void insert_end(ll &val) {

		struct node *new_node = new struct node;
		temp = head;
		while (temp->next != NULL)
			temp = temp->next;

		new_node->data = val;
		new_node->next = NULL;
		new_node->prev = temp;
		temp->next = new_node;
	}

	void delete_beg(ll &val) {

		if (head->next == NULL) {//one node
			delete head;
			head = NULL;
		}
		else {
			temp = head;
			head = head->next;
			head->prev = NULL;
			delete temp;
		}
	}

	void delete_end() {
		if (head == NULL)
			cout << "empty" << endl;
		else {//1 node only
			if (head->next == NULL) {
				delete head;
				head = NULL;
			}
			else {
				temp = head;
				while (temp->next != NULL)
					temp = temp->next;

				temp->prev->next = NULL;
				delete temp;
			}
		}
	}

	void search(ll &val, ll &key) {
		if (head == NULL)
			cout << val << " corresponds to an INDEX " << key << " which is EMPTY" << endl;
		else {
			ll count = 0;
			temp = head;
			while (temp->data != val && temp != NULL)
				temp = temp->next, count++;
			if (temp != NULL)
				cout << val << " FOUND in TABLE at INDEX " << key + 1 << " and is at POSITION number " << count + 1 << endl;
			else cout << val << " NOT FOUND" << endl;
		}
	}

	void display() {
		temp = head;
		if (head == NULL)
			cout << "Empty" << endl;
		else {
			cout << "NULL <=> ";
			while (temp != NULL) {
				cout << temp->data << " <=> ";
				temp = temp->next;
			}
			cout << " NULL" << endl;
		}
	}

};

public class HashTable{
	private size=100;
	private DoublyLinkedList hashtable;
	HashTable(){
		hashtable=new DoublyLinkedList[size]; // HASH TABLE will hold HEAD REFERENCES to DOUBLY LINKED LISTS
		
		for (ll k = 0; k < 10000; k++)
			hash_sample_insert(hashtable, size);
	}
	
	void hash_sample_insert(doubly_ll *hashtable, ll &size) {
		ll val, key;
		val = rand() % 9234;

		key = ((val%size) + (val % (size - 1))) % size;//hash function using DOUBLE HASHING
		//cout << "KEY = " << key << endl;

		if (hashtable[key].head == NULL)//empty first location of LIST
			hashtable[key].create(val);

		else//non empty first location of LIST, thus enter at beginning
			hashtable[key].insert_beg(val);
	}

	void hash_insert_beg(doubly_ll *hashtable, ll &size) {
		ll val, key;

		cout << "Enter a VALUE to be mapped in HASH TABLE" << endl;
		cin >> val;

		key = ((val%size) + (val % (size - 1))) % size;//hash function using DOUBLE HASHING
		cout << "KEY = " << key << endl;

		if (hashtable[key].head == NULL)//empty first location of LIST
			hashtable[key].create(val);

		else//non empty first location of LIST, thus enter at beginning
			hashtable[key].insert_beg(val);
	}

	void hash_insert_end(doubly_ll *hashtable, ll &size) {
		ll val, key;

		cout << "Enter a VALUE to be mapped in HASH TABLE" << endl;
		cin >> val;

		key = ((val%size) + (val % (size - 1))) % size;//hash function using DOUBLE HASHING
		cout << "KEY = " << key << endl;

		if (hashtable[key].head == NULL)//empty first location of LIST
			hashtable[key].create(val);

		else//non empty first location of LIST, thus enter at end
			hashtable[key].insert_end(val);
	}

	void hash_display(doubly_ll *hashtable, ll &size) {
		for (ll i = 0; i < size; i++) {
			cout << "HT[" << i+1 << "]\t";
			hashtable[i].display();
		}
	}

	void hash_delete_beg(doubly_ll *hashtable) {
		ll val, key;

		cout << "Enter a VALUE to be DELETED from HASH TABLE" << endl;
		cin >> val;

		key = val % 9;


		if (hashtable[key].head == NULL) {//empty location
			cout << "Empty Hash" << endl;
		}
		else {
			hashtable[key].delete_beg(key);
		}
	}

	void hash_search( doubly_ll *hashtable, ll &size ) {
		ll val, key;

		cout << "Enter a VALUE to be searched in HASH TABLE" << endl;
		cin >> val;

		key = ((val%size) + (val % (size - 1))) % size;//hash function using DOUBLE HASHING
		hashtable[key].search(val, key);
	}
	public static void main(String[] args){
		

		while(true){
			cout << "Enter Your Choice.." << endl;
			cout << "1). INSERT Entry at BEGINNING" << endl;
			cout << "2). INSERT Entry at END" << endl;
			cout << "3). Delete an Entry" << endl;
			cout << "4). Display Current Hash" << endl;
			cout << "5). SEARCH for a Value" << endl;
			cout << "6). EXIT" << endl;
			cin >> ch;

			switch (ch) {
	            case 1:
	                hash_insert_beg(hashtable, size);
	                break;
	            case 2:
	                hash_insert_end(hashtable, size);
	                break;
	            case 3:
	                hash_delete_beg(hashtable);
	                break;
	            case 4:
	                hash_display(hashtable, size);
	                break;
	            case 5:
	                hash_search(hashtable, size);
	                break;
	            case 6:
	                return 0;
	            default:
	                cout << "INVALID OPTION" << endl;
	                break;
			}
	    }
	}
}