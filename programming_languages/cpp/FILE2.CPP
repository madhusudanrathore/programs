#include <iostream.h> // library that contain basic input/output functions
#include <fstream.h>  // library that contains file input/output functions
#include<conio.h>

void main()
{

	int array_size = 1000; //size of array
	char * array = new char[array_size]; //array to store file contents
	int position = 0; //keep track of array position where new character from file will be stored
	clrscr();

	ifstream fin("sample.dat",ifstream::binary); // opening file in binary mode
	/*checking whether file could be opened or not. If file does not exist or don't have read permissions, file
	stream could not be opened.*/
	if(fin)
	{
		fin.seekg(0, ios::end); //seeking to the end of the file
		int length = fin.tellg(); //Getting the length of file or positon of enf of file
		fin.seekg(0,ios::beg); //seeking to the start of the file
		//prompting user to enter position, to start reading data from, in the file
		cout << "Please enter the position from where you want to read data :(0-" << length << "):";
		int seek_position;
		cin >> seek_position;

		if(seek_position >= 0 && seek_position <= length) // checking user entered position lie within file
		{
			fin.seekg(seek_position,ios::beg); //seeking to the user specified position from begining of the file
			//Reading file from seek_position to end of file into array
			while(!fin.eof())
			{
				fin.get(array[position]);
				position++;
			}
			array[position-1] = '\0';
			//displaying the data stored in the array
			for(int i = 0; array[i] != '\0'; i++)
			{
				cout << "\t"<<array[i];
			}
		}
		else //position entered by user in not with in the file range
		{
			cout << "Invalid Seek Position." << endl;
		}

	}
	else //file could not be opened
	{
		cout << "File could not be opened." << endl;
	}

	getch();
}