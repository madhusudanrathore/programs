#include <iostream>
#define size 1000
using namespace std;

int heap_size = size;
int a[size];

void display(){
    for (long i = 0; i < size; i++)
        cout << a[i] << " ";
    cout << endl << endl;
}

int left(int i){ return 2*i + 1; }

int right(int i){ return 2*i + 2; }

void swap(int i, int j){
    int k;
    k = a[j];
    a[j] = a[i];
    a[i] = k;
}

void max_heapify(int i){
    int l = left(i);
    int r = right(i);
    int largest;

    if( l<heap_size && a[l]>a[i] )
        largest = l;
    else largest = i;

    if( r<heap_size && a[r]>a[largest] )
        largest = r;

    if(largest!=i){
        swap(largest,i);
        max_heapify(largest);
    }
}

void build_heap(){

    for(int i = (size/2); i>0; --i)
        max_heapify(i);

}

void heapSort(){
    build_heap();

    for (int i = size - 1; i > 0; --i){
        swap(0,i);
        --heap_size;
        max_heapify(0);
    }
}

int main(){

    for( int i = 0 ; i < size ; ++i)
        a[i] = size - i;

	display();
	heapSort();
	display();

	return 0;
}