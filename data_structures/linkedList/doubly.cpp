#include<iostream>
using namespace std;

struct node {
    int data;
    struct node *prev;
    struct node *next;
};

struct node *head;
struct node *temp;
struct node *pre_temp;
struct node *next_temp;

class doubly_ll {
    public:
        doubly_ll() { head = NULL; }

        void create() {
            if (head == NULL) {
                struct node *new_node = new struct node;
                head = new_node;
                new_node->next = new_node->prev = NULL;
                cout << "enter data" << endl;
                cin >> new_node->data;
            }
            else
                cout << "DOUBLY LIST already created" << endl;
        }

        void insert_beg() {
            if (head == NULL)
                cout << "Empty, Create first" << endl;
            else {
                struct node *new_node = new struct node;
                new_node->next = head;
                new_node->prev = NULL;
                head->prev = new_node;
                head = new_node;
                cout << "enter data" << endl;
                cin >> new_node->data;
            }
            }

        void insert_end() {
            if (head == NULL)
                cout << "Empty, Create first" << endl;
            else {
                struct node *new_node = new struct node;
                temp = head;
                while (temp->next != NULL)
                    temp = temp->next;

                new_node->next = NULL;
                new_node->prev = temp;
                temp->next = new_node;

                cout << "enter data" << endl;
                cin >> new_node->data;
            }
        }

        void delete_beg() {
            if (head == NULL)
                cout << "empty" << endl;
            else if(head->next == NULL) {//one node
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
            else if(head->next == NULL) {//1 node only
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

        void insert_before(){
            if (head == NULL)//empty
                cout << "Empty, Create first" << endl;
            else {//not empty
                struct node *new_node = new struct node;
                int val;
                temp = head;
                cout << "Enter Value Before which DATA is to be added\t";
                cin >> val;
                if (temp->data == val)//to be added before first element
                    this->insert_beg();
                else {//
                    while (temp->data != val && temp->next != NULL) {
                        temp = temp->next;
                    }
                    if (temp->data == val) {//node found
                        cout << "Enter Data to be Added\t";
                        cin >> new_node->data;
                        new_node->next = temp;
                        new_node->prev = temp->prev;
                        temp->prev->next = new_node;
                        temp->prev = new_node;
                    }
                    else if(temp->data != val){//node not found
                        cout << val << " Not Found" << endl;
                    }
                }
            }
        }

        void insert_after(){
            if (head == NULL)//empty list
                cout << "Empty, Create first" << endl;
            else {//more than 1 element
                struct node *new_node = new struct node;
                int val;
                temp = head;
                cout << "Enter Value After which DATA is to be added\t";
                cin >> val;

                while (temp->data != val && temp->next != NULL) {
                    temp = temp->next;
                }
                if (temp->next == NULL && temp->data == val )
                    this->insert_end();

                else if (temp->data == val) {
                    cout << "Enter Data to be Added\t";
                    cin >> new_node->data;

                    new_node->next = temp->next;
                    new_node->prev = temp;
                    temp->next->prev = new_node;
                    temp->next = new_node;
                }
                else{
                    cout << val << " Not Found" << endl;
                }
            }
        }

        void delete_before(){
            if (head == NULL)//empty list
                cout << "Empty, Create first" << endl;
            else {//list not empty
                int val;
                temp = head;
                cout << "Enter Value Before which DATA is to be DELETED\t";
                cin >> val;

                if (temp->data == val)//first node
                    cout << "NO NODE before First Element" << endl;
                else if (temp->next->data == val)//delete first node
                    this->delete_beg();
                else {//find node
                    while (temp->data != val && temp->next != NULL) {
                        temp = temp->next;
                    }
                    if (temp->data == val) {//found
                        pre_temp = temp->prev;
                        pre_temp->prev->next = temp;
                        temp->prev = pre_temp->prev;

                        delete pre_temp;
                    }
                    else{
                        cout << val << " Not Found" << endl;
                    }

                }
            }
        }

        void delete_after() {
            if (head == NULL)
                cout << "Empty, Create first" << endl;
            else {
                int val;
                temp = head;
                cout << "Enter NODE Value AFTER which DATA is to be DELETED\t";
                cin >> val;
                while (temp->next != NULL && temp->data != val) {
                    temp = temp->next;
                }
                if (temp->next == NULL && temp->data == val)//last node
                    cout << "Last Element, Cannot Delete" << endl;
                else if (temp->data != val) {
                    cout << val << " Not Found" << endl;
                }
                else{
                    next_temp = temp->next;
                    temp->next = next_temp->next;
                    next_temp->next->prev = temp;
                }
            }
        }

        void delete_specific() {
            if (head == NULL)
                cout << "empty" << endl;
            else {
                int val;
                cout << "Enter Value to be Deleted\t";
                cin >> val;
                temp = head;

                if (temp->data == val)//first node is to be deleted then use DELETE at BEGINNING
                    delete_beg();

                else {// find node
                    while (temp != NULL) {
                        if(temp->data!=val)
                            temp = temp->next;
                        else break;
                    }
                    if (temp != NULL) {
                        temp->prev->next = temp->next;
                        temp->next->prev = temp->prev;
                        delete temp;
                        cout << val << " Deleted" << endl;
                    }
                    else cout << val << " Not Found" << endl;
                }
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

        ~doubly_ll() {
            while (head != NULL) {
                temp = head;
                head = head->next;
                delete temp;
            }
            cout << "Doubly Linked List DELETED" << endl;
        }
};

void doubly() {
    int ch;
    char r;
    doubly_ll node;
    bool repeat = true;

    while(true) {
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
    }

    node.~doubly_ll();
}

int main(){

    doubly();
    return 0;
}
