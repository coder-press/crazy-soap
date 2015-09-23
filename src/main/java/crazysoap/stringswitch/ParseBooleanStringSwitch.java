package crazysoap.stringswitch;

import crazysoap.ParseBoolean;

public class ParseBooleanStringSwitch implements ParseBoolean {

	@Override
	public boolean parse(String value) {
		switch (value) {
			case "1": 
			case "true": 
				return true;
		}
		return false;
	}

}
