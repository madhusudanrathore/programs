package API_DateTimeZone;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class getDatetime {
    public static void main( String args[] ){

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println( dateTime );
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = dateTime.format(fmt);
        System.out.println( dateTime );
    }
}
