/**
	given series {1,1,2,3,4,9,8,27,16,81....}
	total 30 elements
	consists of two geometric progressions
	an index supplied at command line
	print element at that index in series
	eg: 8th element in series is 27
	index between [1,30]
*/
class TCS{
	static int power(int a, int b){
		int temp=1, i;
		for ( i=0; i<b; ++i) {
			temp*=a;
		}
		return temp;
	}
	public static void main(String[] args) {
		if( args.length==0 ){
			System.out.println("NO NUMBER SUPPLIED");
			System.exit(0);
		}else{
			int num=Integer.parseInt(args[0])-1;
			int arr[] = new int[30];
			int odd=0, even=0, i;

			for ( i=0; i<30; ++i) {
				if( i%2==0 ){
					arr[i]=power(2,odd);
					++odd;
				}else{
					arr[i]=power(3,even);
					++even;
				}
			}
			System.out.println(arr[num]);
		}
	}
}