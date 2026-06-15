class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] s=new int[nums.length];
        int[] p=new int[nums.length];
        s[0]=1;
        p[n-1]=1;
        for(int i=1;i<n;i++){
            s[i]=s[i-1]*nums[i-1];
            p[n-i-1]=p[n-i]*nums[n-i];
            
        }
        for(int i=0;i<n;i++){
            nums[i]=s[i]*p[i];
        }
        return nums;
    }
}