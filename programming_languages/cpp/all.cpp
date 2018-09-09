#include <iostream>
#include <vector>
#include <algorithm>

#define forl( n ) for( long long int i = 0; i < n; ++i)

using namespace std;

int main () {

    cout << "Value of __LINE__ : " << __LINE__ << endl;
    cout << "Value of __FILE__ : " << __FILE__ << endl;
    cout << "Value of __DATE__ : " << __DATE__ << endl;
    cout << "Value of __TIME__ : " << __TIME__ << endl;

    vector<int> v;
    vector<int>::iterator it;

    forl(100)
        v.push_back(100-i);

    sort( v.begin(), v.end() );

    for (it = v.begin(); it != v.end(); it++)
        cout << *it << " ";

    cout << endl;

   return 0;
}