import java.util.Arrays;

public class DP28 {
    public int longestPalindromeSubseq(String s) {

        String reversed = new StringBuilder(s).reverse().toString();

        int n = s.length();

        int[][] dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return lcs(s, reversed, n - 1, n - 1, dp);
    }

    private int lcs(String s, String reversed,
                    int i, int j, int[][] dp) {

        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) == reversed.charAt(j)) {
            return dp[i][j] =
                    1 + lcs(s, reversed, i - 1, j - 1, dp);
        }

        return dp[i][j] = Math.max(
                lcs(s, reversed, i - 1, j, dp),
                lcs(s, reversed, i, j - 1, dp)
        );
    }
}
