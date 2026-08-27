import java.util.*;
public class DP19{
    public static void main(String[] args) {
       int W = 4;
       int val[] = {1, 2, 3};
       int wt[] = {4, 5, 1};
        int[][]dp=new int[wt.length][W+1];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
         System.out.println( solvenormal(W,val,wt,0,0,0));
    System.out.println(solveDp(W,val,wt,0,0,0,dp));
    }
    //NORMAL Solution
    public static int solvenormal(int W, int val[], int wt[],int index,int profit,int weight){
        if(index==wt.length){
            return 0;
        }
        int taken=0;
        
        if(wt[index]+weight<=W){
            taken=val[index]+solvenormal(W,val,wt,index+1,profit+val[index],weight+wt[index]);
        }
        int nottaken=solvenormal(W,val,wt,index+1,profit,weight);
        return Math.max(taken,nottaken);
    }
    //MEMOIZATION APPROACH
    public static int solveDp(int W, int val[], int wt[],int index,int profit,int weight,int[][]dp){
         if(index==wt.length){
            return 0;
        }
        if(dp[index][weight]!=-1){
            return dp[index][weight];
        }
        int taken=0;
        
        if(wt[index]+weight<=W){
            taken=val[index]+solveDp(W,val,wt,index+1,profit+val[index],weight+wt[index],dp);
        }
        int nottaken=solveDp(W,val,wt,index+1,profit,weight,dp);
        return dp[index][weight]=Math.max(taken,nottaken);
    }
    //Tabulation Approach
    public static int knapsack(int W, int val[], int wt[]) {

    int n = wt.length;

    int[][] dp = new int[n + 1][W + 1];

    // Base case:
    // dp[n][weight] = 0
    // Already handled because Java initializes int array with 0.

    for (int index = n - 1; index >= 0; index--) {

        for (int weight = W; weight >= 0; weight--) {

            // Not take
            int nottaken = dp[index + 1][weight];

            // Take
            int taken = 0;

            if (weight + wt[index] <= W) {
                taken = val[index] +
                        dp[index + 1][weight + wt[index]];
            }

            dp[index][weight] = Math.max(taken, nottaken);
        }
    }

    return dp[0][0];
}
}