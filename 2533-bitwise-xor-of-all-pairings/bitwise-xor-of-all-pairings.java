class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int ans=0;
        if((nums1.length & 1) != 0){
            for(int e: nums2){
                ans^=e;
            }
        }
        if((nums2.length & 1) != 0){
            for(int e: nums1){
                ans^=e;
            }
        }
        return ans;
    }
}