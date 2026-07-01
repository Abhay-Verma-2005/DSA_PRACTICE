class Solution {
    public int longestCommonSubsequence(String s, String p) {
        int [][] dp = new int[s.length()][p.length()];
        for(int[] ele:dp){
            Arrays.fill(ele,-1);
        }
        return lcs(s,p,0,0,dp);
    }
    public int lcs(String s, String p, int i , int j,int [][] dp){
        if(i>=s.length() || j>=p.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==p.charAt(j)){
            return 1+lcs(s,p,i+1,j+1,dp);
        }
        return dp[i][j]=Math.max(lcs(s,p,i+1,j,dp),lcs(s,p,i,j+1,dp));
    }
}