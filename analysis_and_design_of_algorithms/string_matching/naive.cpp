#include <iostream>
#include <string>
using namespace std;

string text;
string pattern;
int T;
int P;

int pattern_count;

void find_match( int s ){
    pattern_count = 0;
    for( int i = 0; i < P; ++i ){
        if( pattern[i] == text[i + s] )
            pattern_count++;
        else break;
    }
    if( pattern_count == P )
        cout << "FOUND AT INDEX " << s << endl;
}

void naive_string_matching() {
    int loop;

    loop = T-P;

    for ( int i = 0; i <= loop; i++)
        find_match( i );

}

int main(){

    text = "madhusudanrathore";
    pattern = "sudan";

    T = text.length();
    P = pattern.length();

    naive_string_matching();

	return 0;
}