class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int ans=0;
        boolean[][] vis= new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    ans++;
                    mark(grid, i, j, vis);
                }
            }
        }
        return ans;
    }
    public void mark(char[][] grid,int i , int j, boolean[][] vis){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length) return;
        if(grid[i][j]!='1') return;
        if(vis[i][j]) return;
        vis[i][j]=true;
        mark(grid,i+1,j,vis);
        mark(grid,i-1,j,vis);
        mark(grid,i,j-1,vis);
        mark(grid,i,j+1,vis);
    }
}