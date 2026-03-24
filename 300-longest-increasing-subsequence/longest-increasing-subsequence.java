class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> vis= new ArrayList<>();
        for(int ele: nums){
            lowerBound(ele,vis);
        }
        return vis.size();
    }
    public void lowerBound(int val,ArrayList<Integer> vis){
        int st=0;
        int en=vis.size();
        while(st<en){
            int mid= (st+en)/2;
            if(val<=vis.get(mid)){
                en=mid;
            }
            else{
                st=mid+1;
            }
        }
        if(st==vis.size()){
            vis.add(val);
        }
        vis.set(st,val);
    }
}