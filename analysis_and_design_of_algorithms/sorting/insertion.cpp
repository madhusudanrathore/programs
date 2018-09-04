#include <iostream>
#define size 1000
using namespace std;

int a[size];

void display(){
    for (long i = 0; i < size; i++)
        cout << a[i] << " ";
    cout << endl << endl;
}

void insertionSort() {
    int val, i, j;

    for (j = 1; j < size; j++) {

        val = a[j];
        i = j - 1;
        while (i > -1 && a[i] > val) {
            a[i + 1] = a[i];
            i = i - 1;
        }
        a[i + 1] = val;

    }

}

int main(){

    for( int i = 0 ; i < size ; ++i)
        a[i] = size - i;

	display();
	insertionSort();
	display();

	return 0;
}