package multithreading;

import static java.lang.Thread.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class customThread extends Thread{
    public customThread( String str, int i ){
        this.setName(str);
        this.setPriority( i );
    }
    @Override
    public void run(){
        for( int i = 0; i < 10; ++i){
            System.out.println(this.getName());
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(customThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
class customThread2 implements Runnable{
    @Override
    public void run(){
        System.out.println("DAEMON");
    }
}
public class multithreadingClass {
    public static void main( String args[] ){
        customThread t1 = new customThread("THREAD1", 3);
        customThread t2 = new customThread("THREAD2", 2);
        customThread t3 = new customThread("THREAD3", 1);
        customThread2 td = new customThread2();
        Thread t4 = new Thread( td );

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        System.out.println(activeCount());
    }
}