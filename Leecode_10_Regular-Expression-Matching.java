//recursion
class Solution {
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();
        boolean first_match = (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));

        if(p.length() >= 2 && p.charAt(1) == '*'){
            return (isMatch(s, p.substring(2))||(first_match && isMatch(s.substring(1), p)));
        }
        else{
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }
}
//Dynamic Programming
class Solution {
    public:
        bool isMatch(string s, string p) {
            int m = s.size(), n = p.size();
            vector<vector<bool>> dp(m + 1, vector<bool>(n + 1, false));
            dp[0][0] = true;
            for (int i = 0; i <= m; ++i) {
                for (int j = 1; j <= n; ++j) {
                    if (j > 1 && p[j - 1] == '*') {
                        dp[i][j] = dp[i][j - 2] || (i > 0 && (s[i - 1] == p[j - 2] || p[j - 2] == '.') && dp[i - 1][j]);
                    } else {
                        dp[i][j] = i > 0 && dp[i - 1][j - 1] && (s[i - 1] == p[j - 1] || p[j - 1] == '.');
                    }
                }
            }
            return dp[m][n];
        }
    };