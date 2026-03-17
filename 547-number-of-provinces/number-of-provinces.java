class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
         DSU dsu = new DSU();
        for(int i = 0; i < n; i++){
            dsu.create(i);
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1){
                    dsu.union(i, j);
                }
            }
        }
        HashSet<Node> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(dsu.find(i));
        }
        return set.size();
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
        HashMap<Integer,Node> map=new HashMap<>();
        public void create(int v){
            Node nn= new Node(v);
            map.put(v,nn);
        }
        public Node find(int v){
            Node nn= map.get(v);
            if(nn.parent==nn) return nn;
            Node rankparent=find(nn.parent.val);
            nn.parent=rankparent;
            return rankparent;
        }
        public void union(int v1, int v2){
            Node p1=find(v1);
            Node p2=find(v2);
            if(p1==p2) return;
            if(p1.rank==p2.rank){
                p1.rank++;
                p2.parent=p1;
            }
            else if(p1.rank<p2.rank){
                p1.parent=p2;
            }
            else{
                p2.parent=p1;
            }
        }
    }

}