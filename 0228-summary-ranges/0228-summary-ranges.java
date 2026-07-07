class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int n = nums.length;
        if (n == 0) {
            return result;
        }

        int start = nums[0];
        for (int i = 1; i < n; i++) {
            // Boundary: previous element closed a range
            if (nums[i] != nums[i - 1] + 1) {
                addRange(result, start, nums[i - 1]);
                start = nums[i];
            }
        }
        // Final open range ends at the last element
        addRange(result, start, nums[n - 1]);

        return result;
    }

    private void addRange(List<String> result, int start, int end) {
        if (start == end) {
            result.add(String.valueOf(start));
        } else {
            result.add(start + "->" + end);
        }
    }
}