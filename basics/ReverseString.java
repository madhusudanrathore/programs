class ReverseString{
	static void reverse( char[] str, int len ){
		int mid=len/2;
		char temp;

		for ( int i=0; i<mid; ++i ){
			temp=str[i];
			str[i]=str[len-i-1];
			str[len-i-1]=str[i];
		}

		System.out.println(str);
		System.out.println("%0.2f",9.8888);
	}
	public static void main(String[] args) {
		// StringBuilder str = new StringBuilder(args[0]);
		char[] temparray = args[0].toCharArray();
		reverse(temparray, args[0].length());
	}
}