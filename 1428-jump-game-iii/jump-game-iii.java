class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean [] vis= new boolean[arr.length];
        return dfs(arr,vis,start);
    }
    public boolean dfs(int[] arr, boolean [] vis, int st){
        if(st>arr.length-1 || st<0 || vis[st] ) return false;
        if(arr[st]==0) return true;
        vis[st]=true;
        boolean l=dfs(arr,vis,st+arr[st]);
        boolean r=dfs(arr,vis,st-arr[st]);
        return l || r;
    }
}