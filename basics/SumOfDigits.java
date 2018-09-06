class SumOfDigits{
	public static void main(String[] args) {
		String str=args[0];
		int len=str.length();
		int result=0;
		char temp;

		for( int i=0; i<len; ++i){
			temp=str.charAt(i);
			result+=Character.getNumericValue(temp);
		}
		System.out.println(result);
	}
}