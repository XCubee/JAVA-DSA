class Solution {
    public int maxProduct(int n) {
        int firstMax=Integer.MIN_VALUE;
        int secondMax=Integer.MIN_VALUE;
        while(n>0){
            int digit=n%10;
            if(digit>=firstMax){
                secondMax=firstMax;
                firstMax=digit;
            }
            else if(digit>=secondMax){
                secondMax=digit;
            }
            n=n/10;
        }
        return firstMax*secondMax;
        
    }
}