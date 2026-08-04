class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;

        int jumps = 0;
        int currentJumpEnd = 0;
        int farthest = 0;

        // Traverse up to the second-to-last element
        for (int i = 0; i < nums.length - 1; i++) {
            // Keep track of the farthest index you can reach
            farthest = Math.max(farthest, i + nums[i]);

            // When you reach the end of the current jump coverage
            if (i == currentJumpEnd) {
                jumps++;
                currentJumpEnd = farthest;
                
                // If the current jump can already reach or pass the last index, break early
                if (currentJumpEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }
}