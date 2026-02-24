//[-2,1,-3,4,-1,2,1,-200,100,1, -200, 5]
class Solution {
    public int maxSubArray(int[] nums) {
        //we go through each index of the array, and compute the sum at that point. At all points, we can either choose to restart our sum starting
        // at this index OR continue with our current sum. We would only restart if the current sum is negative and the current index value is less than
        // the total sum. Otherwise, just simply adding this index will result in a greater value. At everypoint, we are storing the max total sum.

        int cur = nums[0];
        int max = cur;
        for(int i = 1; i < nums.length; i++) {
            if(cur < 0 && nums[i] > cur) {
                cur = nums[i];
            } else {
                cur += nums[i];
            }
            
            if(cur > max) {
                max = cur;
            }
            
        }

        return max;
    }
}