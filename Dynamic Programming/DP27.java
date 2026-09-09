class DP27 {
    public int longCommSubstr(String s1, String s2) {

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        return helper(s1, s2, dp);
    }

    public static int helper(String s1, String s2, int[][] dp) {

        int n = s1.length();
        int m = s2.length();
        int ans = 0;

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {

                    dp[i][j] = 1 + dp[i - 1][j - 1];

                    ans = Math.max(ans, dp[i][j]);

                } else {

                    dp[i][j] = 0;
                }
            }
        }

        return ans;
    }
}