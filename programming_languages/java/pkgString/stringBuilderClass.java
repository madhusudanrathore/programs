package pkgString;
interface int1{
    void disp1();
    void disp2();
    void disp3();
}
abstract class class1 implements int1{
    public void disp1(){
        System.out.println( "disp1" );
    }
    public void disp2(){
        System.out.println( "disp2" );
    }
}
class class2 extends class1 implements int1{
    public void disp3(){
        System.out.println( "disp3" );
    }
}
public class stringBuilderClass{
    public static void main( String args[] ){
        class2 obj = new class2();
        obj.disp1();
        obj.disp2();
        obj.disp3();
    }
}