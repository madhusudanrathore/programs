#include <iostream>
using namespace std;

class queue{

	int size, value, *a;
	int front, rear;

	public:
		queue( ){
			front = rear = -1;
			cout << "ENTER SIZE\t";
			cin >> size;

			a = new int [size];
		}
		void enqueue( void ){
			if( rear == size -1 ){
                cout << "OVERFLOW" << endl;
                return;
			}

			cout << "ENTER VALUE\t";
            cin >> value;
			if( front == -1 && rear == -1 ){
                front = rear = 0;
			}else{
                ++rear;
			}
            a[rear] = value;

		}
		void dequeue( void ){
            if( front == -1 || front > rear ){
                cout << "UNDERFLOW" << endl;
            }
            else{
                cout << a[front] << " DELETED" << endl;
                ++front;
            }
		}
		void display( void ){
            if( front <= rear ){
                for( int i = front; i <= rear; ++i)
                    cout << "a[" << i + 1 << "] = " << a[i] << endl;
            }
            else{
                cout << "EMPTY" << endl;
            }

		}
};

int main() {

	queue q;

	int choice;

	while( true ){

		cout << "1). ENQUEUE" << endl;
		cout << "2). DEQUEUE" << endl;
		cout << "3). DISPLAY" << endl;
		cout << "4). EXIT" << endl;
		cout << "ENTER CHOICE\t";
		cin >> choice;

		switch( choice ){
			case 1:
				q.enqueue();
				break;
			case 2:
				q.dequeue();
				break;
			case 3:
				q.display();
				break;
            case 4:
                return 0;
			default:
				cout << "ERROR CHOICE" << endl;
		}
	}

	return 0;
}

