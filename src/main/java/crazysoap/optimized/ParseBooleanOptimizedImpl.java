package crazysoap.optimized;

import crazysoap.ParseBoolean;

public class ParseBooleanOptimizedImpl implements ParseBoolean {

	@Override
	public boolean parse(String value) {
		if ("1".equals(value)) return true;
		if ("0".equals(value)) return false;
		if ("true".equals(value)) return true;
		return false;
	}

}
