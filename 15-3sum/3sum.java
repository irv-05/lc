class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> retList = new ArrayList<>();
        //loop through all elements, the firstNum will become our pivot / target
        HashSet<Integer> pivotUsed = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            int first = nums[i];
            if(pivotUsed.contains(first)) {
                continue;
            }

            HashSet<Integer> seen = new HashSet<>();
            HashSet<Integer> used = new HashSet<>();

            for(int j = i+1; j < nums.length; j++) {
                int second = nums[j];
                if(used.contains(second) || pivotUsed.contains(second)) {
                    continue;
                }

                int target = 0 - (first + second);
                if(seen.contains(target)) {
                    retList.add(makeTriplet(first, second, target));
                    //seen.remove(target);
                    used.add(target);
                    used.add(second);
                } else {
                    seen.add(second);
                }
            }
            pivotUsed.add(first);
        }



/*
        for(int firstNum : freq.keySet()) {
            Set<Integer> usedSecond = new HashSet<>();
            for(int secondNum : freq.keySet()) {
                //we already used this number as the third number, we can't use it again or we will have a repeat triplet
                if(usedFirst.contains(secondNum) || usedSecond.contains(secondNum)) {
                    continue;
                }

                //if there is only one number of this type, then we can't add it twice
                if(firstNum == secondNum && freq.get(firstNum) < 2) {
                    continue;
                }

                int target = 0 - (firstNum + secondNum);
                if(freq.containsKey(target) && !usedFirst.contains(target)) {
                    //if all three numbers are equal, then the freq map must be more than 2
                    if(firstNum == secondNum && target == firstNum && freq.get(target) < 3) {
                        continue;
                    }

                    //if target is equal to one of the other two but we only have one of this type, continue
                    if((firstNum == target || secondNum == target) && freq.get(target) < 2) {
                        continue;
                    }

                    usedSecond.add(target);
                    retList.add(makeTriplet(firstNum, secondNum, target));
                }
            }
            usedFirst.add(firstNum);
        }
        */
        return retList;
    }

    private List<Integer> makeTriplet(int a, int b, int c) {
        List<Integer> triplets = new ArrayList<>();
        triplets.add(a);
        triplets.add(b);
        triplets.add(c);
        return triplets;
    }
}

// n + n+1, n + n+2 , n + n + 3, ... , n + n-1


// we create a frequency map and use that instead. We don't need to do the solution becomes n^2 because we need to sum all numbers only once, then for the third sum, we just check the map to see if the needed value is there.
// lots of edge cases, hard to program
// we can remove a lot of redundancy to make it faster, but the worst case (no sums at all, but all distinct numbers) will always run in n^2