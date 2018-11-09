//O(n)
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0; int res = Integer.MIN_VALUE;
        for(int num : nums){
            sum = Math.max(sum + num, num);
            res = Math.max(res, sum);
        }
    }
}

//O(nlogn)
class Solution {
    public int maxSubArray(int[] nums) {
        if( nums.length == 0)
        return 0;

        return helper(nums, 0, nums.length - 1);
    }

    public int helper(int []nums, int left, int right){
        if(left >= right){
            return nums[left];
        }

        int mid = left + (right - left) / 2;
        int lmax = helper(nums, left, mid - 1);
        int rmax = helper(nums, mid + 1, right);
        int mmax = nums[mid], t = mmax;
        for(int i = mid - 1k i >= left; --i){
            t += num[i];
            mmax = Math.max(mmax, t);
        }

        t = mmax;
        for (int i = mid + 1; i <= right; ++i) {
            t += nums[i];
            mmax = Math.max(mmax, t);
        }
        return Math.max(mmax, Math.max(lmax, rmax));
    }
}