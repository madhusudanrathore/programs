#include<stdio.h>

union emp
{
	char ename[20];
	int eno;
};
union dept
{
	char dname[20];
	int dno;
	union emp e1;
};

int main()
{
	union dept d;
	fflush(stdin);
	printf("\nEnter Employee Name:");
	gets(d.e1.ename);
	printf("\nEnter Employee No:");
	scanf("%d",&d.e1.eno);
	fflush(stdin);
	printf("\nEnter Department Name:");
	gets(d.dname);
	printf("\nEnter Department No:");
	scanf("%d",&d.dno);
	printf("\n\nEmployee Name:%s",d.e1.ename);
	printf("\nEmployee No:%d",d.e1.eno);
	printf("\nDepartment Name:%s",d.dname);
	printf("\nDepartment No:%d",d.dno);
}
