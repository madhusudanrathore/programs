#include<stdio.h>
#include<conio.h>

void main()
{
	FILE *ptr;
	int i,no;
	float bal;
	char ch,name[30],filename[10];
	clrscr();
	printf("Enter The File Name:-");
	gets(filename);
	ptr=fopen(filename,"w");
	printf("\nEnter Data:\n");

	for(i=0;i<3;i++)
	{
		fflush(stdin);
		printf("\nEnter A/C No:");
		scanf("%d",&no);
		printf("\nEnter Name:");
		scanf("%s",name);
		printf("\nEnter Balanace:");
		scanf("%f",&bal);
		fprintf(ptr,"%4d%10s%6.2f",no,name,bal);
	}
	fclose(ptr);
	ptr=fopen(filename,"r");
	puts("\n\n\tNumber\t\tName\t\tBalanace");
	while(!feof(ptr))
	{

		fflush(stdin);
		fscanf(ptr,"%d %s %f",&no,name,&bal);
		printf("\n\t%4d\t\t%10s\t\t%6.2f\n",no,name,bal);
	}
	fclose(ptr);
	getch();
}