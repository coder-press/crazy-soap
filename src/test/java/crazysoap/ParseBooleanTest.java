package crazysoap;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ParseBooleanTest {

	private ParseBoolean impl;
	private Value value;

	@Parameterized.Parameters(name = "{0}: {1}")
	public static Collection<Object[]> ALL() {
		List<Object[]> ret=new ArrayList<>();
		for (Implementation impl : Implementation.values()) {
			for (Value v : Value.values()) {
				ret.add(new Object[]{impl , v});
			}
		}
		return ret;
	}
	
	public ParseBooleanTest(Implementation impl, Value value) {
		this.impl = impl.getInstance();
		this.value = value;
	}
	
	@Test
	public void parse() {
		boolean ret = impl.parse(value.getValue());
		if (!value.isUnstable()) {
			assertEquals(value.getExpectedBoolean(), ret);
		}
	}
	
//	@Test
//	public void testImplementations() {
//		assertEquals(true, impl.parse("true"));
//		assertEquals(true, impl.parse(" true"));
//		assertEquals(true, impl.parse("true "));
//		assertEquals(true, impl.parse("  true  "));
//		assertEquals(true, impl.parse("1"));
//		assertEquals(true, impl.parse(" 1"));
//		assertEquals(true, impl.parse("1 "));
//		assertEquals(true, impl.parse("  1 "));
//		assertEquals(true, impl.parse("  1  "));
//		assertEquals(false, impl.parse("false"));
//		assertEquals(false, impl.parse("0"));
//		assertEquals(false, impl.parse("fals"));
////		assertEquals(false, impl.parse("tru")); 6_27 != 7_80
//		assertEquals(false, impl.parse("  false  "));
//		assertEquals(true, impl.parse("  1  "));
//	}
}
