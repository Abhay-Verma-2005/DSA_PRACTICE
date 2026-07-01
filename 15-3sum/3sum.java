class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);// O(nlogn)
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int l=i+1;
            int r=n-1;
            while(l<r){
                    int curr=nums[i]+nums[l]+nums[r];
                    if(curr<0){
                        l++;
                    }
                    else if(curr>0){
                        r--;
                    }
                    else{
                        List<Integer> ans = new ArrayList<>();
                        ans.add(nums[i]);
                        ans.add(+nums[l]);
                        ans.add(nums[r]);
                        result.add(ans);
                        while(l<r && nums[l]==nums[l+1]) l++;
                        while(l<r && nums[r]==nums[r-1]) r--;
                        l++;
                        r--;

                    }
                }
            }
    return result;
    }
}