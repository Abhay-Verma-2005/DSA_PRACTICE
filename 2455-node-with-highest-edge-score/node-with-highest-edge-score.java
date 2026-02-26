class Solution {
    public int edgeScore(int[] edges) {
        int n=edges.length;
        long[] arr= new long[n];
        for(int i=0;i<n;i++){
            arr[edges[i]]+=i;
        }
        int max=0;
        for(int i=0;i<n;i++){
            if(arr[max]<arr[i]){
                max=i;
            }
        }
        return max;
    }
}