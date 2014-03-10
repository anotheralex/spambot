import org.junit.*;
import static org.junit.Assert.*;
import java.net.MalformedURLException;

public class WebPageImplTest {

	private WebPage wp;
	private String strurl;

	@Before
	public void setup() {
		//strurl = "http://www.morleycollege.ac.uk/staff_email";
		strurl = "http://www.oracle.com/index.html";
		try {
			wp = new WebPageImpl(strurl);
		} catch (MalformedURLException e) {
			System.out.println("Malformed URL");
		}
	}

	@Test
	public void getUrlTest() {
		String expected = strurl;
		String actual = wp.getUrl();
		assertEquals(expected, actual);
	}



}
