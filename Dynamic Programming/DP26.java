import java.util.Arrays;

public class DP26 {

    static int[][] dp;

    static int lcs(String s1, String s2, int i, int j) {

        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = 1 + lcs(s1, s2, i + 1, j + 1);
        } else {
            dp[i][j] = Math.max(
                lcs(s1, s2, i + 1, j),
                lcs(s1, s2, i, j + 1)
            );
        }

        return dp[i][j];
    }

    static String printLCS(String s1, String s2) {

        int i = 0;
        int j = 0;

        StringBuilder ans = new StringBuilder();

        while (i < s1.length() && j < s2.length()) {

            // Characters are same → take this character
            if (s1.charAt(i) == s2.charAt(j)) {
                ans.append(s1.charAt(i));
                i++;
                j++;
            }

            // Move in the direction of the larger LCS
            else if (lcs(s1, s2, i + 1, j) >=
                     lcs(s1, s2, i, j + 1)) {
                i++;
            } 
            else {
                j++;
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {

        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        dp = new int[s1.length()][s2.length()];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Fill memoization table
        System.out.println("Length: " + lcs(s1, s2, 0, 0));

        // Print LCS
        System.out.println("LCS: " + printLCS(s1, s2));
    }
}