class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int ans=0;
        for(int e:nums){
            if(i%2==0){
                ans+=e;
            }
            i++;
        }
        return ans;
    }
}
