class Solution {
    public int maxProfit(int[] prices) {
        int min=0;
        int ans=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<prices[min]){
                min=i;
            }
            ans=Math.max(ans,prices[i]-prices[min]);
        }
        return ans;
    }
}