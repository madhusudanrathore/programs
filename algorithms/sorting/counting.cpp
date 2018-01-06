#include <iostream>
#define size 1000
using namespace std;

int a[size];
int b[size];
int c[size];

void display(){
    for (long i = 0; i < size; i++)
        cout << a[i] << " ";
    cout << endl << endl;
}

void countingSort() {
    long i;

    for (i = 0; i < size; i++)
        ++c[a[i]];

    for(i = 1; i <= size ; i++)
        c[i] += c[i-1];

    for(i = size - 1; i >= 0 ; i--){
        b[c[a[i]]-1] = a[i];
        --c[a[i]];
    }

    for (i = 0; i < size; i++)
        a[i] = b[i];

}

int main(){

    for( int i = 0 ; i < size ; ++i)
        a[i] = size - i;

	display();
	countingSort();
	display();

	return 0;
}