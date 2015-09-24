package crazysoap;

public enum Implementation {
	JDK7_80(new ParseBooleanJDK7_80()),
	JDK6_27(new ParseBooleanJDK6_27()),
	JDK6_27_OPT(new ParseBooleanJDK6_27Optimized()),
	SIMPLE(new ParseBooleanSimpleImpl()),
	STRINGSWITCH(new ParseBooleanStringSwitch()),
	OPTIMIZED(new ParseBooleanOptimizedImpl()),
	RESEARCH(new ParseBooleanResearchImpl()),
	;
	
	private ParseBoolean instance;

	private Implementation(ParseBoolean instance) {
		this.instance = instance;
	}
	
	public ParseBoolean getInstance() {
		return instance;
	}
}
