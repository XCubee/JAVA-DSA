class Solution {
    public String reverseStr(String s, int k) {
        // Convert the immutable string into a mutable character array
        char[] arr = s.toCharArray();
        
        // Move in chunks of 2k
        for (int i = 0; i < arr.length; i += 2 * k) {
            int left = i;
            // Reverse k characters, or whatever is left if fewer than k characters remain
            int right = Math.min(i + k - 1, arr.length - 1);
            
            // Swap the current chunk
            while (left < right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        
        // Convert the character array back into a String
        return new String(arr);
    }
}