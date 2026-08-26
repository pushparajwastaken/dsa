public class DP18{
    public static void main(String[] args) {
        int []arr={5,2,6,4};
        int diff=3;
        int totalSum=0;
        for(int i=0;i<arr.length;i++){
            totalSum+=arr[i];
        }
        if(totalSum<diff){
            System.out.println("0");
        }
        if((totalSum-diff)%2!=0){
            System.out.println("0");
        }
        System.out.println(countPartitions(arr,(totalSum-diff)/2));
    }
    public static int countPartitions(int[] arr,int target) {

        int n=arr.length;
        int[][]dp=new int[n+1][target+1];
        for(int i=0;i<=n;i++){
            dp[i][target]=1;
        }
        for(int index=n-1;index>=0;index--){
            for(int sum=target-1;sum>=0;sum--){
                int isTaken=0;
                if(sum+arr[index]<=target){
                    isTaken=dp[index+1][sum+arr[index]];
                }
                int isNotTaken = dp[index + 1][sum];

            dp[index][sum] = isTaken + isNotTaken;
            }
        }
        return dp[0][0];
    }
}