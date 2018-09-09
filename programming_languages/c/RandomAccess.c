#include<stdio.h>
#include<conio.h>

void main ()
{
	FILE *fp;
   	int len;
	clrscr();
	fp = fopen("test.txt", "r");
	if( fp == NULL ) 
   	{
      		printf("Error Opening File");
      		exit(1);
   	}
   	fseek(fp, 0, SEEK_END);
	len = ftell(fp);
   	fclose(fp);
	printf("Total size of file.txt = %d bytes\n", len);
  	getch();
}