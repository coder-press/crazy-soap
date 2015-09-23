package crazysoap;

import crazysoap.stringswitch.ParseBooleanStringSwitch;

public class ParseBooleanTestStringSwitch extends AbstractParseBooleanBenchmarkTest {

	@Override
	protected ParseBoolean instance() {
		return new ParseBooleanStringSwitch();
	}

}
