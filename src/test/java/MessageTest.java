import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import org.junit.Test;

public class MessageTest {
	
	private Message message = new Message();

	@Test
	public void messageSaysHello() {
		assertThat(message.sayHello(), containsString("Hello World"));
	}

}
