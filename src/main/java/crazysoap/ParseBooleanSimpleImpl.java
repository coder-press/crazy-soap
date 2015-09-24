package crazysoap;


public class ParseBooleanSimpleImpl implements ParseBoolean {

	@Override
	public boolean parse(String src) {
		// removes only space 
		String value=src.trim();
		if ("1".equals(value)) return true;
		if ("true".equals(value)) return true;
		return false;
	}

}
