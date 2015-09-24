package crazysoap;


public class ParseBooleanOptimizedImpl implements ParseBoolean {

	@Override
	public boolean parse(String src) {
		// removes only space
		String value=src.trim();
		int len=value.length();
		if (len==1) {
			return value.charAt(0)=='1';
		}
		if (len==4) {
			char[] chars=value.toCharArray();
			return chars[0]=='t' && chars[1]=='r' && chars[2]=='u' && chars[3]=='e';
		}
		return false;
	}

}
