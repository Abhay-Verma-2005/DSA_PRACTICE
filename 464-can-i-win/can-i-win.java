import java.util.*;

class Solution {
    Map<Integer, Boolean> memo = new HashMap<>();
    public boolean canIWin(int max, int target) {
        if (target <= 0) return true;
        int sum = (max * (max + 1)) / 2;
        if (sum < target) return false;
        return dfs(0, target, max);
    }

    boolean dfs(int used, int target, int max) {
        if (target <= 0) return false;
        if (memo.containsKey(used)) return memo.get(used);

        for (int i = 1; i <= max; i++) {
            if ((used & (1 << i)) == 0) {
                if (!dfs(used | (1 << i), target - i, max)) {
                    memo.put(used, true);
                    return true;
                }
            }
        }

        memo.put(used, false);
        return false;
    }
}