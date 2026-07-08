class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele: nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        int limit=Math.min(map.size(),k);
        if(limit<=0) return new int[0];
        PriorityQueue<Map.Entry<Integer,Integer>> pq= new PriorityQueue<>((a, b) -> a.getValue().compareTo(b.getValue()));
        for(Map.Entry<Integer,Integer> val: map.entrySet()){
            pq.add(val);
            if(pq.size()>limit) pq.poll();
        }
        int[] arr= new int[limit];
        int i=0;
        while (!pq.isEmpty()) {
            arr[i++]=pq.poll().getKey();
        }
        return arr;

    }
}