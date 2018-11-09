
//Convert int to string O(n)
class Solution {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        int end = s.length();
        for (int i = 0, j = end - 1; i <= end/2 && j >= end/2; i++, j--) {
            if(s.charAt(i) != s.charAt(j)){
                  return false;
              }
          }
          return true;
    }
}

//Revert half of the number
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        else{
            int RevertedNumber = 0;
            while(RevertedNumber < x){
                RevertedNumber = RevertedNumber*10 +x % 10;
                x = x / 10;
            }
            return x == RevertedNumber || x == RevertedNumber / 10;
        }
    }
}