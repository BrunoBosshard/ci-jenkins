import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GreetingMessageIT {

	GreetingMessage var = new GreetingMessage();
	private String message;

   @Test
   public void testPrintMessage() {
   	GregorianCalendar time = new GregorianCalendar();
 	int hour = time.get(Calendar.HOUR_OF_DAY);
	if (hour < 12)
    this.message = "Good Morning!";
    else if (hour < 17 && !(hour == 12))
    this.message = "Good Afternoon!";
    else if (hour == 12)
    this.message = "Good Noon!";
    else
    this.message = "Good Evening!";
   	
    assertEquals(message,var.printMessage());

   }
}