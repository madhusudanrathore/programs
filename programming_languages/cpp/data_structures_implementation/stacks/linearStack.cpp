#include <iostream>

using namespace std;

class stack{

	int top, size, value, *a;

	public:
		stack( ){
			top = -1;
			cout << "ENTER SIZE\t";
			cin >> size;

			a = new int [size];
		}
		void push( ){
			if( top < size - 1  ){
				cout << "ENTER NEW ELEMENT\t";
				cin >> value;

				a[++top] = value;

				cout << "INSERTED" << endl;
			}else{
				cout << "OVERFLOW" << endl ;
			}
		}
		void pop( ){
			if( top > -1 ){
				cout << a[top] << "\tDELETED" << endl;
				--top;
			}else{
				cout << "UNDERFLOW" << endl ;
			}
		}
		void display( ){

			if( top > -1){
				for (int i = top; i > -1; --i)
					cout << "stack[" << i+1 << "] = " << a[i] << endl;
			}
			else{
				cout << "EMPTY" << endl;
			}

		}
};


int main() {

	stack st;

	int choice;
	bool again = true;

	while( again ){
		
		cout << "1). PUSH" << endl;
		cout << "2). POP" << endl;
		cout << "3). DISPLAY" << endl;
		cout << "4). EXIT" << endl;
		cout << "ENTER CHOICE\t";
		cin >> choice;

		switch( choice ){
			case 1:
				st.push();
				break;
			case 2:
				st.pop();
				break;
			case 3:
				st.display();
				break;
			case 4:
				again = false;
				break;
			default:
				cout << "ERROR CHOICE" << endl;
		}
	}

	return 0;
}
