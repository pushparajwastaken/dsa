class DP14{
    public static void main(String[]args){
        int[]arr={3, 34, 4, 12, 5, 2};
        int target=30;
System.out.println(generateSubsequences(arr, target, 0, 0));
Boolean [][]dp=new Boolean[arr.length][target+1];
System.out.println(generateSubsequencesviaDP(dp,arr, target, 0,0));

    }
    //RECURSIVE APPROACH
  public static boolean generateSubsequences(int []arr,int target,int sum,int index){
if(sum==target){
    return true;
}
        if(index>arr.length-1 ||sum>target){
return false;
}

boolean isTaken=generateSubsequences(arr,target,sum+arr[index],index+1);
boolean isNotTaken=generateSubsequences(arr,target,sum,index+1);
return isTaken || isNotTaken;
    }
    //MEMOIZATION APPROACH
public static boolean generateSubsequencesviaDP(Boolean [][]dp,int []arr,int target,int sum,int index){
if(sum==target){
    return true;
}
        if(index>=arr.length ||sum>target){
return false;
}
if(dp[index][sum]!=null){
    return dp[index][sum];
}
boolean isTaken=generateSubsequencesviaDP(dp,arr,target,sum+arr[index],index+1);
boolean isNotTaken=generateSubsequencesviaDP(dp,arr,target,sum,index+1);
return dp[index][sum]= isTaken || isNotTaken;
    }
    //TABULATION
  public static boolean generateSubsequencesViaTab(
        int[] arr,
        int target) {

    int n = arr.length;

    boolean[][] dp = new boolean[n + 1][target + 1];

    // If sum == target, answer is always true.
    // Therefore, for every index, target is achievable.
    for (int i = 0; i <= n; i++) {
        dp[i][target] = true;
    }

    // Fill from right to left
    for (int index = n - 1; index >= 0; index--) {

        for (int sum = target - 1; sum >= 0; sum--) {

            boolean isTaken = false;

            if (sum + arr[index] <= target) {
                isTaken = dp[index + 1][sum + arr[index]];
            }

            boolean isNotTaken = dp[index + 1][sum];

            dp[index][sum] = isTaken || isNotTaken;
        }
    }

    return dp[0][0];
}
} 