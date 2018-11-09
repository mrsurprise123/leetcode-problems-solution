class Solution {
    public int rob(int[] nums) {
        if(nums.length <= 1)
            return nums.length == 0?0:nums[0];
        return Math.max(rob(nums,0,nums.length - 1), rob(nums,1,nums.length));
    }

    int rob(int[] num, int left, int right){
        int prevMax = 0;
        int currMax = 0;

        if(right - left <= 1)
            return num[left];
        for(int i = left; i < right; i++){
            int temp = currMax;
            currMax = Math.max(prevMax + num[i], currMax);
            prevMax = temp;
        }
        return currMax;
    }
}