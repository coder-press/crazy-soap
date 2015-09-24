package crazysoap;


public class ParseBooleanStringSwitch implements ParseBoolean {

	@Override
	public boolean parse(String src) {
		String value=src.trim();
		switch (value) {
			case "1": 
			case "true": 
				return true;
		}
		return false;
	}

}
