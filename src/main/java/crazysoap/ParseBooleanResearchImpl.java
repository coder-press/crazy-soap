package crazysoap;


public class ParseBooleanResearchImpl implements ParseBoolean {

	@Override
	public boolean parse(String src) {
		int length = src.length();
		if (length==1) {
			return src.charAt(0)=='1';
		}
		
		char[] chars = src.toCharArray();
		if (length==2) {
			if (chars[0]!='1' && chars[1]!='1'){
				return false;
			}
		}
		if (length==3) {
			if (chars[0]!='1' && chars[1]!='1' && chars[2]!='1'){
				return false;
			}
		}
		if (length==4) {
			if (chars[0]!='1' && chars[1]!='1' && chars[2]!='1' && chars[3]!='1') {
				return chars[0]=='t' && chars[1]=='r' && chars[2]=='u' && chars[3]=='e';
			}
		}
		
		int start=-1;
		
		for (int left=0;left<length;left++) {
			if (!isWhiteSpace(chars[left])) {
				start=left;
				break;
			}
		}
		
		if (start==-1) {
			return false;
		}
		
		int end;
		if (chars[start]=='1') {
			end=start+1;
		} else {
			if (chars[start]=='t') {
				end=start+4;
				if (end<length) {
					if (chars[start+1]!='r' || chars[start+2]!='u' || chars[start+3]!='e') {
						return false;
					}
				}
			} else {
				return false;
			}
		}
		for (int right=end;right<length;right++) {
			if (!isWhiteSpace(chars[right])) {
				return false;
			}
		}
		
		return true;
	}

    private static final boolean isWhiteSpace(char ch) {
        return ch<=0x20 && ( ch == 0x9 || ch == 0xA || ch == 0xD || ch == 0x20);
    }

}
