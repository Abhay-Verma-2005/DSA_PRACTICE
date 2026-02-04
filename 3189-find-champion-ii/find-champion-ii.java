class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] graph= new int[n];
        for(int[] ele:edges){
            graph[ele[1]]++;
        }
        int res= -1;
        int count=0;

        for (int i = 0; i < n; i++) {
            if (graph[i]==0) {
                res=i;
                count++;
            }
        }
        return count==1 ? res:-1;
    }
}