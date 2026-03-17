class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DSU nn = new DSU();
        int n = edges.length;
        for(int i = 0; i < n; i++){
            nn.create(i);
        }

        for(int[] ele : edges){
            int u = ele[0] - 1;
            int v = ele[1] - 1;

            if(nn.find(u) == nn.find(v)){
                return ele;
            }

            nn.union(u, v);
        }

        return new int[0];
    }
    public class Node{
        int val;
        int rank;
        Node parent;
        public Node(int v){
            val=v;
            rank=0;
            parent=this;
        }
    }
    public class DSU{
        HashMap<Integer,Node> map= new HashMap<>();
        public void create(int v){
            Node nn= new Node(v);
            map.put(v,nn);
        }
        public Node find(int v){
            Node nn= map.get(v);
            if(nn.parent==nn) return nn;
            Node parent= find(nn.parent.val);
            nn.parent=parent;
            return parent;
        }
        public void union(int v1, int v2){
            Node p1= find(v1);
            Node p2= find(v2);
            if(p1==p2) return;
            if(p1.rank==p2.rank){
                p1.rank++;
                p2.parent=p1;
            }
            else if(p1.rank>p2.rank){
                p2.parent=p1;
            }
            else{
                p1.parent=p2;
            }
        }
    }
}