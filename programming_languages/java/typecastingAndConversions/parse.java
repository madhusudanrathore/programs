package typecastingAndConversions;

public class parse {
    public static void main( String args[] ){

        String str = "15479";
        int a = Integer.parseInt( str );//STRING to INT
        System.out.println( a );

        a = 9867;

        str = String.valueOf( a );//INT to STRING
        System.out.println( str );
    }
}
