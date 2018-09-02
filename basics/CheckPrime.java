class CheckPrime{
	public static void main(String[] args) {
		int num=Integer.parseInt(args[0]), mid=num/2;
		boolean prime=true;
		
		for( int i=2; i<mid; ++i)
			if(num%i==0) {
				prime=false;
				break;
			}

		if(prime) System.out.println("YES");
		else System.out.println("NO");
	}
}