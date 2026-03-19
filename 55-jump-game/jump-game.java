class Solution {
    public boolean canJump(int[] nums) {
        int goal=0;
        for(int curr=0;curr<nums.length;curr++){
            if(goal<curr){
                return false;
            }
            goal = Math.max(goal, curr + nums[curr]);
        }
        return true;
    }
}