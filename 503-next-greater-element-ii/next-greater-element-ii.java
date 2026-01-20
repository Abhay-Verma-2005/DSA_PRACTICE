class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st= new Stack<>();
        int[] ans= new int[nums.length];
        st.push(0);
        for(int i=1;i<nums.length;i++){
            while(!st.isEmpty() && nums[i]>nums[st.peek()]) ans[st.pop()]=nums[i];
            st.push(i);
        }
        while(!st.isEmpty()){
            int val=st.pop();
            ans[val]=check(nums,nums[val]);
        }
        return ans;
    }
    public int check(int[] nums ,int val){
        for(int i=0;i<2*nums.length;i++){
            if(nums[i%nums.length]>val){
                return nums[i%nums.length];
            }
        }
        return -1;
    }
}