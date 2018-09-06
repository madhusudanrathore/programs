class BinaryToDecimal{
	static int convert( String bin ){
		int len=bin.length();
		int result=0;
		char ch;

		for ( int i=len-1, j=0; i>-1; --i, ++j) {
			ch=bin.charAt(i);
			if( ch=='1' ){
				result += java.lang.Math.pow(2,j);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// Integer num=Integer.parseInt(args[0]);
		String bin=args[0];
		System.out.println( convert(bin) );
	}
}