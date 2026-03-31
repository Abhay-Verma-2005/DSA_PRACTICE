import java.util.*;

class Solution {
    int[] tree;
    int n;

    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        List<Integer> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int x : nums) set.add(x);

        List<Integer> sorted = new ArrayList<>(set);
        Collections.sort(sorted);

        int size = sorted.size();
        n = size;
        tree = new int[4 * n];

        for (int i = 0; i < size; i++) {
            map.put(sorted.get(i), i);
        }

        for (int i = len - 1; i >= 0; i--) {
            int idx = map.get(nums[i]);
            int count = query(0, n - 1, 0, idx - 1, 1);
            ans.add(count);
            update(0, n - 1, idx, 1);
        }

        Collections.reverse(ans);
        return ans;
    }

    int query(int l, int r, int ql, int qr, int node) {
        if (ql > r || qr < l) return 0;
        if (ql <= l && r <= qr) return tree[node];
        int mid = (l + r) / 2;
        return query(l, mid, ql, qr, 2 * node) + query(mid + 1, r, ql, qr, 2 * node + 1);
    }

    void update(int l, int r, int idx, int node) {
        if (l == r) {
            tree[node]++;
            return;
        }
        int mid = (l + r) / 2;
        if (idx <= mid) update(l, mid, idx, 2 * node);
        else update(mid + 1, r, idx, 2 * node + 1);
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }
}