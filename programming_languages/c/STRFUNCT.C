#include<stdio.h>
#include<string.h>

int main()
{
	char str1[20],str2[20],str3[20];
	int l1,l2,x;
	printf("\nEnter String 1:");
	gets(str1);
	printf("\nEnter String 3:");
	gets(str3);
	l1=strlen(str1);
	printf("\nStr1 = %s",str1);
	printf("\nLength Of Str1 = %d",l1);
	strcpy(str2,str1);
	printf("\nStr2 = %s",str2);
	x=strcmp(str1,str2);
	if(x==0)
	{
		printf("\n\nStr1 & Str2 Are Same");
	}
	else
	{
		printf("\n\nStr1 & Str2 Are Different");
	}
	strcat(str1,str3);
	printf("\n\nAfter Concatnat Str 1 = %s",str1);
	strrev(str2);
	printf("\n\nAfter Reverse Str2 = %s",str2);
}