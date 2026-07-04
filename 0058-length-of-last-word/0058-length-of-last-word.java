class Solution {
    public int lengthOfLastWord(String s) {
        String t =s.trim();
        int i=t.length()-1;
        int count =0;
        
        while(i>=0 && t.charAt(i)!=' '){
            count++;
            i--;
        }
        while(i>=0 && t.charAt(i)==' '){
            i--;
            continue;
           
        }
    return count;
    }
}