package crazysoap;


public class ParseBooleanOptimizedImpl implements ParseBoolean {

	@Override
	public boolean parse(String src) {
		String value=src.trim();
		int len=value.length();
		if (len==1) {
			return value.charAt(0)=='1';
		}
		if (len==4) {
			return "true".equals(value);
		}
		return false;
	}

}
