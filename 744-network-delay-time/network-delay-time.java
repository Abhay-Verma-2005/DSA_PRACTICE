class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<HashMap<Integer,Integer>> g= new ArrayList<>();
        for(int i=0;i<=n;i++){
            g.add(new HashMap<Integer,Integer>());
        }
        for(int [] ele: times){
            g.get(ele[0]).put(ele[1],ele[2]);
        }
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->a.cost-b.cost);
        pq.add(new Pair(k,0));
        int ans=-1;
        HashSet<Integer> vis= new HashSet<>();
        while(!pq.isEmpty()){
            Pair rm= pq.poll();
            int v=rm.vtx;
            int cost=rm.cost;
            if(vis.contains(v)) continue;
            vis.add(v);
            ans=Math.max(cost,ans);
            for(int ng:g.get(v).keySet()){
                if(!vis.contains(ng)){
                    int newCost=cost+g.get(v).get(ng);
                    pq.add(new Pair(ng,newCost));
                }
            }
        }
        if(vis.size()!=n) return -1;
        return ans;
    }
    public class Pair{
        int vtx;
        int cost;
        public Pair(int v, int d){
            vtx=v;
            cost=d;
        }
    }
}