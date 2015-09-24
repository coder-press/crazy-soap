package crazysoap;

/**
 * @see http://grepcode.com/file/repository.grepcode.com/java/root/jdk/openjdk/6-b27/com/sun/xml/internal/bind/DatatypeConverterImpl.java#DatatypeConverterImpl._parseBoolean%28java.lang.CharSequence%29
 */

public class ParseBooleanJDK6_27Optimized  implements ParseBoolean {

	@Override
	public boolean parse(String value) {
		return parseBoolean(value);
	}
	
	static boolean parseBoolean(String value) {
		return _parseBoolean(value);
	}
	
	public static Boolean _parseBoolean(CharSequence literal) {
        int i=0;
        int len = literal.length();
        char ch;
        if (len <= 0) {
            return null;
        }
        do {
            ch = literal.charAt(i++);
        } while(isWhiteSpace(ch) && i<len);

        return ( ch=='t' || ch=='1' );
    }

     public static final boolean isWhiteSpace(char ch) {
        // most of the characters are non-control characters.
        // so check that first to quickly return false for most of the cases.
        if( ch>0x20 )   return false;
 		 
        // other than we have to do four comparisons.
         return ch == 0x9 || ch == 0xA || ch == 0xD || ch == 0x20;
     }
}
