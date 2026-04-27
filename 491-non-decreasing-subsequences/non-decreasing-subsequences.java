class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        HashSet<List<Integer>> set= new HashSet<>();
        List<Integer> ll= new ArrayList<>();
        solve(nums, set, ll, 0);
        return new ArrayList<>(set);
    }
    public void solve(int[] arr,HashSet<List<Integer>> set,List<Integer> ll,int idx){
        if(ll.size()>=2){ 
            set.add(new ArrayList<>(ll));
        }
        for(int i=idx;i<arr.length;i++){
            if(ll.size()==0 || ll.get(ll.size()-1)<=arr[i]){
                ll.add(arr[i]);
                solve(arr,set,ll,i+1);
                ll.remove(ll.size()-1);
            }
        }
    }
}