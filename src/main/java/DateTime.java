import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateTime {

  public int dateTime(){
  GregorianCalendar time = new GregorianCalendar();
  int hour = time.get(Calendar.HOUR_OF_DAY);
  int min = time.get(Calendar.MINUTE);
  int day = time.get(Calendar.DAY_OF_MONTH);
  int month = time.get(Calendar.MONTH) + 1;
  int year = time.get(Calendar.YEAR);
  
  System.out.println(hour);
  return hour;

  }
}