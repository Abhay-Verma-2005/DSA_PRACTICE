class Solution {
    List<List<Integer>> ans= new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        solve(nums,0,new ArrayList<>());
        return ans;
    }
    public void solve(int[] nums, int i, List<Integer> ll){
        if(i==nums.length){
            ans.add(new ArrayList<>(ll));
            return;
        }
        // not take
        solve(nums,i+1,ll);
        //take
        ll.add(nums[i]);
        solve(nums,i+1,ll);
        ll.remove(ll.size()-1);
    }
}