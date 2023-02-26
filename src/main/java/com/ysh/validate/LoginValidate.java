package com.ysh.validate;

public class LoginValidate {

	public int validate(String ID, String Password) {
		if (ID.charAt(0) == '1' && ID.length() == 4 && Password.length() <= 8)
			return 1;
		else if (ID.charAt(0) == 'S')
			return 2;
		return 0;
	}
}
