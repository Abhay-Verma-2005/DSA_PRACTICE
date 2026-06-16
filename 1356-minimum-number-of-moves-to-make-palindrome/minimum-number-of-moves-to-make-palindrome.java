class Solution {
    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public int minMovesToMakePalindrome(String s) {
        char[] arr = s.toCharArray();
        int start = 0;
        int end = arr.length - 1;
        int ans = 0;

        while (start < end) {
            int i = end;

            while (i > start && arr[i] != arr[start]) {
                i--;
            }

            if (i == start) {
                swap(arr, start, start + 1);
                ans++;
            } else {
                while (i < end) {
                    swap(arr, i, i + 1);
                    ans++;
                    i++;
                }
                start++;
                end--;
            }
        }

        return ans;
    }
}