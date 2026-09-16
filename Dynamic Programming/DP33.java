import java.util.*;
class DP33{
     public boolean isMatch(String s, String p) {

        int[][] dp = new int[s.length() + 1][p.length() + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(s, p, s.length() - 1, p.length() - 1, dp);
    }

    public static boolean helper(String s, String p,
                                 int i, int j, int[][] dp) {

        if (i < 0 && j < 0) {
            return true;
        }

        if (i < 0) {
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*') {
                    return false;
                }
            }
            return true;
        }
        if (j < 0) {
            return false;
        }
        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }

        boolean ans;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            ans = helper(s, p, i - 1, j - 1, dp);
        }
        else if (p.charAt(j) == '*') {
            ans = helper(s, p, i, j - 1, dp)
               || helper(s, p, i - 1, j, dp);

        }
        else {
            ans = false;
        }

        dp[i][j] = ans ? 1 : 0;

        return ans;
    }
}