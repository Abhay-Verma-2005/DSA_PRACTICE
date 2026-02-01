class Solution {
    public int minimumCost(int[] nums) {
        int min=Integer.MAX_VALUE;
        int secmin=Integer.MAX_VALUE;
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]<min){
                int temp=min;
                min=nums[i];
                secmin=temp;
            }
            else if(nums[i]<secmin){
                secmin=nums[i];
            }
        }
        return secmin+min+nums[0];
    }
}