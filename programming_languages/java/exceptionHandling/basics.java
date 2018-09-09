package exceptionHandling;

public class basics {
    public static void main( String args[] ){

        int i;
        int a[] = new int [10];
        try{
            i = 10/0;
            System.out.println( a[11] );
        }catch( ArrayIndexOutOfBoundsException e ){
            System.out.println( e );
        }catch( ArithmeticException e ){
            System.out.println( e );
        }catch( Exception e ){
            System.out.println( e );
        }
        System.out.println( a[0] );
    }
}
