class Solution {
    public int jump(int[] nums) {
        int n=nums.length-1;
        int limit=0;
        int j=0;
        int far=0;
        for(int i=0;i<n;i++){
            far=Math.max(far,i+nums[i]);
            
            if(i==limit){
                j++;
                limit=far;
            }
        }
        return j;

    }
}