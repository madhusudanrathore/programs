#include<stdio.h>

struct emp
{
	char ename[20];
	int eno;
};
struct dept
{
	char dname[20];
	int dno;
	struct emp e1;
};

int main()
{
	struct dept d;
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
