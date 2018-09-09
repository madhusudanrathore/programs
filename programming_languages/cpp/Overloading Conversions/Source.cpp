#include"Header.h"
using namespace std;

int main() {
	dist d(5, 11.456);
	d.show();

	float j = 99.089;
	d = j;//basic to class
	d.show();

	dist f(29, 7.456);
	j = f;//class to basic
	cout << j << endl;

	//class hr12 to class hr24
	hr12 t12(11, 59, 0);
	hr24 t24;

	t24 = t12;

	t12.show();
	t24.show();

	system("pause");
	return 0;
}
