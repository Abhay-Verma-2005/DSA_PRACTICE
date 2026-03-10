class Solution {
    public int longestOnes(int[] nums, int k) {
        int s=0;
        int f=0;
        int l=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) f++;
            while(f>k){
                if(nums[s]==0){
                    f--;
                }
                s++;
            }
            l=Math.max(l,i-s+1);
        }
        return l;
    }
}