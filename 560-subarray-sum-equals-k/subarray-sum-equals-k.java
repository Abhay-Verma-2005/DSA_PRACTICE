import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] pref = new int[n + 1];
        for(int i=1; i<=n; i++){
            pref[i]=pref[i-1]+nums[i-1];
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int count=0;
        for(int i=0;i<=n;i++){
            int x=pref[i] - k;  //need
            if(map.containsKey(x)){
                count+=map.get(x);
            }
            map.put(pref[i], map.getOrDefault(pref[i],0) + 1);
        }

        return count;
    }
}