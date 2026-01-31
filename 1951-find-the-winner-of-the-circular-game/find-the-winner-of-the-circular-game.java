class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> ll= new ArrayList<>();
         for(int i=0;i<n;i++){
            ll.add(i);
         }
         int idx=0;
        while(ll.size()>1){
            idx=(idx+k-1)%ll.size();
            ll.remove(idx);      
        }
        return ll.get(0)+1;
    }
}