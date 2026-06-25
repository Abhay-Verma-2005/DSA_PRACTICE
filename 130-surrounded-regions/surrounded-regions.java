class Solution {
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
         for (int i=0;i<n;i++) {
            mark(board,i,0);
            mark(board,i,m-1);
        }
        for (int j=0;j<m;j++) {
            mark(board,0,j);
            mark(board,n-1,j);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='A') board[i][j]='O';
                else board[i][j]='X';
            }
        }
        
    }
    public void mark(char[][] board,int i , int j){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length) return;
        if(board[i][j]!='O') return;
        board[i][j]='A';
        mark(board,i+1,j);
        mark(board,i-1,j);
        mark(board,i,j-1);
        mark(board,i,j+1);
    }
}