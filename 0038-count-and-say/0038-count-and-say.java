import java.util.regex.*;
class Solution {
    public String countAndSay(int n) {
        String current = "1";

        for (int step = 1; step < n; step++) {
            StringBuilder next = new StringBuilder();
            // Match runs of consecutive identical characters
            Matcher matcher = Pattern.compile("(.)\\1*").matcher(current);

            while (matcher.find()) {
                String run = matcher.group();
                next.append(run.length());
                next.append(run.charAt(0));
            }

            current = next.toString();
        }

        return current;
    }
}