#include <iostream>
#include <algorithm>

using namespace std;

int main(){

    int MAX = 11;
    int n = 4;

    int val[4] = { 9, 1, 4, 8};

    //DYNAMIC PROGRAMMING SOLUTION, works well even if data is in any order
    //Set Min[i] equal to Infinity for all of i, Min[0]=0
	int *min = new int [MAX];
	min[0] = 0;
	for (int i = 1; i < MAX; ++i)
		min[i] = 65535;

    /*For i = 1 to S
		For j = 0 to N - 1
   			If (Vj<=i AND Min[i-Vj]+1<Min[i])
				Then Min[i]=Min[i-Vj]+1
	*/
	for (int i = 0; i < MAX; ++i)
		for (int j = 0; j < n; ++j)
			if( val[j] <= i && ( min[i-val[j]] + 1 < min[i] ) )
				min[i] = min[i-val[j]] + 1;


    //GREEDY SOLUTION in while loop, but not always true as for this problem set
    /*int count = 0;
    sort(val, val + n);
    while( cval < MAX ){
        for( i = 9 ; i > -1 ; --i)
            if( MAX >= ( cval + val[i] ) ){
                cval += val[i];
                ++coins;
                break;
            }
        if( i == -1 ){
            cout<<"NOT POSSIBLE";
            return 1;
        }
    }*/

    cout << min[MAX-1] << endl;

    return 0;
}
