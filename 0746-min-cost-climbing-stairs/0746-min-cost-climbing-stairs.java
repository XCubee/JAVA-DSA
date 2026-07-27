class Solution {
      private int[] memo;
    public int minCostClimbingStairs(int[] cost) {
      
        memo=new int[cost.length];
        Arrays.fill(memo,-1);
        return Math.min(minCost(cost,0),minCost(cost,1));
    }
    private int minCost(int[] cost, int i ){
        if(i>=cost.length) return 0;
        if(memo[i]!=-1)return memo[i];
        memo[i]=cost[i]+Math.min(minCost(cost,i+1),minCost(cost,i+2));
        return memo[i];
    }
}