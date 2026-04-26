class Solution {
    int m;
    int n;
    boolean[][] vis;

    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        vis = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!vis[i][j]){
                    if(dfs(grid, i, j, -1, -1, grid[i][j])) return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] grid, int i, int j, int pi, int pj, char ch){
        if(i < 0 || j < 0 || i >= m || j >= n) return false;
        if(grid[i][j] != ch) return false;

        if(vis[i][j]) return true;

        vis[i][j] = true;

        if(!(i+1 == pi && j == pj) && dfs(grid, i+1, j, i, j, ch)) return true;
        if(!(i-1 == pi && j == pj) && dfs(grid, i-1, j, i, j, ch)) return true;
        if(!(i == pi && j+1 == pj) && dfs(grid, i, j+1, i, j, ch)) return true;
        if(!(i == pi && j-1 == pj) && dfs(grid, i, j-1, i, j, ch)) return true;

        return false;
    }
}