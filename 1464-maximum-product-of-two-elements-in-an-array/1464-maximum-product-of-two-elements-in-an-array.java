class Solution {
    public int maxProduct(int[] nums) {
        int min1=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;
        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max1){
                max2=max1;
                max1=nums[i];
                max1=max1-1;
            }
            else if(nums[i]>max2){
                max2=nums[i];
                max2=max2-1;
            }
        }
        
        
        return (max1*max2);
    }
}