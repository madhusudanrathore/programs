#include <stdio.h>

#define NUM (x + y)//NO FORWARD REFERENCE PROBLEM
#define max(a,b) a>b ?a:b
#define forl() for( int i = 0; i < 1000; ++i)

struct random{
    int a;
    char *b;
};

void main(){

    long long int x = 10, y = 9;

    for( int i = 0; i < 1000; ++i)
        ++x, ++y;

    printf("%d\n",max( x, y ));



    struct random s1, *s2 = &s1;
    //s1.a = 100;
    //s1.b = "Madhusudan";
    s2->a = 100;
    s2->b = "madhusudan";

    s2->b += 3;

    printf("%d %s %d\n\n\n", ++s1.a, s1.b, sizeof(s1));


    char *p1 = "Bootstrap's JavaScript requires jQuery";
    char p2[] = "Bootstrap's JavaScript requires jQuery";

    printf("%d %d %d\n\n", sizeof(s2), sizeof(p1), sizeof(p2));

    printf("%d", NUM);

}
