class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] s=new int[nums.length];
        int[] p=new int[nums.length];
        for(int i=0;i<n;i++){
            if(i>0) s[i]=s[i-1]*nums[i-1];
            else s[i]=1;
            if(i>0) p[n-i-1]=p[n-i]*nums[n-i];
            else p[n-i-1]=1;
        }
        for(int i=0;i<n;i++){
            nums[i]=s[i]*p[i];
        }
        return nums;
    }
}