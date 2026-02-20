//[0,3,7,2,5,8,4,6,0,1]
//0
//3
//
class Solution {
    public int longestConsecutive(int[] nums) {
        //build two maps, one for the heads and one for the tails
        Map<Integer, List<Integer>> heads = new HashMap<>();
        Map<Integer, List<Integer>> tails = new HashMap<>();

        Set<Integer> seen = new HashSet();
        //first, place each element into a list. We will combine them later
        for(int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if(seen.contains(cur)) {
                continue;
            }

            seen.add(cur);

            if(heads.containsKey(cur+1)) {
                List<Integer> curList = heads.get(cur+1);
                curList.addFirst(cur);
                heads.remove(cur+1);
                heads.put(cur, curList);
                tails.put(curList.getLast(), curList);
            } else if(tails.containsKey(cur-1)) {
                List<Integer> curList = tails.get(cur-1);
                curList.addLast(cur);
                tails.remove(cur-1);
                tails.put(cur,curList);
                heads.put(curList.getFirst(), curList);
            } else {
                List<Integer> curList = new LinkedList();
                curList.addFirst(cur);
                heads.put(cur, curList);
                tails.put(cur, curList);
            }
        }

        Set<Integer> tempSet = new HashSet<>();
        tempSet.addAll(tails.keySet());
        //now, we merge all of the lists together
        for(Integer curTail : tempSet) {
            if(heads.containsKey(curTail+1)) {
                Integer curHead = tails.get(curTail).getFirst();

                List<Integer> curList = heads.get(curHead);
                curList.addAll(heads.get(curTail+1));
                tails.put(heads.get(curTail+1).getLast(), curList);
                heads.remove(curTail+1);
            }
        }

        int maxSize = 0;
        for(List<Integer> curHead : heads.values()) {
            if(curHead.size() > maxSize) {
                maxSize = curHead.size();
            }
        }

        return maxSize;
    }
}