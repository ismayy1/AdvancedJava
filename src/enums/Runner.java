package enums;

public class Runner {
    public static void main(String[] args) {

        printPasswordStrengthConstant("LOW");

    }

    public static void printPasswordStrengthConstant(String strength) {
        if(strength.equals(PasswordStrengthConstant.LOW)) {
            System.out.println("Your password strength is LOW");
        } else if (strength.equals(PasswordStrengthConstant.MEDIUM)) {
            System.out.println("Your password strength is MEDIUM");
        } else {
            System.out.println("Your password strength is HIGH");
        }
    }

}
