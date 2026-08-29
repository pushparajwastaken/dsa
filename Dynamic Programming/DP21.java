import java.util.*;
public class DP21 {
    public static void main(String[] args) {
        int[]nums={1,1,1,1,1};
        int target=3;
        System.out.println(findTargetSumWays(nums,target));
    }
     public static int findTargetSumWays(int[] nums, int target) {
       int[][]dp=new int[nums.length+1][target+1];
       for(int[]row:dp){
        Arrays.fill(row,-1);
       }
        return solve(nums,target,0,dp);
    }
    
    public static int solve(int[] nums, int target,int index,int [][]dp){
 if(index==nums.length){
            return target==0 ?1:0;}
            
        int sub=solve(nums,target-nums[index],index+1,dp);;
        
        int add=solve(nums,target+nums[index],index+1,dp);
        return sub+add;
    }
}