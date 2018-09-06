/**
	Convert Infix Notation to Postfix Notation
	a+b*c is converted to ab*+

	Command line Input will use escape characters
	eg: (a+b*c) won't work, change it to \(a+b*c\)
*/
class InfixToPostfix{
	public static void main(String[] args) {
		if( args.length==0 ){
			System.out.println( "NO STRING SUPPLIED" );
			return;
		}else{
			char []char_str=args[0].toCharArray(), stack=new char[400];
			
			int top = -1, len=args[0].length(), i = 0, j = 0, k = 0;

			stack[++top] = '(';
			stack[len+1] = ')';

			while( i<len && top!=-1 ){

				if( char_str[i] == '(' )
					stack[++top] = char_str[i++];
				else if( char_str[i]==')' ){
					while( stack[top] != '(' )
						System.out.print( stack[top--] );
					
					--top;
					++i;
				}
				else if(char_str[i] == '/' || char_str[i] == '*' || char_str[i] == '^' )
					stack[++top] = char_str[i++];
				else if(char_str[i] == '+' || char_str[i] == '-')
					stack[++top] = char_str[i++];
				else
					System.out.print(  char_str[i++] );
			}
			System.out.println();
		}
	}
}