class Solution {
        public boolean isMatch(String s, String p) {
        boolean[][] cache = new boolean[s.length() + 1][p.length() + 1];
        
        return dfs(s, p, 0, 0, cache);
    }
    
    public boolean dfs(String s, String p, int i, int j, boolean[][] cache) {
        if (i < s.length() && j < p.length() && cache[i][j]) return cache[i][j];
        
        if (i >= s.length() && j >= p.length()) return true;
        if (j >= p.length()) return false;
        
        boolean match = ( i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') );
        if (j + 1 < p.length() && p.charAt(j+1) == '*') {
            cache[i][j] = dfs(s, p, i, j+2, cache) || (match && dfs(s, p, i+1, j, cache)); // use * and don't use *
            return cache[i][j];
        }
        if (match) {
            cache[i][j] = dfs(s, p, i+1, j+1, cache);
            return cache[i][j];
        }
        cache[i][j] = false;
        return cache[i][j];
    }
}