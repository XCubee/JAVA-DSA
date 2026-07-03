class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        
        // 1. Build the prefix products directly inside the 'ans' array
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        
        // 2. Calculate suffix product on the fly and multiply it into 'ans'
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = ans[i] * suffix; // Multiply left product by current right product
            suffix *= nums[i];        // Update the running suffix product for the
        }
        
        return ans;
    }
}