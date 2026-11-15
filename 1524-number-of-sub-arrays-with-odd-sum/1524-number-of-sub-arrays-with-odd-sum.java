class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1_000_000_007;
        int odd = 0;
        int even = 1; 
        int ans = 0;
        
        int[] prefix = new int[arr.length];
        
   
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        
      
        for (int i = 0; i < prefix.length; i++) {
            if (prefix[i] % 2 == 0) {
                ans = (ans + odd) % MOD;
                even++;
            } else {
                ans = (ans + even) % MOD;
                odd++;
            }
        }
        
        return ans;
    }
}