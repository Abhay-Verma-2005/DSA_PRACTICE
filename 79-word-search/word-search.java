class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0)){
                    boolean [][] visited= new boolean[n][m];
                    if (solve(board, i, j, 0, word, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean solve(char[][] board,int i, int j,int idx, String word, boolean [][] visited){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length) return false;
        if(board[i][j]!=word.charAt(idx) || visited[i][j]) return false;
        if (idx == word.length()-1) return true;

        visited[i][j]=true;

        boolean d=solve(board,i+1,j,idx+1,word,visited);
        boolean u=solve(board,i-1,j,idx+1,word,visited);
        boolean l=solve(board,i,j-1,idx+1,word,visited);
        boolean r=solve(board,i,j+1,idx+1,word,visited);
        visited[i][j]=false;
        return d || r || u || l || r;
    }        
} 