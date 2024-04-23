package enums;

public enum PasswordStrengthEnums {

    LOW (10),
    MEDIUM (50),
    HIGH (100);

    private final int level;

    // parameterized constructor  - by default the constructor is private
    PasswordStrengthEnums (int level) {
        this.level = level;
    }

}
