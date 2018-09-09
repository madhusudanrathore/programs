package API_DateTimeZone;

import java.time.LocalTime;
import java.time.ZoneId;

public class getZone {
    public static void main( String args[] ){

        ZoneId id = ZoneId.of("Asia/Kolkata");
        LocalTime time = LocalTime.now(id);
        System.out.println( time );
    }
}
