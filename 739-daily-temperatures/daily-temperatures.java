//start backwards
// we know that if number at index i - 1 is greater than number at index i, then we can discard number at index i, because
// nothing will ever need number at index i when they can just take number at index i - 1.
// so we maintain a stack of "usable" indexes.
// if number at i-1 is less than number at i, then the solution is 1. if number at i - 1 is greater than number at i, then 
// we go through the stack until we find the index that is greater than number at i - 1. And, we know that we don't need
// any numbers in the stack that we just popped, because they will have been less than number i - 1, so we can just use i - 1
// in any future cases. finally we put i - 1 into the stack and move to the next index.
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> usableStack = new ArrayDeque<>();
        int[] answer = new int[temperatures.length];

        for(int i = temperatures.length - 1; i >= 0; i--) {
            int val = 0;
            while(!usableStack.isEmpty() && temperatures[usableStack.peek()] <= temperatures[i]) { 
                usableStack.pop();
            }

            answer[i] = usableStack.isEmpty() ? 0 : usableStack.peek() - i;
            usableStack.push(i);
        }

        return answer;
    }
}