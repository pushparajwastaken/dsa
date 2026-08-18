class DP15 {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%2!=0)return false;
        return generateSubsequencesViaTab(nums,sum/2);
    }
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