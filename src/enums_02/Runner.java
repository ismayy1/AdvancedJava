package enums_02;

public class Runner {
    public static void main(String[] args) {

        printPasswordStrengthMessage("TOO WEAK");

        System.out.println("=================================================");

        printPasswordStrengthEnum(PasswordStrength.TOO_WEAK);
        printPasswordStrengthEnum(PasswordStrength.WEAK);
        printPasswordStrengthEnum(PasswordStrength.STRONG);
        printPasswordStrengthEnum(PasswordStrength.VERY_STRONG);

        System.out.println("=================================================");


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

    public static void printPasswordStrengthEnum(PasswordStrength strength) {
        if (strength.equals(PasswordStrength.TOO_WEAK)) {
            System.out.println("Your password is Too Weak!");
            System.out.println("Level: " + strength.getLevel());
        } else if (strength.equals(PasswordStrength.WEAK)) {
            System.out.println("Your password is Weak!");
            System.out.println("Level: " + strength.getLevel());
        } else if (strength.equals(PasswordStrength.MEDIUM)) {
            System.out.println("Your password is Strong!");
            System.out.println("Level: " + strength.getLevel());
        } else if (strength.equals(PasswordStrength.STRONG)) {
            System.out.println("Your password is Strong!");
            System.out.println("Level: " + strength.getLevel());
        } else if (strength.equals(PasswordStrength.VERY_STRONG)) {
            System.out.println("Your password is Very Strong!");
            System.out.println("Level: " + strength.getLevel());
        }
        System.out.println("Enum order: " + strength.ordinal());    // gives us the index of the enum
        System.out.println("Enum name: " + strength.name());
    }
}
