package crazysoap;

import static org.junit.Assert.assertEquals;

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
			new ParseBooleanJDK6_27(),
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
//		assertEquals(false, impl.parse("tru")); 6_27 != 7_80
		assertEquals(true, impl.parse("  true  "));
		assertEquals(false, impl.parse("  false  "));
		assertEquals(true, impl.parse("  1  "));
	}
}
