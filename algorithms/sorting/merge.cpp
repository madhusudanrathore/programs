#include <iostream>
#define size 1000
using namespace std;

int a[size];
int t[size];

void display(){
    for (long i = 0; i < size; i++)
        cout << a[i] << " ";
    cout << endl << endl;
}

void combine(long beg, long mid, long end) {
    long i = beg, j = mid + 1, index = beg;

    while ((i <= mid) && (j <= end)) {

        if (a[i] < a[j])
            t[index++] = a[i++];
        else
            t[index++] = a[j++];
    }

    if (i > mid)
        while (j <= end)
            t[index++] = a[j++];
    else
        while (i <= mid)
            t[index++] = a[i++];

    for (long k = beg; k < index; k++)
        a[k] = t[k];
}

void mergeSort(long beg, long end) {

    if (beg < end) {
        long mid;

        mid = (beg + end) / 2;

        mergeSort(beg,mid);
        mergeSort(mid+1,end);

        combine(beg,mid,end);
    }
}

long getsize(){return size-1;}

int main(){

    for( int i = 0 ; i < size ; ++i)
        a[i] = size - i;

	display();
	mergeSort(0,getsize());
	display();

	return 0;
}