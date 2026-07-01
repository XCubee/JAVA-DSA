class Solution {
    public int countPrimes(int n) {
        if(n<=2) return 0;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime,true);
        isPrime[0]=false;
        isPrime[1]=false;

        for(int p =2 ; p*p<n;p++){
            if(isPrime[p]){
                for(int j =p*p ;j<n;j+=p){
                    isPrime[j]=false;
                }
            }
        }
        int count =0;
        for(boolean prime : isPrime){                            
            if(prime){
                count++;
            }
        }
        return count;
    }
}