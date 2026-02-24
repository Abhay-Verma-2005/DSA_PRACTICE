class Solution {
    public int countPaths(int n, int[][] roads) {
        long MOD = 1_000_000_007;
        List<List<long[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] r : roads) {
            graph.get(r[0]).add(new long[]{r[1], r[2]});
            graph.get(r[1]).add(new long[]{r[0], r[2]});
        }
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        long[] ways = new long[n];
        PriorityQueue<long[]> pq =new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));

        dist[0] = 0;
        ways[0] = 1;
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {

            long[] cur = pq.poll();
            int node = (int) cur[0];
            long d = cur[1];

            if (d > dist[node]) continue;

            for (long[] nei : graph.get(node)) {

                int next = (int) nei[0];
                long newDist = d + nei[1];

                if (newDist < dist[next]) {
                    dist[next] = newDist;
                    ways[next] = ways[node];
                    pq.offer(new long[]{next, newDist});
                } 
                else if (newDist == dist[next]) {
                    ways[next] = (ways[next] + ways[node]) % MOD;
                }
            }
        }

        return (int)(ways[n - 1] % MOD);
    }
}