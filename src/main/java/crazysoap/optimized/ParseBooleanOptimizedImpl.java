package crazysoap.optimized;

import crazysoap.ParseBoolean;

public class ParseBooleanOptimizedImpl implements ParseBoolean {

	@Override
	public boolean parse(String value) {
		int len=value.length();
		if (len==1) {
			return value.charAt(0)=='1';
		}
		if (len==4) {
			return value.charAt(0)=='t' &&  value.charAt(1)=='r' &&  value.charAt(2)=='u' &&  value.charAt(3)=='e';
		}
		return false;
	}

}
