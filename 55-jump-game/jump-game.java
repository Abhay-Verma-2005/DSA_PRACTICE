class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int goal=0;
        for(int curr=nums.length-1;curr>=0;curr--){
            if(curr+nums[curr]>=goal){
                goal=curr;
            }
        }
        return goal==0;
    }
}