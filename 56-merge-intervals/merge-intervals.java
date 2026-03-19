class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> arr = new ArrayList<>();
        Arrays.sort(intervals, (a, b)->a[0]-b[0]);
        int st=intervals[0][0];
        int e=intervals[0][1];

        for(int i=1; i<intervals.length; i++){
            if(e>=intervals[i][0]){
                e=Math.max(e,intervals[i][1]);
            } 
            else{
                arr.add(new int[]{st, e});
                st = intervals[i][0];
                e = intervals[i][1];
            }
        }

        arr.add(new int[]{st, e});
        int[][] ans= new int[arr.size()][2];
        int i=0;
        for(int [] ele:arr){
            ans[i]=ele;
            i++;
        }
        return ans;
    }
}