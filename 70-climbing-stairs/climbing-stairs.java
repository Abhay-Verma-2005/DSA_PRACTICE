class Solution {
    public int climbStairs(int n) {
        int a=0;
        int b=1;
        for(int i=0;i<n;i++){
            int t=b;
            b=a+b;
            a=t;
        }
        return b;
    }
}