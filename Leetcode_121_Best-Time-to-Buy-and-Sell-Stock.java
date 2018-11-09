class Solution {
    public int maxProfit(int[] prices) {
        int res = 0; int buy = Integer.MAX_VALUE;
        for(int price : prices){
            buy = Math.min(buy, price);
            res = Math.max(price - buy, res);
        }
        return res;
    }
}