package com.ysh.security;

/**
 *
 * @author test
 */
public class PWDDriver {

	@SuppressWarnings("static-access")
	public static void main(String arg[]) {
		/* Plain text Password. */
		String password = "myNewPass123";
		@SuppressWarnings("unused")
		SHA256 PWD = new SHA256();

		/* generates the Salt value. It can be stored in a database. */
		String saltvalue = SHA256.getSaltvalue(30);
		

		/* generates an encrypted password. It can be stored in a database. */
		String encryptedpassword = SHA256.generateSecurePassword(password, saltvalue);

		System.out.println("Plain text password = " + password);
		System.out.println("Secure password = " + encryptedpassword);
		System.out.println("Salt value = " + saltvalue);

		Boolean status = SHA256.verifyUserPassword(password, encryptedpassword, saltvalue);
		if (status == true) {
			System.out.println("Password Matched!!");
		} else {
			System.out.println("Password Mismatched");
		}
	}

}
