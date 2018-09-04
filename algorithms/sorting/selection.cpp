#include <iostream>
#define size 1000
using namespace std;

int a[size];

void display(){
    for (long i = 0; i < size; i++)
        cout << a[i] << " ";
    cout << endl << endl;
}

void selectionSort() {
    long min, k;

    for (long i = 0; i < size - 1; i++) {

        min = 10000;
        for(long j = i; j < size; j++)
            if (a[j] < min) {
                min = a[j];
                k = j;
            }
        a[k] = a[i];
        a[i] = min;
    }

}

int main(){

    for( int i = 0 ; i < size ; ++i)
        a[i] = size - i;

	display();
	selectionSort();
	display();

	return 0;
}