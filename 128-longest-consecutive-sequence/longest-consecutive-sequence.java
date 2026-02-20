//[0,3,7,2,5,8,4,6,0,1]
//0
//3
//
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        //build two maps, one for the heads and one for the tails
        Map<Integer, Integer> heads = new HashMap<>();
        Map<Integer, Integer> tails = new HashMap<>();

        Set<Integer> seen = new HashSet();
        //first, place each element into a list. We will combine them later
        for(int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if(seen.contains(cur)) {
                continue;
            }

            seen.add(cur);

            if(heads.containsKey(cur+1)) {
                Integer curTail = heads.get(cur+1);
                heads.remove(cur+1);
                heads.put(cur, curTail);
                tails.put(curTail,cur);
            } else if(tails.containsKey(cur-1)) {
                Integer curHead = tails.get(cur-1);
                tails.remove(cur-1);
                tails.put(cur,curHead);
                heads.put(curHead,cur);
            } else {
                heads.put(cur, cur);
                tails.put(cur, cur);
            }
        }

        Set<Integer> tempSet = new HashSet<>();
        tempSet.addAll(tails.keySet());
        //now, we merge all of the lists together
        for(Integer curTail : tempSet) {
            if(heads.containsKey(curTail+1)) {
                Integer curHead = tails.get(curTail);
                heads.put(curHead, heads.get(curTail+1));
                tails.put(heads.get(curTail+1), curHead);
                heads.remove(curTail+1);
            }
        }

        int maxSize = 0;
        for(Integer curHead : heads.keySet()) {
            int size = heads.get(curHead) - curHead;
            if(size > maxSize) {
                maxSize = size;
            }
        }

        return maxSize+1;
    }
}