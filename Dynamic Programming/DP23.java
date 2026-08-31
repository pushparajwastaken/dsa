import java.util.Arrays;

public class DP23{
        public int knapSack(int val[], int wt[], int capacity) {
        // code here
        int[][]dp=new int[wt.length][capacity+1];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return solvenormal(capacity,val,wt,0,0,0,dp);
    }
    public static int solvenormal(int W, int val[], int wt[],int index,int profit,int weight,int[][]dp){
        if(index==wt.length){
            return 0;
        }
        if(dp[index][weight]!=-1){
            return dp[index][weight];
        }
        int taken=0;

        if(wt[index]+weight<=W){
            taken=val[index]+solvenormal(W,val,wt,index,profit+val[index],weight+wt[index],dp);
        }
        int nottaken=solvenormal(W,val,wt,index+1,profit,weight,dp);
        return dp[index][weight]=Math.max(taken,nottaken);
    }
}