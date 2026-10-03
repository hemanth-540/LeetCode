class Solution {
    public int longestValidParentheses(String s) {
        int l = 0, r = 0, len = 0;
        for (char c : s.toCharArray()) {
            if(c == '(') {
                l++;
            }
            else {
                r++;
            }
            if (l == r){
                len = Math.max(len, 2 * r);
            }
            else if(r > l) {
                l = r = 0;
            }
        }
        r = l = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                l++;
            }
            else {
                r++;
            }
            if (l == r) {
                len = Math.max(len, 2 * l);
            }
            else if(l > r){
                l = r = 0;
            }
        }
        return len;
    }
}