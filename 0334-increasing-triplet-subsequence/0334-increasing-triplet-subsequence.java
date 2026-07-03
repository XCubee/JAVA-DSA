
    class Solution {
    public boolean increasingTriplet(int[] nums) {
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;

        
        for (int num : nums) {
            if (x >= num)
                x = num;
            else if (y >= num)
                y = num;
            else
                return true;
        }

        
        return false;
    }
}
        
