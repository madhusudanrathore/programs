#include <iostream>
#define size 1000
using namespace std;

int a[size];

void display(){
    for (long i = 0; i < size; i++)
        cout << a[i] << " ";
    cout << endl << endl;
}

void bubbleSort() {
    int temp, i, j;

    for ( i = 0; i < size; i++)
        for( j=0; j< size-i; j++)
            if (a[j] > a[j + 1]) {
                temp = a[j + 1];
                a[j + 1] = a[j];
                a[j] = temp;
            }
}

int main(){

    for( int i = 0 ; i < size ; ++i)
        a[i] = size - i;

    display();
	bubbleSort();
	display();
    
	return 0;
}