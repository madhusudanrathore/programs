#include <iostream.h>
#include <fstream.h>
#include<conio.h>
void main () {
  streampos begin,end;
  ifstream myfile ("sample.dat");
  begin = myfile.tellg();
  myfile.seekg (0, ios::end);
  end = myfile.tellg();
  myfile.close();
  cout << "size is: " << (end-begin) << " bytes.\n";
  getch();
}