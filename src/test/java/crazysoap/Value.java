package crazysoap;

public enum Value {

	TRUE("true",true),
	FALSE("false",false),
	ONE("1",true),
	ZERO("0",false),
	
	TRU("tru",false,true),
	FALS("fals",false),
	TRUE_SPACE("  true  ",true),
	ONE_SPACE("  1  ",true),
	FALSE_SPACE("  false  ",false);
	
	private String value;
	private boolean expected;
	private boolean unstable;
	
	Value(String value, boolean expected, boolean unstable) {
		this.value = value;
		this.expected = expected;
		this.unstable = unstable;
	}
	
	Value(String value, boolean expected) {
		this(value, expected, false);
	}
	
	public String getValue() {
		return value;
	}
	
	public boolean getExpectedBoolean() {
		return expected;
	}
	
	public boolean isUnstable() {
		return unstable;
	}
}
