package crazysoap;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParseBooleanCoverageTest {

	@Test
	public void testCoverageSample() {
		for (Value value : new Value[]{Value.TRUE, Value.FALSE, Value.ZERO, Value.ONE}) {
			assertEquals(value.getExpectedBoolean(), Implementation.RESEARCH.getInstance().parse(value.getValue()));
		}
	}
}
