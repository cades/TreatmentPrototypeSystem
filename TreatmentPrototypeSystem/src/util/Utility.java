package util;

import java.util.Date;
import java.text.DateFormat;

public class Utility {
    final static int DEBUG_LEVEL = 0;
    static DateFormat fullFormat = 
        DateFormat.getDateTimeInstance( 
            DateFormat.FULL, DateFormat.FULL);
    
    public static void DEBUG(int level, String str) {
        if (level >= DEBUG_LEVEL)
            System.out.println(str);
    }
    
    public static void printDate() {
        Date date = new Date();
        System.out.println(fullFormat.format(date)); 
    }
    
}
