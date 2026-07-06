class Solution {
    public int removeCoveredIntervals(int[][] intervals) {

        int ans = 0;
        int n = intervals.length;

        for (int i = 0; i < n; i++) {

            int s1 = intervals[i][0];
            int e1 = intervals[i][1];

            boolean flag = false;

            for (int j = 0; j < n; j++) {
                int s2 = intervals[j][0];
                int e2 = intervals[j][1];

                if (i != j && s1 >= s2 && e2 >= e1) {
                    flag = true;
                    break;
                }

            }

            if (!flag) {
                ans++;
            }
        }

        return ans;

    }
}