class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] l_max= new int[n];
        int[] r_max= new int[n];
        l_max[0]=height[0];
        r_max[n-1]=height[n-1];
        for(int i=1;i<n;i++){
            l_max[i]=Math.max(height[i],l_max[i-1]);
            r_max[n-i-1]=Math.max(r_max[n-i],height[n-i-1]);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=Math.min(l_max[i],r_max[i])-height[i];
        }
        return ans;
    }
}