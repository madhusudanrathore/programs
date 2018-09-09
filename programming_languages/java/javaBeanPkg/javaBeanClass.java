package javaBeanPkg;

public class javaBeanClass {
    int mobile;
    String name;
    public void getDetails(){
        System.out.println( name + " " + mobile );
    }
    public void setDetails( int no, String str ){
        this.mobile = no;
        this.name = str;
    }
}
