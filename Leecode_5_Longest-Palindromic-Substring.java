//brute solution O(n**3)
class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        int n = s.length();
        String x = "";
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j <= n; j++){
                if(palindromic(s,i,j)){
                    if((j - i) > max){
                        max = j - i;
                        x = s.substring(i,j);
                    }
                }
            }
        }

        return x;
    }

    public boolean palindromic(String s, int start, int end) {
        for (int i = start, j = end - 1; i <= (start+end)/2 && j >= (start+end)/2; i++, j--) {
          if(s.charAt(i) != s.charAt(j)){
                return false;
            }[]
        }
        return true;
    }
}

//Dynamic Programming O(n**2)
class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[len][len];
        int max = 0;
        int start = 0;
        int end = 0;
        for(int i = 0; i < length; i++){
            for(int j = 0; j <= i; j++){
                if(s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j+1][i-1])){
                    dp[j][i] = true;
                }
                if(dp[j][i] && max < (i - j + 1)){
                    max = i - j + 1;
                    start = j;
                    end = i+1;
                }
            }
        }
        return s.substring(start, end);
    }
}

//Expand Around Center O(n**2)
public String longestPalindrome(String s) {
    if (s == null || s.length() < 1) return "";
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
        int len1 = expandAroundCenter(s, i, i);
        int len2 = expandAroundCenter(s, i, i + 1);
        int len = Math.max(len1, len2);
        if (len > end - start) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
        }
    }
    return s.substring(start, end + 1);
}

private int expandAroundCenter(String s, int left, int right) {
    int L = left, R = right;
    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
        L--;
        R++;
    }
    return R - L - 1;
}

class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        int start = 0;
        int end = 0;
        boolean dp[][] = new boolean [s.length()][s.length()];

        for(int i = 0; i < s.length(); i ++){
            for(int j = 0; j <= i; j++){
                if(s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j+1][i-1])){
                    dp[j][i] = true;
                }
                else{
                    dp[j][i] = false;
                }

                if(dp[j][i] && max < i - j + 1){
                    max = i - j + 1;
                    start = i;
                    end = j + 1;
                }
            }
        }
        return s.substring(start,end);
}
}