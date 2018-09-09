#include<iostream.h>
#include<conio.h>

template<class T>
class mypair
{
	T a,b;
	public:
		mypair(T first, T second)
		{
			a=first;
			b=second;
		}
		T getmax()
		{
			T retval;
			retval=(a>b)?a:b;
			return retval;
		}
};
void main()
{
	clrscr();
	mypair<int> myobject(100,175);
	cout<<"\n\n\t"<<myobject.getmax();
	getch();
}