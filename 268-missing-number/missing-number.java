class Solution {
    public int missingNumber(int[] nums) {
        int[] freq = new int[nums.length+1];

        for(int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }

        for(int i = 0; i < freq.length; i++) {
            if(freq[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}