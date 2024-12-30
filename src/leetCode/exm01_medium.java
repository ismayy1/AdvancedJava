package leetCode;

public class exm01_medium {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int mod = 1_000_000_007;

        // dp[i] represents the number of good strings of length i.
        int[] dp = new int[high + 1];
        dp[0] = 1; // Base case: there's one way to construct an empty string.

        for (int length = 1; length <= high; length++) {
            // If we can append '0' zero times to form a string of this length.
            if (length >= zero) {
                dp[length] = (dp[length] + dp[length - zero]) % mod;
            }
            // If we can append '1' one times to form a string of this length.
            if (length >= one) {
                dp[length] = (dp[length] + dp[length - one]) % mod;
            }
        }

        // Sum up all the good strings of lengths between low and high.
        int result = 0;
        for (int length = low; length <= high; length++) {
            result = (result + dp[length]) % mod;
        }

        return result;
    }

    public static void main(String[] args) {
        exm01_medium gs = new exm01_medium();
        int low = 3;
        int high = 10;
        int zero = 2;
        int one = 3;
        System.out.println("Number of good strings: " + gs.countGoodStrings(low, high, zero, one));
    }
}
