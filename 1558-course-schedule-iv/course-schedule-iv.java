import java.util.*;

class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] p, int[][] que) {
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] ele:p) {
            g.get(ele[0]).add(ele[1]);
        }
        HashMap<Integer,Set<Integer>> dom = new HashMap<>();
        for (int[] ele:que) {
            dom.putIfAbsent(ele[0],new HashSet<>());
        }

        for (int src:dom.keySet()) {
            HashSet<Integer> vis=new HashSet<>();
            Stack<Integer> st=new Stack<>();
            st.push(src);
            while (!st.isEmpty()) {
                int rm = st.pop();
                if (vis.contains(rm)) continue;
                vis.add(rm);
                dom.get(src).add(rm);
                for (int nei : g.get(rm)) {
                    if (!vis.contains(nei)) {
                        st.push(nei);
                    }
                }
            }
        }

        List<Boolean> ans = new ArrayList<>();
        for (int[] ele:que) {
            ans.add(dom.get(ele[0]).contains(ele[1]));
        }
        return ans;
    }
}