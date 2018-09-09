package API_DateTimeZone;

import java.time.LocalTime;

public class getTime {
    public static void main( String args[] ){
        LocalTime time = LocalTime.now();
        System.out.println( time );

        LocalTime time2 = time.plusHours(2);
        System.out.println( time2 );
    }
}
