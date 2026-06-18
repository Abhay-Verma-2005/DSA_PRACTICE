class Solution {
    public int majorityElement(int[] nums) {
        int curr=nums[0];
        int c=0;
        for(int i=0;i<nums.length;i++){
            if(curr==nums[i]){
                c++;
            }
            else{
                if(c>0){
                    c--;
                }
                else{
                    curr=nums[i];
                    c++;
                }
            } 
        }
        return curr;
    }
}