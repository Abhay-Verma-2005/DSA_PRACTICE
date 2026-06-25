class Solution {
    int ans=Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,-1);
        solve(coins,amount,0,dp);
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
    public void solve(int[] coins, int amt, int cnt,int[] dp ){
        if(amt==0){
            ans=Math.min(ans,cnt);
            return;
        }
        if(amt<0) return;
        if(dp[amt]!=-1 && dp[amt]<=cnt) return;
        dp[amt]=cnt;
        if(dp[amt]!=-1)
        for(int ele: coins){
            solve(coins, amt-ele,cnt+1,dp);
        }
    }
}