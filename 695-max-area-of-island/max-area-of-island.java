class Solution {
    int ans=0;
    int c;
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    c=0;
                    mark(grid, i, j);
                    ans=Math.max(c,ans);
                }
            }
        }
        return ans;
    }
    public void mark(int[][] grid,int i , int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length) return;
        if(grid[i][j]!=1) return;
        grid[i][j]=0;
        c++;
        mark(grid,i+1,j);
        mark(grid,i-1,j);
        mark(grid,i,j-1);
        mark(grid,i,j+1);
    }
}