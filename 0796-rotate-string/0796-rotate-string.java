class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        return (s + s).contains(goal); // U can also find substring using KMP/ RabinKarp/ Z algo 
    }
}