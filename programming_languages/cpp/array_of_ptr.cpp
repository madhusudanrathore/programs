#include<iostream>
#include<string>

using namespace std;

void arrayofptrs() {
	int **p;
	p = new int*[3];
	for (int j = 0; j < 3; j++) {
		p[j] = new int[2];
		for (int i = 0; i < 2; i++)
			p[j][i] = i + j;
	}
	for (int j = 0; j < 3; j++) {
		for (int i = 0; i < 2; i++)
			cout << p[j][i] << "\t";
		cout << endl;
	}
}

int main() {
	arrayofptrs();
	return 0;
}