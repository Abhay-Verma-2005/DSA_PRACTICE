import java.util.*;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] id = new int[n];
        Arrays.fill(dp, 1);
        for (int i=0;i<n;i++) id[i] = i;

        for (int i=1;i<n;i++) {
            for (int j=0; j<i; j++) {
                if (nums[i]%nums[j]==0 && dp[j]+1>dp[i]) {
                    dp[i]=dp[j]+1;
                    id[i]=j;
                }
            }
        }

        int maxLen=0, idx=0;
        for (int i=0;i<n;i++) {
            if (dp[i]>maxLen) {
                maxLen=dp[i];
                idx=i;
            }
        }

        List<Integer> res = new ArrayList<>();
        while (id[idx] != idx) {
            res.add(nums[idx]);
            idx = id[idx];
        }
        res.add(nums[idx]);
        return res;
    }
}