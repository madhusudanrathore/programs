#include<iostream>
#include<string>

using namespace std;

void specialfact() {
	int n, a[100], i, j, w1 = 0, temp;
	char w[160];

	cin >> n;
	if (n == 0 || n == 1)
		cout << "1" << endl;
	else {
		a[0] = 1;
		for (i = 1; i < n; i++)
			a[i] = 0;
		for (j = 0; j < n; j++){
			while (a[j] > 0){
				temp = a[j] % 10;
				for (i = j + 1; i < n; i++){
					a[i] = (i + 1)*temp + a[i];
					temp = a[i] % 10;
				}
				w[w1++] = a[n - 1] % 10 + 48;
				for (i = j; i < n; i++)
					a[i] = a[i] / 10;
			}
		}
		for (i = w1 - 1; i >= 0; i--)
			cout << w[i];
		cout << endl;

	}
}

int main() {

	specialfact();
	
	return 0;
}
