package crazysoap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import crazysoap.jdk7_80.ParseBooleanJDK7_80;

import org.junit.Test;


/**
 * @see javax.xml.bind.DatatypeConverterImpl._parseBoolean(CharSequence)
 * @author mosmann
 *
 */
public class TestDatatypeConverter {

	@Test
	public void expectedBehavior() {
		isTrue("true");
		isTrue("1");
		isFalse("false");
		isFalse("0");
	}
	
	@Test
	public void unexpectedBehavior() {
		whyFalse("foo");
		whyTrue("1x");
		whyNPE("0ne");
		whyTrue("trust");
		whyNPE("trustme");
		whyFalse("trick");
		whyTrue("truck");
		whyNPE("trucker");
		whyFalse("falsey");
		whyIndexOutOfBound("f");
		whyFalse(" f ");
		whyFalse(" t ");
		whyTrue("truth");
		whyNPE("falsehood");
//		whyTrue(" tru");
//		whyTrue(" t r u ");
		whyFalse("foolish");
		whyNPE("");
		
		whyFalse("    ");
		whyNPE(null);
		whyStringIndexOutOfBound("t");
		whyFalse("tru");
		whyTrue("truu");
		whyTrue(" truu");
		whyNPE("  tru u ");
		whyTrue("  true ");
		whyFalse("x");
		whyFalse("x ");
		whyFalse("x      ");
	}
	
	
	
	
	
	
	
	private static void whyIndexOutOfBound(String value) {
		try {
			parseBoolean(value);
			fail("not NPE");
		} catch (IndexOutOfBoundsException x) {
			
		}
	}
	
	private static void whyStringIndexOutOfBound(String value) {
		try {
			parseBoolean(value);
			fail("not NPE");
		} catch (StringIndexOutOfBoundsException x) {
			
		}
	}
	

	
	private static void whyNPE(String value) {
		try {
			parseBoolean(value);
			fail("not NPE");
		} catch (NullPointerException x) {
			
		}
	}
	
	private static void whyTrue(String value) {
		isTrue(value);
	}
	
	private static void whyFalse(String value) {
		isFalse(value);
	}
	
	private static void isTrue(String value) {
		assertEquals(true, parseBoolean(value));
	}
	
	private static void isFalse(String value) {
		assertEquals(false, parseBoolean(value));
	}
	
	
	static boolean parseBoolean(String value) {
		return new ParseBooleanJDK7_80().parse(value);
	}
	
}
