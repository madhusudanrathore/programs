package API_DateTimeZone;

import java.time.LocalDate;

public class getDate {
    public static void main( String args[] ){
        LocalDate date = LocalDate.now();
        System.out.println( date );

        LocalDate date2 = date.plusDays(2);
        System.out.println( date2 );

        LocalDate date3 = date.minusDays(1);
        System.out.println( date3 );
    }
}
