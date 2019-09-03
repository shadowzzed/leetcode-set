package solution;

/**
 * @author Zeluo
 * @date 2019/9/3 10:15
 */
public class Solution {
    public String countAndSay(int n) {
        if (n==1) return "1";
        String str = countAndSay(n-1);
        char[] cur = str.toCharArray();
        char tmp = cur[0];
        StringBuilder sb = new StringBuilder();
        int count =0;
        for (char c: cur) {
            if (c != tmp) {
                sb.append(count);
                sb.append(tmp);
                tmp = c;
                count = 1;
            } else {
                count++;
            }
        }
        sb.append(count);
        sb.append(tmp);
        return sb.toString();
    }

}
