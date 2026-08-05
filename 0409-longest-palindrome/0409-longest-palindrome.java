class Solution {
    public int longestPalindrome(String s) {
        boolean isOdd=false;
        int count=0;
        HashSet<Character> set=new HashSet<>();

        for(int i=0;i<s.length();i++){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
            }
            else{
                set.remove(s.charAt(i));
                count+=2;
            }
        }
        if(!set.isEmpty()){
            return count+1;
        }
        else{
            return count;
        }
    }
}