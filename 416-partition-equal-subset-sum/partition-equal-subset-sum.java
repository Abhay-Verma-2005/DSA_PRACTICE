class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int ele: nums){
            sum+=ele;
        }
        dp=new Boolean[nums.length][(sum/2)+1];
        int tar=sum;
        return solve(nums, 0, 0, sum);
    }
    public boolean solve(int[] nums, int tar, int i, int sum){
        if(i>=nums.length || tar>(sum/2)) return false;
        if(tar==sum-tar) return true;
        if(dp[i][tar]!=null) return dp[i][tar];
        // take 
        boolean a= solve(nums, tar+nums[i],i+1, sum);
        // not take
        boolean b= solve(nums, tar,i+1,sum);
        return dp[i][tar] = a || b;
    }

}