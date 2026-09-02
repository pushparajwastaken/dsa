import java.util.Arrays;

public class DP25 {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int[][] dp=new int[n+1][m+1];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return helper(text1,text2,n-1,m-1,dp);
    }
   public static int helper(String s1,String s2,int i,int j,int[][]dp){
    if(i<0 || j<0){
        return 0;
    }
    if(dp[i][j]!=-1){
        return dp[i][j];
    }
    if(s1.charAt(i)==s2.charAt(j)){
        dp[i][j]=1+helper(s1,s2,i-1,j-1,dp);
    }else{
        dp[i][j]=Math.max(
            helper(s1,s2,i-1,j,dp),
            helper(s1,s2,i,j-1,dp)
        );
    }
    return dp[i][j];
   }
}
