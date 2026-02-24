class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        boolean[][] vis= new boolean[n][m];
        dfs(image,sr,sc,color,image[sr][sc],vis);
        return image;
    }
    public void dfs(int[][] grid, int r, int c, int k,int y,boolean [][] vis){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length) return;
        if(grid[r][c]!=y) return;
        if(vis[r][c]) return;
        grid[r][c]=k;
        vis[r][c]=true;
        // up
        dfs(grid,r-1,c,k,y,vis); 
        // down
        dfs(grid,r+1,c,k,y,vis); 
        // left
        dfs(grid,r,c-1,k,y,vis); 
        // rigth
        dfs(grid,r,c+1,k,y,vis); 
    }
}