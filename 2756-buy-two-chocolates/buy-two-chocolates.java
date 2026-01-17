class Solution {
    public int buyChoco(int[] prices, int money) {
        int m1=Integer.MAX_VALUE;
        int m2=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            int x=prices[i];
            if(x<=m1){
                m2=m1;
                m1=x;
            }
            if(x>m1 && x<m2){
                m2=x;
            }
        }
        if(m1+m2 > money) return money;
        return money-(m1+m2);
    }
}