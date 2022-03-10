
//import
import java.util.Scanner;
import java.util.regex.*;

public class PasswordChecker {

	public static void main(String args[]) {
		try (Scanner keyboard = new Scanner(System.in)) {
			System.out.println("Please enter a username:");
			String username = keyboard.next();
			System.out.println();

			System.out.println("Please enter a password. Your password should: ");
			System.out.println("contain at least one lowercase letter,");
			System.out.println("contain at least one uppercase letter, ");
			System.out.println("contain at least  one number, ");
			System.out.println("contain at least  one special character, ");
			System.out.println("be between 8 and 20 characters.");
			String password = keyboard.next();

			// Forse the user to enter a valid password via a while loop.
			while (!isValidPassword(password)) {
				System.out.println("This is not a valid password. Please try agian");
				password = keyboard.next();
				System.out.println();
			}
			System.out.println("Valid password");
			System.out.println();

			try {
				mockDatabase(username, password);
			} catch (Exception e) {
				System.err.println("Something went wrong");
			}
		}
	}

	public static void mockDatabase(String username, String password) throws Exception {
		if (isValidPassword(password)) {
			System.out.println("User registered as: " + username + ", " + password);
		}
	}

	public static boolean isValidPassword(String password) {

		// Regex to check valid password.
		String regex = "^(?=.*[0-9])"
				+ "(?=.*[a-z])(?=.*[A-Z])"
				+ "(?=.*[@#$%^&+=])"
				+ "(?=\\S+$).{8,20}$";

		Pattern p = Pattern.compile(regex);

		// If the password is empty return false
		if (password == null) {
			return false;
		}

		// Pattern class contains matcher() method
		Matcher m = p.matcher(password);

		// Return if the password matched the ReGex
		return m.matches();
	}

}