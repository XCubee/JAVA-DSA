class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        int left = 0, right = products.length - 1;

        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);

            // Shrink left pointer past products that don't match at position i
            while (left <= right && (products[left].length() <= i || products[left].charAt(i) != c)) {
                left++;
            }
            // Shrink right pointer past products that don't match at position i
            while (left <= right && (products[right].length() <= i || products[right].charAt(i) != c)) {
                right--;
            }

            // Collect up to 3 suggestions from the valid range
            List<String> suggestions = new ArrayList<>();
            int bound = Math.min(left + 3, right + 1);
            for (int j = left; j < bound; j++) {
                suggestions.add(products[j]);
            }
            result.add(suggestions);
        }

        return result;
    }
}