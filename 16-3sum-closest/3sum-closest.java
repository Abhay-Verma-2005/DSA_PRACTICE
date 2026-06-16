class Solution {
    public int threeSumClosest(int[] arr, int target) {
        Arrays.sort(arr);
        int ans= arr[0] + arr[1] + arr[2];;
        for(int i=0;i<arr.length;i++){
            int l=i+1;
            int r=arr.length-1;
            while(l<r){
                int sum=(arr[i]+arr[l]+arr[r]);
                if (Math.abs(target-sum)<Math.abs(target-ans)) {
                    ans = sum;
                }
                if(sum==target){
                    return sum;
                }
                else if(sum>target){
                    r--;
                }
                else{
                    l++;
                }

            }
        }
        return ans;
    }
}