class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int a=0;
        int b=0;
        int n=costs.length/2;
        int ans=0;
        Arrays.sort(costs, (x, y) -> Integer.compare((y[0] - y[1]),(x[0] - x[1])));
        for (int i = 0; i < n; i++) {
            ans += costs[i][1];
        }
        for (int i = n; i < 2*n; i++) {
            ans += costs[i][0];
        }
        return ans;
    }
}