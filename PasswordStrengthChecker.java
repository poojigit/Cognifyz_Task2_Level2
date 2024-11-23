import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a password to check its strength: ");
        String password = scanner.nextLine();

        String strength = checkPasswordStrength(password);
        System.out.println("Password strength: " + strength);

        scanner.close();
    }

    public static String checkPasswordStrength(String password) {
        if (password.length() < 8) {
            return "Weak: Password must be at least 8 characters long.";
        }

        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }

        if (!hasUppercase || !hasLowercase || !hasDigit || !hasSpecialChar) {
            return "Weak: Password must contain uppercase letters, lowercase letters, digits, and special characters.";
        }

        if (password.length() >= 12) {
            return "Strong: Good job! Your password is strong.";
        } else {
            return "Moderate: Your password is moderate. Consider making it longer.";
        }
    }
}