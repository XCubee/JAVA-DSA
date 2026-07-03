class Solution{
    public void nextPermutation(int[] nums){
        int n = nums.length;
        // Find the pivot(rightmost i where nums[i] <nums[i+1])
        int i=n-2;
        while(i>=0&&nums[i]>=nums[i+1]){
            i--;
        }
        // if pivot exits find the successor and swap
        if(i>=0){
            int j=n-1;
            while(nums[j]<=nums[i]){
                j--;
            }
            // swap pivot and successor 
            int temp= nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
        // reverse the suffix starting at i+1
        int left =i+1;
        int right=n-1;
        while(left<right){
            int temp =nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
}