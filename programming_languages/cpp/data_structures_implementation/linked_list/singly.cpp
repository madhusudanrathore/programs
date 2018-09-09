#include<iostream>
using namespace std;

struct singly_node {
	int data;
	struct singly_node * next;
};

struct singly_node * head;
struct singly_node * temp;
struct singly_node * pre_temp;

class singly_ll {
    public:
        singly_ll() { head = NULL; }

        void create() {
            if (head == NULL) {
                struct singly_node * new_node = new struct singly_node;
                head = new_node;
                new_node->next = NULL;
                cout << "Enter Data\t";
                cin >> new_node->data;
                cout << "Node Created" << endl;
            }
            else
                cout << "LIST Already Created" << endl;
        }

        void insert_beg() {
            if (head == NULL){
                cout << "LIST EMPTY, Create LIST FIRST" << endl;
            }
            else {
                struct singly_node *new_node = new struct singly_node;
                new_node->next = head;
                head = new_node;
                cout << "Enter Data\t";
                cin >> new_node->data;
                cout << "Node Created" << endl;
            }
        }

        void delete_beg(){
            if (head == NULL)
                cout << "EMPTY LIST" << endl;
            else {
                temp = head;
                cout << temp->data << " DELETED from LIST" << endl;
                head = head->next;
                delete temp;
            }
        }

        void insert_end() {
            if (head == NULL) {
                cout << "LIST EMPTY, Create LIST FIRST" << endl;
            }
            else {
                struct singly_node *new_node = new struct singly_node;
                new_node->next = NULL;
                temp = head;

                while (temp->next != NULL)
                    temp = temp->next;

                temp->next = new_node;

                cout << "Enter Data\t";
                cin >> new_node->data;
                cout << "Node Created" << endl;
            }
        }

        void delete_end() {
            if (head == NULL)
                cout << "EMPTY LIST" << endl;
            else {
                pre_temp = head;
                temp = head;
                if (head->next == NULL) {//1 element only
                    cout << head->data << " DELETED from LIST" << endl;
                    delete temp;
                }
                else {//more than 1 element
                    temp = temp->next;
                    while (temp->next != NULL) {
                        pre_temp = temp;
                        temp = temp->next;
                    }
                    cout << temp->data << " DELETED from LIST" << endl;
                    pre_temp->next = NULL;
                    delete temp;
                }
            }
        }

        void insert_before() {
            int val;
            if (head == NULL) {
                cout << "LIST EMPTY\t Create LIST FIRST" << endl;
            }
            else {
                struct singly_node *new_node = new struct singly_node;
                pre_temp = head;
                temp = head;

                cout << "Insert VALUE BEFORE which NODE is to be INSERTED\t";
                cin >> val;

                if (temp->data == val && temp->next==NULL) {//if only 1 element and found
                    new_node->next = temp;
                    head = new_node;

                    cout << "Enter Data\t";
                    cin >> new_node->data;
                    cout << "Node Created" << endl;
                }
                else if (temp->data != val && temp->next == NULL)//if only 1 element and not found
                    cout << "Not found" << endl;
                else {//if more than 1 element
                    temp = temp->next;
                    while (temp != NULL) {
                        if (temp->data != val) {
                            temp = temp->next;
                            pre_temp = pre_temp->next;
                        }
                        else
                            break;
                    }

                    if (temp != NULL) {
                        new_node->next = pre_temp->next;
                        pre_temp->next = new_node;

                        cout << "Enter Data\t";
                        cin >> new_node->data;
                        cout << "Node Created" << endl;
                    }
                    else
                        cout << "Not FOUND" << endl;
                }
            }
        }

        void delete_before() {
            struct singly_node * pre_temp2;
            if (head == NULL)
                cout << "EMPTY LIST" << endl;
            else if (head->next == NULL)//1 node only present
                cout << "only ONE NODE Present" << endl;
            else {//more than 1 nodes present
                pre_temp = head;
                temp = head->next;

                int val;
                cout << "Insert NODE VALUE whose PRECEEDING NODE is to be DELETED\t";
                cin >> val;

                if( temp->data == val){//node to be deleted is before 2nd node, 1st node to be deleted
                    cout << pre_temp->data << " DELETED" << endl;
                    head = temp;
                    delete pre_temp;
                }else if( pre_temp->data == val){//NODE to be DELETED is BEFORE 1st NODE, i.e. it doesn't exist
                    cout << "NO NODE BEFORE 1st NODE" << endl;
                }
                else{//other node to be deleted
                    temp = temp->next;
                    while( temp->next != NULL && temp->data !=val ){
                        pre_temp = pre_temp->next;
                        temp = temp->next;
                    }
                    if( temp->data == val){//value found
                        pre_temp2 = pre_temp->next;
                        pre_temp->next = temp;
                        cout << pre_temp2->data << " DELETED" << endl;
                        delete pre_temp2;
                    }
                    else{//value not found
                        cout << val << " NOT FOUND" << endl;
                    }
                }
            }

        }

