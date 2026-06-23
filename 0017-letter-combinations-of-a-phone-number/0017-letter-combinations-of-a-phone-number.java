class Solution {
    // Moved mappings out here so both methods can access it
    private static final String[] MAPPING = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        getCombinations(digits, 0, new StringBuilder(), res);
        return res;
    }

    private void getCombinations(String digits, int index, StringBuilder currentPath, List<String> res) {
        if (index == digits.length()) {
            res.add(currentPath.toString());
            return;
        }
        
        // Correctly references the class-level array
        String letters = MAPPING[digits.charAt(index) - '0'];

        for (int i = 0; i < letters.length(); i++) {
            char c = letters.charAt(i); // Fixed the typo here: chatAt -> charAt

            currentPath.append(c);
            getCombinations(digits, index + 1, currentPath, res);
            currentPath.deleteCharAt(currentPath.length() - 1);
        }
    }
}