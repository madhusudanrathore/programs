#include <iostream>

using namespace std;

void linear(int arr[], int val, int n) {//Linear Search for a sorted/unsorted array list

    bool found = false;
    for (int i = 0; i < n; i++)
        if (arr[i] == val)
            found = true;

    found ? cout << val << " Found" << endl : cout << val << " Not Found" << endl;

}

int main( ) {

	int arr[] = { 12,56,78,98,236,458,497,2032,5625,9877 };
	int c, val;

    cout << "Enter value to be Searched\t";
    cin >> val;

    linear(arr, val, 9);

	return 0;
}