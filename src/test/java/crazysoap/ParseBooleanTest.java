package crazysoap;

import static org.junit.Assert.assertEquals;
import crazysoap.jdk7_80.ParseBooleanJDK7_80;
import crazysoap.optimized.ParseBooleanOptimizedImpl;
import crazysoap.simple.ParseBooleanSimpleImpl;
import crazysoap.stringswitch.ParseBooleanStringSwitch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ParseBooleanTest {

	private ParseBoolean impl;

	@Parameterized.Parameters(name = "impl {0}")
	public static ParseBoolean[] ALL() {
		return new  ParseBoolean[] {
			new ParseBooleanJDK7_80(),
			new ParseBooleanSimpleImpl(),
			new ParseBooleanOptimizedImpl(),
			new ParseBooleanStringSwitch()
		};
	}
	
	public ParseBooleanTest(ParseBoolean impl) {
		this.impl = impl;
	}
	
	@Test
	public void testImplementations() {
		assertEquals(true, impl.parse("true"));
		assertEquals(true, impl.parse("1"));
		assertEquals(false, impl.parse("false"));
		assertEquals(false, impl.parse("0"));
		assertEquals(false, impl.parse("fals"));
		assertEquals(false, impl.parse("tru"));
	}
}
