class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int limit=0;
        for(int i=0;i<nums.length;i++){
            if(i!=nums.length-1 && limit+nums[i]<=i) return false;
            limit=Math.max(i+nums[i],limit);
        }
        return true;
    }
}