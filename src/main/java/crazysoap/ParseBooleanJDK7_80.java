package crazysoap;



public class ParseBooleanJDK7_80  implements ParseBoolean {

	@Override
	public boolean parse(String value) {
		return parseBoolean(value);
	}
	
	static boolean parseBoolean(String value) {
		return _parseBoolean(value);
	}
	
    public static Boolean _parseBoolean(CharSequence literal) {
        if (literal == null) {
            return null;
        }

        int i = 0;
        int len = literal.length();
        char ch;
        boolean value = false;

        if (literal.length() <= 0) {
            return null;
        }

        do {
            ch = literal.charAt(i++);
        } while (WhiteSpaceProcessor.isWhiteSpace(ch) && i < len);

        int strIndex = 0;

        switch (ch) {
            case '1':
                value = true;
                break;
            case '0':
                value = false;
                break;
            case 't':
                String strTrue = "rue";
                do {
                    ch = literal.charAt(i++);
                } while ((strTrue.charAt(strIndex++) == ch) && i < len && strIndex < 3);

                if (strIndex == 3) {
                    value = true;
                } else {
                    return false;
                }
//                    throw new IllegalArgumentException("String \"" + literal + "\" is not valid boolean value.");

                break;
            case 'f':
                String strFalse = "alse";
                do {
                    ch = literal.charAt(i++);
                } while ((strFalse.charAt(strIndex++) == ch) && i < len && strIndex < 4);


                if (strIndex == 4) {
                    value = false;
                } else {
                    return false;
                }
//                    throw new IllegalArgumentException("String \"" + literal + "\" is not valid boolean value.");

                break;
        }

        if (i < len) {
            do {
                ch = literal.charAt(i++);
            } while (WhiteSpaceProcessor.isWhiteSpace(ch) && i < len);
        }

        if (i == len) {
            return value;
        } else {
            return null;
        }
//            throw new IllegalArgumentException("String \"" + literal + "\" is not valid boolean value.");
    }
    
    static class WhiteSpaceProcessor {
        /**
         * Returns true if the specified string is all whitespace.
         */
        public static final boolean isWhiteSpace(CharSequence s) {
            for( int i=s.length()-1; i>=0; i-- )
                if(!isWhiteSpace(s.charAt(i)))
                    return false;
            return true;
        }

        /** returns true if the specified char is a white space character. */
        public static final boolean isWhiteSpace(char ch) {
            // most of the characters are non-control characters.
            // so check that first to quickly return false for most of the cases.
            if( ch>0x20 )   return false;

            // other than we have to do four comparisons.
            return ch == 0x9 || ch == 0xA || ch == 0xD || ch == 0x20;
        }

    }

}
