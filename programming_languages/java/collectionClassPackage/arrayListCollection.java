package collectionClassPackage;

import java.util.ArrayList;
import java.util.*;

class Students {
    int a;
    int b;
    public Students() {
        a = b = 100;
    }
}

public class arrayListCollection {
    public static void main( String args[] ){
        ArrayList<Students> obj = new ArrayList<>();
        Students s1 = new Students();
        Students s2 = new Students();
        Students s3 = new Students();
        obj.add(s1);
        obj.add(s2);
        obj.add(s3);
        
        System.out.println( "TYPE ONE TO PRINT OBJECTS" );
        Iterator itr=obj.iterator();
        Students s;
        while(itr.hasNext()){
            s = (Students) itr.next();
            System.out.println(s.a + " " + s.b );
        }
        
        System.out.println( "TYPE TWO TO PRINT OBJECTS" );
        for( Students i : obj )
            System.out.println( i.a + " " + i.b );
    }
}    