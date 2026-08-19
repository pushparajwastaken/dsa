public class DP16 {
    public static void main(String[] args) {
        int[] arr={3,9,7,3};
        System.out.println(minimumDifference(arr));
    }
    public static int minimumDifference(int[] arr) {
           int totalSum = 0;

        for (int num : arr) {
            totalSum += num;
        }

        int n = arr.length;
        int target = totalSum / 2;

        boolean[][] dp = new boolean[n + 1][target + 1];

        // Sum 0 is always possible
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {

            for (int sum = 1; sum <= target; sum++) {

                boolean notTake = dp[i - 1][sum];

                boolean take = false;

                if (arr[i - 1] <= sum) {
                    take = dp[i - 1][sum - arr[i - 1]];
                }

                dp[i][sum] = take || notTake;
            }
        }

        int min = Integer.MAX_VALUE;

        for (int s = 0; s <= target; s++) {

            if (dp[n][s]) {

                int difference = Math.abs(totalSum - 2 * s);

                min = Math.min(min, difference);
            }
        }

        return min;
    }
}
