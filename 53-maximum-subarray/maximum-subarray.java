class Solution {
    public int maxSubArray(int[] arr) {
       int ans = Integer.MIN_VALUE;
        int sum=0;
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
            ans=Math.max(ans, sum);
            if(sum<0){
                sum=0;
            }
        }
        return ans;
    }
}