class Solution {
    public int numSub(String s) {
        int MOD = 1_000_000_007; // 10^9 + 7
        int count =0;
        int streak =0;
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                streak++;
                count=(count+streak)% MOD;
            }
            else{
                streak=0;
            }
        }
        return count;
    }
}