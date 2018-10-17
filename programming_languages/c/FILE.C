 #include<stdio.h>
 #include<conio.h>
 void main()
 {
	FILE *f1;
	char x;
	f1=fopen("abc.txt","w");
	printf("Enter the Data : ");
	while((x=getchar())!='0')
	{
		putc(x,f1);
	}
	fclose(f1);
	f1=fopen("abc.txt","r");
	while((x=getc(f1))!=EOF)
	{
		printf("%c",x);
	}
	fclose(f1);
 }