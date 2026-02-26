class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        ArrayList<ArrayList<Pair>> g= new ArrayList<>();
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
        }
        for(int[] ele:edges){
            g.get(ele[0]).add(new Pair(ele[1],ele[2]));
            g.get(ele[1]).add(new Pair(ele[0],ele[2]));
        }
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->Integer.compare(a.curr,b.curr));
        int[] ans= new int[n];
        Arrays.fill(ans,-1);
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair rm= pq.poll();
            int vtx=rm.val;
            int curr=rm.curr;
            if(ans[vtx] != -1 || curr>=disappear[vtx]) continue;
            ans[vtx]=curr;
            for(Pair ele: g.get(vtx)){
                int k=curr+ele.curr;
                if(ans[ele.val]==-1 && k<disappear[ele.val]){
                    pq.add(new Pair(ele.val,k));
                }
            }
        }
        return ans;
        
    }
    class Pair{
        int val;
        int curr;
        public Pair(int a, int b){
            val=a;
            curr=b;
        }
    }
}