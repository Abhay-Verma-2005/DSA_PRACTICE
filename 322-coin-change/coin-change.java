class Solution {
    int ans=Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        int[] dp= new int[amount+1];
        Arrays.fill(dp,-1);
        solve(coins,amount,0,dp);
        if(ans==Integer.MAX_VALUE) ans=-1;
        return ans;
    }
    public void solve(int[] coins, int amt , int curr, int[]dp){
        if(amt==0){
            ans=Math.min(ans,curr);
            return;
        }
        if(curr>=ans) return;
        if(dp[amt]!=-1 && dp[amt]<=curr) return;
        dp[amt]=curr;
        for(int i:coins) {
            if(amt >= i){
                solve(coins, amt-i,curr+1,dp);
            }
        }
    }
}