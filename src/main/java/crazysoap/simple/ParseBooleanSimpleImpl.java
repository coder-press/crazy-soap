package crazysoap.simple;

import crazysoap.ParseBoolean;

public class ParseBooleanSimpleImpl implements ParseBoolean {

	@Override
	public boolean parse(String value) {
		if ("1".equals(value)) return true;
		if ("true".equals(value)) return true;
		return false;
	}

}
