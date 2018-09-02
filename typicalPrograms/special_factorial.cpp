#include<iostream>
#include<string>
using namespace std;

void specialfact() {
	int n, a[1000], w1 = 0, temp;
	char w[1600];

	cout << "Enter number\t";
	cin >> n;
	if (n == 0 || n == 1)
		cout << "1" << endl;
	else {
		a[0] = 1;
		for (int i = 1; i < n; i++)
			a[i] = 0;
		for (int j = 0; j < n; j++){
			while (a[j] > 0){
				temp = a[j] % 10;
				for (int k = j + 1; k < n; k++){
					a[k] = (k + 1)*temp + a[k];
					temp = a[k] % 10;
				}
				w[w1++] = a[n - 1] % 10 + 48;
				for (int l = j; l < n; l++)
					a[l] = a[l] / 10;
			}
		}
		for (int m = w1 - 1; m >= 0; m--)
			cout << w[m];
		cout << endl;
	}
}

int main() {
	specialfact();
	return 0;
}