class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e: edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        Queue<Integer> q=new LinkedList<>();
        HashSet<Integer> visited=new HashSet<>();
        q.add(source);
        while(!q.isEmpty()){
            // remove
            int node=q.poll();
            // ignore
            if(visited.contains(node)){
                continue;
            }
            // mark visited
            visited.add(node);
            // selft work
            if(node==destination){
                return true;
            }
            // addd neighbours
            for(int ele: graph.get(node)){
                if(!visited.contains(ele)){
                    q.add(ele);
                }
            }
        }
        return false;

    }
}