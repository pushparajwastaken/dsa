import java.util.Arrays;

public class DP20{
    public static void main(String[] args) {
        int[]coins = {1,2,5};
        int amount = 11;
         int[][] dp=new int[coins.length+1][amount+1];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        int ans = solve(coins, amount, 0,dp);

        if (ans == Integer.MAX_VALUE) {
            System.out.println("-1");
        }

        System.out.println(ans);
    }
       public static int solve(int[] coins, int target,int index,int[][]dp){
        if(target==0){
            return 0;
        }
        if(index==coins.length){
            return Integer.MAX_VALUE;
        }
        if(dp[index][target]!=-1){
            return dp[index][target];
        }
        int take=Integer.MAX_VALUE;
        if(target-coins[index]>=0){
            int result=solve(coins,target-coins[index],index,dp);
                        if (result != Integer.MAX_VALUE) {
                take = 1 + result;
            }

        }
        int nottake=solve(coins,target,index+1,dp);
        return dp[index][target]=Math.min(take,nottake);
    }



    public int coinChange(int[] coins, int amount) {

        int n = coins.length;

        int[][] dp = new int[n + 1][amount + 1];

        // Base case: target = 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        // Base case: no coins available
        for (int target = 1; target <= amount; target++) {
            dp[n][target] = Integer.MAX_VALUE;
        }

        // Fill DP table
        for (int index = n - 1; index >= 0; index--) {

            for (int target = 1; target <= amount; target++) {

                // NOT TAKE
                int nottake = dp[index + 1][target];

                // TAKE
                int take = Integer.MAX_VALUE;

                if (coins[index] <= target) {

                    int result = dp[index][target - coins[index]];

                    if (result != Integer.MAX_VALUE) {
                        take = 1 + result;
                    }
                }

                dp[index][target] = Math.min(take, nottake);
            }
        }

        int ans = dp[0][amount];

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
