package multithreading;

class printClass2{
    void syncPrint( int n ){
        synchronized( this ){
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
}
class custthr3 extends Thread{
    int n;
    printClass p1;
    custthr3( printClass p1 ){
        this.p1 = p1;
    }
    public void run( ){
        p1.syncPrint( 5 );
    }
}
class custthr4 extends Thread{
    int n;
    printClass p2;
    custthr4( printClass p2 ){
        this.p2 = p2;
    }
    public void run( ){
        p2.syncPrint( 100 );
    }
}
public class staticSynchronizatonClass {
    public static void main( String args[] ) throws InterruptedException{
        printClass obj = new printClass();
        System.out.println( "SYNCHRONIZED" );
        custthr3 t1 = new custthr3( obj );
        custthr4 t2 = new custthr4( obj );
        t1.start();
        t2.start();
    }
}