class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0]; int min = nums[0]; int maxRes =nums[0];
        for(int i = 1; i < nums.length; i++){
            int mx = max; int mi = min;
            max = Math.max((Math.max(mx * nums[i], nums[i])), mi * nums[i]);
            min = Math.min((Math.min(mi * nums[i] , nums[i])), mx *nums[i]);
            maxRes = Math.max(max, maxRes);
        }
        return maxRes;
    }
}