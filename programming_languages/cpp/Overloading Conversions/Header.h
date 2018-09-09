#if!defined HEADER
#define HEADER

#include<iostream>
#include<stdlib.h>
using namespace std;

class dist {
	int feet;
	float inches;
	public:
		dist() :feet(0), inches(0) {}
		dist(int i, float j) :feet(i), inches(j) {}
		dist(float i) {
			feet = i / 12;
			inches = i - 12 * feet;
		}
		operator float() {
			float i = 0;
			i = feet * 12;
			i += inches;
			return i;
		}

	void show() { cout << feet << "\n" << inches << endl; }
};
class hr24 {
	int hrs;
	int mins;
public:
	hr24() : hrs(10), mins(10) { }
	hr24(int i, int j) : hrs(i), mins(j) { }
	/*hr24(hr12 obj) {
	hrs = obj.gethrs();
	mins = obj.getmins();
	if (obj.getmer() == 0)
	hrs += 12;
	}*/
	void show() { cout << hrs << "\t" << mins << "\tHRS." << endl; }

};

class hr12 {
	int hrs;
	int mins;
	bool mer;
	public:
		hr12() :hrs(10), mins(10), mer(true) { }
		hr12(int i, int j, bool k) :hrs(i), mins(j), mer(k) { }
		void show() { (mer == 1) ? cout << hrs << "\t" << mins << "\tA.M." << endl : cout << hrs << "\t" << mins << "\tP.M." << endl; }
		int gethrs() { return hrs; }
		int getmins() { return mins; }
		int getmer() { return mer; }
		operator hr24() {
			int hours = hrs;
			int minutes = mins;
			(mer == 1) ? hours += 0 : hours += 12;
			return hr24(hours, minutes);
		}
};

#endif