class Solution {
    public int minCostConnectPoints(int[][] points) {

        ArrayList<HashMap<Integer,Integer>> g = new ArrayList<>();
        int n = points.length;

        for(int i=0;i<n;i++){
            g.add(new HashMap<>());
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){

                int cost = Math.abs(points[j][0]-points[i][0]) +
                           Math.abs(points[j][1]-points[i][1]);

                g.get(i).put(j,cost);
                g.get(j).put(i,cost);
            }
        }

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a,b)->a.cost-b.cost);

        HashSet<Integer> vis = new HashSet<>();

        pq.add(new Pair(0,0,0));

        int sum=0;

        while(!pq.isEmpty()){

            Pair rm = pq.poll();
            int v = rm.vtx;
            int c = rm.cost;

            if(vis.contains(v)) continue;

            vis.add(v);
            sum += c;

            for(int ng : g.get(v).keySet()){
                if(!vis.contains(ng)){
                    int cost = g.get(v).get(ng);
                    pq.add(new Pair(ng,v,cost));
                }
            }
        }

        return sum;
    }

    public class Pair{

        int vtx;
        int acq;
        int cost;

        public Pair(int a,int b,int c){
            vtx=a;
            acq=b;
            cost=c;
        }
    }
}