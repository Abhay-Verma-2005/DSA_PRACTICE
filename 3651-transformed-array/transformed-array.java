class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n=nums.length;
        int[] ans= new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int idx = ((i + nums[i]) % n + n) % n;
            ans[i]=nums[idx];
        }
        return ans;
    }
}