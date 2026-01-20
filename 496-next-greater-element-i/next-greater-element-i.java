class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans= new int[nums1.length];
        Arrays.fill(ans,-1);
        int i=0;
        for(int e:nums1){
            boolean flg=false;
            for(int v:nums2){
                if(e==v){
                    flg=true;
                }
                if(flg){
                    if(v>e){
                        ans[i]=v;
                        break;
                    }
                }
            }
            i++;
        }
        return ans;
    }
}