package crazysoap;

import crazysoap.jdk7_80.ParseBooleanJDK7_80;

public class ParseBooleanTestJDK7_80 extends AbstractParseBooleanBenchmarkTest {

	@Override
	protected ParseBoolean instance() {
		return new ParseBooleanJDK7_80();
	}

}
