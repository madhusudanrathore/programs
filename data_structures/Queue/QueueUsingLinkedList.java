#include<iostream>
using namespace std;

struct node{
    int data;
    struct node *next;
};

int count = 0;
int size;

struct node *temp = NULL;
struct node *front;
struct node *rear;

class linkedQueue{
    public:

    linkedQueue(){

        front = NULL;
        rear = NULL;

        cout << "ENTER SIZE\t";
        cin >> size;
    }
    void enqueue( void ){

        if( count < size ){

            ++count;
            struct node *element = new node;

            cout << "ENTER VALUE\t";
            cin >> element->data;

            element->next = NULL;

            cout << element->data << " INSERTED" << endl;

            if( front == NULL ){//empty queue
                front = rear = element;
            }
            else{//non-empty queue
                rear->next = element;
                rear = element;
            }
        }
        else{
            cout << "OVERFLOW" << endl;
        }
    }

    void dequeue( void ){

        if( front == NULL ){
            cout << "UNDERFLOW" << endl;
        }
        else{
            temp = front;
            front = front->next;

            cout << temp->data << " DELETED" << endl;
            delete temp;
        }
    }

    void display( void ){

        if( front == NULL ){
            cout << "EMPTY QUEUE" << endl;
        }
        else{
            temp = front;
            while( temp != NULL ){
                cout << temp->data << "\t";

                temp = temp->next;
            }
            cout << endl;
        }
    }
};

int main( ){

    linkedQueue lq;
    int choice;

    while( true ){

        cout << "1). ENQUEUE" << endl;
        cout << "2). DEQUEUE" << endl;
        cout << "3). DISPLAY" << endl;
        cout << "4). EXIT" << endl;
        cout << "ENTER CHOICE\t" << endl;

        cin >> choice;

        switch( choice ){
            case 1:
                lq.enqueue();
                break;
            case 2:
                lq.dequeue();
                break;
            case 3:
                lq.display();
                break;
            case 4:
                return 0;
            default:
                cout << "ERROR CHOICE" << endl;
        }
    }

    return 0;
}

