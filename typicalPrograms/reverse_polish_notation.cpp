#include<iostream>
#include<string>
#define max 400

using namespace std;

void revpolishnot() {
	string arr;
	char st[max];
	int top = -1;
	int i = 0, j = 0, k = 0;
	cin >> arr;

	st[++top] = '(';
	st[arr.length() + 1] = ')';

	while (i <= arr.length() && top != -1) {

		if (arr[i] == '(') st[++top] = arr[i++];
		else if (arr[i] == ')') {
			while (st[top] != '(')
				cout << st[top--];
			--top, ++i;
		}
		else if (arr[i] == '/' || arr[i] == '*' || arr[i] == '^' || arr[i] == '+' || arr[i] == '-') st[++top] = arr[i++];
		else cout << arr[i++];
	}
}

int main() {
	revpolishnot();
	return 0;
}