class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        //empty list represents the first subset that is present in all sets and also represents the base case
        List<Integer> base = new ArrayList<>();
        subsets.add(base);

        //we start with set at index [0,1], then move on to set at index [0,2]...[0,n]. At each point, ever list we have found needs to duplicate itself and add the current index,
        //to satisfy the property: "for every new index, we either add the number or we don't".
        for(int i = 0; i < nums.length; i++) {
            int curLen = subsets.size();
            for(int j = 0; j < curLen; j++) {
                List<Integer> dup = new ArrayList<>(subsets.get(j));
                dup.add(nums[i]);
                subsets.add(dup);
            }
        }

        return subsets;
    }
}