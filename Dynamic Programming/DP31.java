import java.util.*;
public class DP31 {
       public String shortestCommonSupersequence(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        lcs(s1, s2, 0, 0, dp);

        StringBuilder ans = new StringBuilder();

        int i = 0;
        int j = 0;

        while (i < n && j < m) {

            if (s1.charAt(i) == s2.charAt(j)) {

                ans.append(s1.charAt(i));

                i++;
                j++;
            }

            else if (dp[i + 1][j] >= dp[i][j + 1]) {

                ans.append(s1.charAt(i));
                i++;
            }

            else {

                ans.append(s2.charAt(j));
                j++;
            }
        }
        while (i < n) {
            ans.append(s1.charAt(i));
            i++;
        }

        while (j < m) {
            ans.append(s2.charAt(j));
            j++;
        }

        return ans.toString();
    }


    static int lcs(String s1, String s2, int i, int j, int[][] dp) {

        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {

            dp[i][j] = 1 + lcs(
                s1, s2, i + 1, j + 1, dp
            );

        } else {

            dp[i][j] = Math.max(
                lcs(s1, s2, i + 1, j, dp),
                lcs(s1, s2, i, j + 1, dp)
            );
        }

        return dp[i][j];
    }
    
    
}
