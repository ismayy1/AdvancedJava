package enums_02;

public class Runner {
    public static void main(String[] args) {

        printPasswordStrengthMessage("TOO WEAK");
    }

    public static void printPasswordStrengthMessage(String strength) {
        if (strength.equals(PasswordStrengthConstant.TOOWEAK)) {
            System.out.println("Your password is Too Weak!");
        } else if (strength.equals(PasswordStrengthConstant.WEAK)) {
            System.out.println("Your password is Weak!");
        } else if (strength.equals(PasswordStrengthConstant.STRONG)) {
            System.out.println("Your password is Strong!");
        } else if (strength.equals(PasswordStrengthConstant.VERYSTRONG)) {
            System.out.println("Your password is Very Strong!");
        }
    }
}
