class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(0,0,nums,target);
    }
    public int solve(int i, int sum,int[] nums, int t){
        if(i==nums.length && sum==t) return 1;
        if(i>= nums.length) return 0;
        int plus= solve(i+1,sum+nums[i],nums, t);
        int minus= solve(i+1,sum-nums[i],nums, t);
        return plus+minus;

    }
}