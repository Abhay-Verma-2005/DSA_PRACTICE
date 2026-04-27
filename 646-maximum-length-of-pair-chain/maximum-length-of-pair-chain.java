class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[1]-b[1]);
        int ans=0;
        int curr= Integer.MIN_VALUE;
        for(int i=0;i<pairs.length;i++){
            if(curr<pairs[i][0]){
                curr=pairs[i][1];
                ans++;
            }
            
        }
        return ans;
    }
}