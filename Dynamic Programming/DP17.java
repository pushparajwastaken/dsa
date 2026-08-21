import java.util.Arrays;

public class DP17 {
   public static void main(String[] args) {
     int target=8;
    int[]arr={1,2,3,4,5,6,7,3,9};
     int[][] dp = new int[arr.length][target + 1];
     for (int[] row : dp) {
    Arrays.fill(row, -1);
}
System.out.println(generateSubsequencesViaTab(arr, target));
     System.out.println(generateSubsequencesviaDP(dp, arr, target, 0, 0));
   }
   //Memoization Approach
    public static int generateSubsequencesviaDP(
            int[][] dp,
            int[] arr,
            int target,
            int sum,
            int index) {
        if (index == arr.length) {
            return sum == target ? 1 : 0;
        }

        if (dp[index][sum] != -1) {
            return dp[index][sum];
        }
        int isTaken = 0;

        if (sum + arr[index] <= target) {
            isTaken = generateSubsequencesviaDP(
                    dp, arr, target,
                    sum + arr[index],
                    index + 1
            );
        }
        int isNotTaken = generateSubsequencesviaDP(
                dp, arr, target,
                sum,
                index + 1
        );

        return dp[index][sum] = isTaken + isNotTaken;
    }
public static int generateSubsequencesViaTab(int[]arr,int target){
 int n = arr.length;

    int[][] dp = new int[n + 1][target + 1];

    // If sum == target, answer is always true.
    // Therefore, for every index, target is achievable.
    for (int i = 0; i <= n; i++) {
        dp[i][target] = 1;
    }

    // Fill from right to left
    for (int index = n - 1; index >= 0; index--) {

        for (int sum = target - 1; sum >= 0; sum--) {

            int isTaken=0;

            if (sum + arr[index] <= target) {
                isTaken = dp[index + 1][sum + arr[index]];
            }

            int isNotTaken = dp[index + 1][sum];

            dp[index][sum] = isTaken + isNotTaken;
        }
    }

    return dp[0][0];
}
}