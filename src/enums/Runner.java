package enums;

public class Runner {
    public static void main(String[] args) {

        printPasswordStrengthConstant("LOW");
        printPasswordStrengthConstant("MEDIUM");
        printPasswordStrengthConstant("strong");

        System.out.println("======== with enum ========");
        printPasswordStrengthEnum(PasswordStrengthEnums.LOW);
        printPasswordStrengthEnum(PasswordStrengthEnums.MEDIUM);
        printPasswordStrengthEnum(PasswordStrengthEnums.HIGH);

    }

    // method to set message for LOW, MEDIUM, and HIGH
    public static void printPasswordStrengthConstant(String strength) {
        if (strength.equals(PasswordStrengthConstant.LOW)) {
            System.out.println("Your password strength is LOW");
        } else if (strength.equals(PasswordStrengthConstant.MEDIUM)) {
            System.out.println("Your password strength is MEDIUM");
        } else if (strength.equals(PasswordStrengthConstant.HIGH)) {
            System.out.println("Your password strength is HIGH");
        } else {
            System.out.println("Your password strength is unknown");
        }
    }

    // enum class method to set message for LOW, MEDIUM, and HIGH
    public static void printPasswordStrengthEnum (PasswordStrengthEnums strength) {
        if(strength.equals(PasswordStrengthEnums.LOW)) {
            System.out.println("Your password strength is LOW");
        } else if (strength.equals(PasswordStrengthEnums.MEDIUM)) {
            System.out.println("Your password strength is MEDIUM");
        } else if (strength.equals(PasswordStrengthEnums.HIGH)) {
            System.out.println("Your password strength is HIGH");
        }
    }
    /*
        promt - ask user to enter the day name (monday, tuesday, ...)
        if it's equal to "MONDAY" print 1
        but user may enter in lowerCase, mon, dasf, 1 - we're getting problem
     */

}
