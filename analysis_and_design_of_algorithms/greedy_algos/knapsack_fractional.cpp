#include <iostream>
using namespace std;

class node{
    public:
        int value;
        int weight;
        int index;
        float density;
        node(){ index = value = weight = density = 0; }
        void getval( int i ){
            cin >> value >> weight;
            index = i + 1 ;
            density = (value / weight) ;
        }
        void print(){
            cout << index << "\t" << value << "\t" << weight << "\t" << density << endl;
        }
        float getdensity(){ return density; }
        bool operator < ( node n2 ){
        	if (density < n2.density)
        		return true;
        	else return false;
        }
};
void swapnode( node &n1, node &n2){
    node temp;
    temp = n2;
    n2 = n1;
    n1 = temp;
}
void nodesort( node *a, int &n){
    for ( int i = 0; i < n; i++)
        for( int j=0; j< n-i; j++)
            if (a[j] < a[j + 1])
                swapnode( a[j], a[j + 1] );
}
int main() {
    int MAX, n;
    int fw = 0, fv = 0;

    cin >> MAX >> n;
    node *a = new node[n];

    for( int i = 0 ; i < n ; ++i){
        a[i].getval( i );
        a[i].print();
    }

    nodesort(a, n);

    int c = 0;
    while( MAX > fw + a[c].weight ){
        fw += a[c].weight;
        fv += a[c].value;
        ++c;
    }

    int req = MAX - fw;
    fw += req;
    fv += a[c].getdensity() * req;

    cout << "Number\tVALUE\tWEIGHT\tDENSITY\n";
    for( int i = 0 ; i < n ; ++i)
        a[i].print();

    cout << "TOTAL FINAL WEIGHT " << fw << endl;
    cout << "TOTAL FINAL VALUE " << fv << endl;

    return 0;
}
