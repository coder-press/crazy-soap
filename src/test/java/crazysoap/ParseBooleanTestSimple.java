package crazysoap;

import crazysoap.simple.ParseBooleanSimpleImpl;

public class ParseBooleanTestSimple extends AbstractParseBooleanBenchmarkTest {

	@Override
	protected ParseBoolean instance() {
		return new ParseBooleanSimpleImpl();
	}

}
