class Solution {
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int mask = 0; mask < (1 << n); mask++) {
            int xor = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    xor ^= nums[i];
                }
            }
            sum += xor;
        }
        return sum;
    }
}
