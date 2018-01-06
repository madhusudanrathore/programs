#include<iostream>
#include<string>

using namespace std;

void reverse_string() {
	string str = "madhu";
	int len = str.length();
	int lenm = (len--) / 2;

	for (int i = 0; i < lenm; i++) {
		str[i] = str[i] + str[len - i];
		str[len - i] = str[i] - str[len - i];
		str[i] = str[i] - str[len - i];
	}
	cout << str;
}

int main() {
	
	reverse_string();

	return 0;
}
