package enums_02;

public enum PasswordStrength {
    TOO_WEAK(5),
    WEAK(25),
    STRONG(50),
    VERY_STRONG(80);

    private final int leveliii;

    PasswordStrength(int levels) {
        this.leveliii = levels;
    }

    public int getLevel() {
        return leveliii;
    }
}
