class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        seen.put(target-nums[0], 0);
        for(int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if(seen.containsKey(cur)) {
                int[] ret = new int[2];
                ret[0] = seen.get(cur);
                ret[1] = i;
                return ret;
            } else {
                seen.put(target - cur, i);
            }
        }

        return null;        
    }
}