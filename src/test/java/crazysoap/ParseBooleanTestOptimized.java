package crazysoap;

import crazysoap.optimized.ParseBooleanOptimizedImpl;

public class ParseBooleanTestOptimized extends AbstractParseBooleanBenchmarkTest {

	@Override
	protected ParseBoolean instance() {
		return new ParseBooleanOptimizedImpl();
	}

}
