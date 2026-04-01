class Solution {
    public int searchInsert(int[] nums, int target) {
        int a = 0;
        int b = nums.length-1;
        while(a < b) {
            //prevent overflow
            int mid = a + ((b - a) / 2) + 1;

            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                a = mid;
            } else {
                b = mid - 1;
            }
        }

        return nums[a] >= target ? a : a + 1;
    }
}