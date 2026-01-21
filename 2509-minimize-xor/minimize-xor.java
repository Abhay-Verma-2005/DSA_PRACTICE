class Solution {
    public int minimizeXor(int num1, int num2) {
        int c = 0;
        while (num2 != 0) {
            if ((num2&1) == 1) c++;
            num2 >>= 1;
        }
        int x=0;
        for(int i=30;i>=0;i--){
            int mask=(1<<i);
            if((mask & num1)!=0){
                x |=mask;
                c--;
                if(c==0){
                    return x;
                }
            }
        }
        for(int i=0;i<=30;i++){
            int mask=(1<<i);
            if((mask & num1)==0){
                x |=mask;
                c--;
                if(c==0){
                    return x;
                }
            }
        }
        return x;
    }
}
