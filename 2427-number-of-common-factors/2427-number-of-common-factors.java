class Solution {
    public int commonFactors(int a, int b) {
        int y = (a>b)? a: b ;
        int count =0;
        for(int i=1;i<=y;i++){
            if((a%i==0 && b%i==0)){
                count++;
            }
        }
        return count;
    }
}