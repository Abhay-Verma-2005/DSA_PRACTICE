class Solution {
    public int countPrimeSetBits(int left, int right) {
        int d=0;
        HashSet<Integer> h=new HashSet<>(Arrays.asList(2,3,5,7,11,13,17,19,23,29,31));
        for(int j=left;j<=right;j++){
            int a=0;
            int i=j;
            while(i>0){
                if(i%2==1){
                    a++;
                }
                i/=2;
            }
            if(h.contains(a)) d++;
        }
        return d;
    }
}