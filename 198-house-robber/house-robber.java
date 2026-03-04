// 10000, 1, 1, 10000
// 10000, 1, 1, 1, 100000
class Solution {
    public int rob(int[] nums) {
        //we can use dp. the optimal house robberies for rob(nums[i]) is max(rob(nums[i-2] + nums[i], rob(nums[i-1]))). This is because it would be illegal
        // to add our current num to the previous optimal solution, but we can add it to the second previous optimal solution. If the previous optimal solution
        // actually DID NOT include nums[i-1], then it's the same as nums[i-2], so we wouldn't really miss a state. We know no matter what that if we want to include
        //i+1, we are ok to include i-1, but not ok to include i. So we keep track of two past states.

        if(nums.length == 1) {
            return nums[0];
        }

        int state1 = nums[0];
        int state2 = Math.max(state1, nums[1]);

        for(int i = 2; i < nums.length; i++) {
            int state3 = Math.max(state1 + nums[i], state2);
            state1 = state2;
            state2 = state3;
        }

        return Math.max(state1, state2);
    }
}