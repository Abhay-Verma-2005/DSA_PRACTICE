
class Solution {
    public int findCircleNum(int[][] g) {
        int c=0;
        int n=g.length;
        boolean[] vis = new boolean[n];
        Stack<Integer> st = new Stack<>();

        for (int i=0;i<n;i++) {
            if (!vis[i]) {
                c++;
                st.push(i);
                while (!st.isEmpty()) {
                    int rm=st.pop();
                    if (vis[rm]) continue;
                    vis[rm] = true;
                    for (int j=0;j<n;j++) {
                        if (g[rm][j]==1 && !vis[j]) {
                            st.push(j);
                        }
                    }
                }
            }
        }
        return c;
    }
}