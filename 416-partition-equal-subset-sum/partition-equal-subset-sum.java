class Solution {
    public Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int e:nums){
            sum+=e;
        }
        if(sum%2!=0) return false;

        dp=new Boolean[nums.length][(sum)/2+1];
        return solve(sum/2,0,0,nums);
    }
    public boolean solve(int sum, int i, int curr, int[] nums){
        if(curr==sum) return true;
        if(i>=nums.length || curr>sum) return false;
        boolean ans=false;
        if(dp[i][curr]!=null) return dp[i][curr];
        //in
        ans = ans || solve(sum,i+1,curr+nums[i],nums);
        //ex
        ans = ans || solve(sum,i+1,curr,nums);
        return dp[i][curr]=ans;
    }
}