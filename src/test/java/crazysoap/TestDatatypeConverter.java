package crazysoap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.xml.bind.DatatypeConverter;

import org.junit.Test;


/**
 * @see javax.xml.bind.DatatypeConverterImpl._parseBoolean(CharSequence)
 * @author mosmann
 *
 */
public class TestDatatypeConverter {

	@Test
	public void expectedBehavior() {
		isTrue("true");
		isTrue("1");
		isFalse("false");
		isFalse("0");
	}
	
	@Test
	public void unexpectedBehavior() {
		whyFalse("foo");
		whyTrue("1x");
		whyNPE("0ne");
		whyTrue("trust");
		whyNPE("trustme");
		whyFalse("trick");
		whyTrue("truck");
		whyNPE("trucker");
		whyFalse("falsey");
		whyIndexOutOfBound("f");
		whyFalse(" f ");
		whyFalse(" t ");
		whyTrue("truth");
		whyNPE("falsehood");
//		whyTrue(" tru");
//		whyTrue(" t r u ");
		whyFalse("foolish");
		whyNPE("");
		
		whyFalse("    ");
		whyNPE(null);
		whyStringIndexOutOfBound("t");
		whyFalse("tru");
		whyTrue("truu");
		whyTrue(" truu");
		whyNPE("  tru u ");
		whyTrue("  true ");
		whyFalse("x");
		whyFalse("x ");
		whyFalse("x      ");
	}
	
	
	
	
	
	
	
	private static void whyIndexOutOfBound(String value) {
		try {
			parseBoolean(value);
			fail("not NPE");
		} catch (IndexOutOfBoundsException x) {
			
		}
	}
	
	private static void whyStringIndexOutOfBound(String value) {
		try {
			parseBoolean(value);
			fail("not NPE");
		} catch (StringIndexOutOfBoundsException x) {
			
		}
	}
	

	
	private static void whyNPE(String value) {
		try {
			parseBoolean(value);
			fail("not NPE");
		} catch (NullPointerException x) {
			
		}
	}
	
	private static void whyTrue(String value) {
		isTrue(value);
	}
	
	private static void whyFalse(String value) {
		isFalse(value);
	}
	
	private static void isTrue(String value) {
		assertEquals(true, parseBoolean(value));
	}
	
	private static void isFalse(String value) {
		assertEquals(false, parseBoolean(value));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static boolean parseBoolean(String value) {
		if (true) {
			return DatatypeConverter.parseBoolean(value);
		}
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