        void insert_after(){
            int val;

            if (head == NULL) {
                cout << "LIST EMPTY\t Create LIST FIRST" << endl;
            }
            else {
                temp = head;

                cout << "Insert VALUE AFTER which NODE is to be INSERTED\t";
                cin >> val;

                while (temp != NULL) {
                    if (temp->data != val)
                        temp = temp->next;
                    else
                        break;
                }
                if (temp!=NULL) {
                    struct singly_node *new_node = new struct singly_node;
                    new_node->next = temp->next;
                    temp->next = new_node;

                    cout << "Enter Data\t";
                    cin >> new_node->data;
                    cout << "Node Created" << endl;
                }
                else
                    cout << "VALUE NOT FOUND" << endl;
            }
        }

        void delete_after() {
            if (head == NULL)
                cout << "LIST EMPTY" << endl;
            else if (head->next == NULL)
                cout << "Only ONE Node Present" << endl;
            else {
                int val;
                cout << "Enter NODE VALUE whose SUCCEDDING NODE is to be DELETED" << endl;
                cin >> val;
                temp = head;

                while (temp->next != NULL && temp->data != val) {
                    temp = temp->next;
                }

                if (temp->next != NULL && temp->data == val) {
                    pre_temp = temp->next;
                    temp->next = pre_temp->next;
                    cout << pre_temp->data << " DELETED" << endl;
                    delete pre_temp;
                }
                else if (temp->next == NULL && temp->data == val){
                    cout << "Last NODE" << endl;
                }
                else{
                    cout << val << " NOT FOUND" << endl;
                }
            }
        }

        void delete_specific() {
            if (head == NULL)
                cout << "LIST EMPTY" << endl;

            else {
                int val;
                cout << "Enter Value to be DELETED" << endl;
                cin >> val;

                if (head->next == NULL && head->data==val) {
                    temp = head;
                    cout << temp->data << " Deleted" << endl;
                    delete temp;
                    head = NULL;
                }
                else {
                    temp = head->next;
                    pre_temp = head;
                    while (temp != NULL) {
                        if (temp->data != val) {
                            temp = temp->next;
                            pre_temp = pre_temp->next;
                        }
                        else break;
                    }
                    if (temp == NULL)
                        cout << val << " Not Found" << endl;
                    else {
                        pre_temp->next = temp->next;
                        cout << temp->data << " Deleted" << endl;
                        delete temp;
                    }
                }

            }
        }

        void display() {
            temp = head;

            if (head == NULL)cout << "List Empty" << endl;
            else {
                while (temp != NULL) {
                    cout << temp->data;
                    if (temp->next != NULL)
                        cout << " -> ";
                    else cout << " -> NULL" << endl;

                    temp = temp->next;
                }
            }
        }

        ~singly_ll() { cout << "SINGLY LINKED LIST DESTROYED" << endl; }
};

void singly() {
	int ch;
	char r;
	singly_ll node;
	bool repeat=true;

	do {
		cout << "Enter your CHOICE" << endl;
		cout << "1). CREATE" << endl;
		cout << "2). INSERT AT BEGINNING" << endl;
		cout << "3). INSERT AT END" << endl;
		cout << "4). INSERT BEFORE SPECIFIC VALUE" << endl;
		cout << "5). INSERT AFTER SPECIFIC VALUE" << endl;
		cout << "6). DELETE AT BEGINNING" << endl;
		cout << "7). DELETE AT END" << endl;
		cout << "8). DELETE BEFORE SPECIFIC VALUE" << endl;
		cout << "9). DELETE AFTER SPECIFIC VALUE" << endl;
		cout << "10). DELETE SPECIFIC VALUE" << endl;
		cout << "11). Display" << endl;
		cout << "12).EXIT" << endl;

		cin >> ch;

        switch (ch) {
            case 1:
                node.create();
                break;
            case 2:
                node.insert_beg();
                break;
            case 3:
                node.insert_end();
                break;
            case 4:
                node.insert_before();
                break;
            case 5:
                node.insert_after();
                break;
            case 6:
                node.delete_beg();
                break;
            case 7:
                node.delete_end();
                break;
            case 8:
                node.delete_before();
                break;
            case 9:
                node.delete_after();
                break;
            case 10:
                node.delete_specific();
                break;
            case 11:
                node.display();
                break;
            case 12:
                return;
            default:
                cout << "INVALID CHOICE" << endl;
        }
    }while(true);

	node.~singly_ll();
}

int main(){

    singly();
    return 0;
}
