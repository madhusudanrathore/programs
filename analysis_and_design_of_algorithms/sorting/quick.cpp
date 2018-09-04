#include <iostream>
#define size 1000
using namespace std;

int a[size];

void display(){
    for (long i = 0; i < size; i++)
        cout << a[i] << " ";
    cout << endl << endl;
}

void swapa(int l, int m) {
    int t;
    t = a[l];
    a[l] = a[m];
    a[m] = t;
}

int partition(int beg, int e) {
    int temp = a[e];
    int i = beg-1;

    for( int j=beg; j<e; j++){
        if(  a[j] <= temp ){
            ++i;
            swapa(i, j);
        }
    }
    swapa(i+1, e);
    return i+1;
}

void quickSort(int h, int l) {
    if (h < l) {
        int q = partition(h, l);
        quickSort(h, q - 1);
        quickSort(q + 1, l);
    }
}

int returnsize(){ return size - 1; }

int main(){

    for( int i = 0 ; i < size ; ++i)
        a[i] = size - i;

	display();
	quickSort(0, returnsize());
	display();

	return 0;
}