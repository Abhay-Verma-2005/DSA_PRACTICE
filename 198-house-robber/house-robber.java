class Solution {
    public int rob(int[] nums) {
        int[] dp =new int[nums.length];
        Arrays.fill(dp,-1);
        return Math.max(Robber(nums,0,dp),Robber(nums,1,dp));
    }
    public static int Robber(int[] arr, int i,int[] dp){
        if(i>=arr.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int rob = arr[i]+Robber(arr,i+2,dp);
        int dontrob = Robber(arr,i+1,dp);
        return dp[i]= Math.max(rob,dontrob);
    }
}