class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 4) {
            return false;
        }
        int[] arr = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                arr[i] = 1;
            } else if (nums[i] > nums[i + 1]) {
                arr[i] = -1;
            } else {
                arr[i] = 0;
            }
        }
        int i = 0;
        while (i < arr.length && arr[i] == 1)
            i++;
        if (i == 0)
            return false;
        int p = i;
        while (i < arr.length && arr[i] == -1)
            i++;
        if (p == i)
            return false;
        int q = i;
        while (i < arr.length && arr[i] == 1)
            i++;
        if (q == i)
            return false;
        if(i < n-1) return false;
        return true;

    }
}