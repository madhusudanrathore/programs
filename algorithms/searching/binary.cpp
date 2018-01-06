#include <iostream>

using namespace std;

void binary(int arr[], int val, int size) { //Binary Search for a sorted array list
    int beg = 0, end = size, mid = (beg + end) / 2;
    bool found = false;

    while (beg <= end) {
        mid = (beg + end) / 2;
        if (arr[mid] == val) {
            found = true;
            break;
        }
        else if (arr[mid] < val)
            beg = mid + 1;
        else  if (arr[mid] > val)
            end = mid - 1;
    }

    ( !found ) ? cout << val << " Not Found" << endl : cout << val << " Found" << endl ;

}

int main( ) {

	int arr[] = { 12,56,78,98,236,458,497,2032,5625,9877 };
	int val;

    cout << "Enter value to be Searched\t";
    cin >> val;

    binary(arr, val, 9);

	return 0;
}
