class CheckPalindrome{
	static boolean check(String str){
		int len=str.length();
		int mid=len/2, count=0;
		char c1,c2;

		for( int i=0; i<=mid; ++i){
			c1=str.charAt(i);
			c2=str.charAt(len-i-1);
			if( c1==c2 ){
				count++;
			}else
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String str=args[0];
		System.out.println( check(str)? "YES": "NO" );
	}
}