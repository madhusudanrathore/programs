package multithreading;

class printClass{
    synchronized void syncPrint( int n ){
        for( int i = 1; i < 5; ++i){
            System.out.println( n*i + " ");
            try {
                Thread.sleep( 1 );
            } catch (InterruptedException ex) {
                System.out.println( ex );
            }
        }
    }
}
class custthr1 extends Thread{
    int n;
    printClass p1;
    custthr1( printClass p1 ){
        this.p1 = p1;
    }
    public void run( ){
        p1.syncPrint( 5 );
    }
}
class custthr2 extends Thread{
    int n;
    printClass p2;
    custthr2( printClass p2 ){
        this.p2 = p2;
    }
    public void run( ){
        p2.syncPrint( 100 );
    }
}
public class synchronizatonClass {
    public static void main( String args[] ) throws InterruptedException{
        printClass obj = new printClass();
        System.out.println( "SYNCHRONIZED" );
        custthr1 t1 = new custthr1( obj );
        custthr2 t2 = new custthr2( obj );
        t1.start();
        t2.start();
    }
}