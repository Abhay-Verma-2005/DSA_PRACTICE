class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    ans++;
                    mark(grid, i, j);
                }
            }
        }
        return ans;
    }
    public void mark(char[][] grid,int i , int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length) return;
        if(grid[i][j]!='1') return;
        grid[i][j]='0';
        mark(grid,i+1,j);
        mark(grid,i-1,j);
        mark(grid,i,j-1);
        mark(grid,i,j+1);
    }
}