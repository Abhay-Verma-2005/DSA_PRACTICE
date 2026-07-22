class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        int ans1= Hrob(nums,1,n-1);
        int ans2= Hrob(nums,2,n);
        return Math.max(ans1,ans2);
    }
     public int Hrob(int[] nums, int st, int n) {
        if(n==0) return 0;
        int[] dp= new int[n+1];
        dp[st-1]=0;
        dp[st]=nums[st-1];
        for(int i=st;i<n;i++){
            dp[i+1]=Math.max(dp[i],nums[i]+dp[i-1]);
        }
        return dp[n];
    }
}