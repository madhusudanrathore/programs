public class Prac{
	public static void main(String[] args) {
		String input = "abccdeaed";
		String pattern = "dea";
		int hashOfPattern = pattern.hashCode();
                int hashOfInput;

		for(int i = 0; i<input.length()-pattern.length()+1; ++i){
			String subString = input.substring(i,i+pattern.length());
			hashOfInput = subString.hashCode();
			if(hashOfInput == hashOfPattern)
				System.out.println("INDEX FOUND AT "+ ( i+1 ) );
		}
	}
}