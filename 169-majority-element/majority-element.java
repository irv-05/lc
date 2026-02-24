class Solution {
    public int majorityElement(int[] nums) {
        // for o(n) space and o(n) time, the solution is easy. We just create a frequency map. Once any number in the frequency map passes the majority, we return it.
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums) {
            int occ = 1;
            if(freq.containsKey(num)) {
                occ += freq.get(num);
            }

            if(occ > nums.length / 2) {
                return num;
            }

            freq.put(num, occ);
        }

        return -1;
    }
}