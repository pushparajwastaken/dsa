import java.util.Arrays;

public class DP22{
     public int change(int amount, int[] coins) {
        int[][]dp= new int[coins.length+1][amount+1];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return solve(amount,coins,0,dp);
    }
    public static int solve(int amount, int[] coins,int index,int[][]dp){
        if(amount==0){
            return 1;
        }
        if(index>=coins.length|| amount<0){
            return 0;
        }
        if(dp[index][amount]!=-1){
            return dp[index][amount];
        }
        int add=solve(amount-coins[index],coins,index,dp);
        int move=solve(amount,coins,index+1,dp);
        return dp[index][amount]=add+move;

    }
}