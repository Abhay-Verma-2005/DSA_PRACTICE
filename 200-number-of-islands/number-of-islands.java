class Solution {
    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        DSU nn = new DSU();

        for(int i = 0; i < n * m; i++){
            nn.create(i);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                if(grid[i][j] == '1'){

                    int id = i * m + j;

                    if(i + 1 < n && grid[i+1][j] == '1'){
                        nn.union(id, (i+1)*m + j);
                    }

                    if(j + 1 < m && grid[i][j+1] == '1'){
                        nn.union(id, i*m + j + 1);
                    }
                }
            }
        }

        HashSet<Node> set = new HashSet<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                if(grid[i][j] == '1'){
                    int id = i*m + j;
                    set.add(nn.find(id));
                }

            }
        }

        return set.size();
    }

    public class DSU{

        HashMap<Integer,Node> map = new HashMap<>();

        public void create(int v){
            Node nn = new Node(v);
            nn.rank = 0;
            nn.parent = nn;
            map.put(v, nn);
        }

        public Node find(int v){
            Node nn = map.get(v);

            if(nn.parent == nn) return nn;

            Node parent = find(nn.parent.val);
            nn.parent = parent;

            return parent;
        }

        public void union(int v1, int v2){

            Node p1 = find(v1);
            Node p2 = find(v2);

            if(p1 == p2) return;

            if(p1.rank == p2.rank){
                p2.parent = p1;
                p1.rank++;
            }
            else if(p1.rank > p2.rank){
                p2.parent = p1;
            }
            else{
                p1.parent = p2;
            }
        }
    }

    class Node{
        int val;
        int rank;
        Node parent;

        Node(int v){
            val = v;
        }
    }
}