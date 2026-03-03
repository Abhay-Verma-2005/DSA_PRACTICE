import java.util.*;

class Solution {
    HashMap<String, ArrayList<Pair>> g = new HashMap<>();

    public double[] calcEquation(List<List<String>> eq, double[] values, List<List<String>> queries) {

        for (int i = 0; i < values.length; i++) {
            String u = eq.get(i).get(0);
            String v = eq.get(i).get(1);

            g.putIfAbsent(u, new ArrayList<>());
            g.putIfAbsent(v, new ArrayList<>());

            g.get(u).add(new Pair(v, values[i]));
            g.get(v).add(new Pair(u, 1.0 / values[i]));
        }

        for (String key : g.keySet()) {
            HashSet<String> vis = new HashSet<>();
            dfs(key, key, 1.0, vis);
        }

        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String u = queries.get(i).get(0);
            String v = queries.get(i).get(1);

            if (!g.containsKey(u) || !g.containsKey(v)) {
                ans[i] = -1.0;
                continue;
            }

            if (u.equals(v)) {
                ans[i] = 1.0;
                continue;
            }

            double res = -1.0;

            for (Pair p : g.get(u)) {
                if (p.node.equals(v)) {
                    res = p.val;
                    break;
                }
            }

            ans[i] = res;
        }

        return ans;
    }
void dfs(String src, String curr, double val, HashSet<String> vis) {
    vis.add(curr);

    ArrayList<Pair> neighbors = new ArrayList<>(g.get(curr));

    for (Pair p : neighbors) {
        if (!vis.contains(p.node)) {
            g.get(src).add(new Pair(p.node, val * p.val));
            dfs(src, p.node, val * p.val, vis);
        }
    }
}

    public class Pair {
        String node;
        double val;

        Pair(String a, double b) {
            node = a;
            val = b;
        }
    }
}