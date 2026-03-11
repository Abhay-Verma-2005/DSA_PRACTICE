class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int s=0;
        int sum=0;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            while(sum>=target){
                ans=Math.min(ans,i-s+1);
                sum-=nums[s];
                s++;
            }
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
}