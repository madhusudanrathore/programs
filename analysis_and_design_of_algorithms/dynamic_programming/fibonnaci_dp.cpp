#include <iostream>
using namespace std;

double memo[100];

double result;

double fib( int n ){

    if( memo[n] != 0 )
        return memo[n];

    if( n == 1 || n == 2 )
        result = 1;
    else
        result = fib( n - 1 ) + fib( n - 2 );

    memo[n] = result;

    return result;
}

int main(){

    int n = 100;
    cout << fib(n);

	return 0;
}

