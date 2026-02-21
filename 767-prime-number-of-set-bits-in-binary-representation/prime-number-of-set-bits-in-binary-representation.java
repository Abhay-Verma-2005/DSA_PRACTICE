class Solution {
    HashSet<Integer> h=new HashSet<>(Arrays.asList(2,3,5,7,11,13,17,19,23,29,31));
    public int countPrimeSetBits(int left, int right) {
        int c = 0;
        for (int i = left; i <= right; i++) {
            int bits = Integer.bitCount(i);
            if (isPrime(bits)) {
                c++;
            }
        }
        return c;
    }
    private boolean isPrime(int n) {
        
        if(h.contains(n)) return true;
        return false;
    }
}