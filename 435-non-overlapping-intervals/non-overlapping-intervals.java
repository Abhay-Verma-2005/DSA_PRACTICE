class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int c=0;
        int prev=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(prev<=intervals[i][0]){
                c++;
                prev=intervals[i][1];
            }
        }
        return n-c-1;
    }
}