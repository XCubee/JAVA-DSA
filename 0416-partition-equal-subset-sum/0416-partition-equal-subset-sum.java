class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum=0;
        for(int num:nums){
            totalSum+=num;
        }
        if(totalSum%2!=0) return false;

        int target=totalSum/2;

        int[][] memo= new int[nums.length][target+1];
        return canFind(nums,0,target,memo);
    }
    private boolean canFind(int[] nums, int index , int remaining, int[][] memo){
        if(remaining==0) return true;
        if(remaining<0|| index>=nums.length) return false;
        if(memo[index][remaining]!=0) return memo[index][remaining]==1;

        boolean result = canFind(nums,index+1,remaining-nums[index],memo) || canFind(nums,index+1,remaining,memo);
        memo[index][remaining]=result?1:-1;
        return result;
    }
}