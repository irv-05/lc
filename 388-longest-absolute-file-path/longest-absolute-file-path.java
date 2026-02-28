class Solution {
    public int lengthLongestPath(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxPath = 0;
        int level = -1;
        input = input + '\n';
        StringBuilder curName = new StringBuilder();
        int curLength = 0;
        int curLevel = 0;
        for(int i = 0; i < input.length(); i++) {
            if('\t' == input.charAt(i)) {
                curLevel++;
            } else if('\n' == input.charAt(i)) {
                if(curLevel < level) {
                    int toPop = level - curLevel;

                    for(int j = 0; j < toPop; j++) {
                        int dir = stack.pop();
                        curLength -= dir;
                    }
                } 

                if(curName.toString().contains(".")) {
                    if(curLength + curName.length() > maxPath) {
                        maxPath = curLength + curName.length();
                    }
                    level = curLevel;
                } else {
                    stack.push(curName.length() + 1);
                    curLength += curName.length() + 1;
                    level = curLevel+1;     
                }
                
                curLevel = 0;
                curName = new StringBuilder();
            } else {
                curName.append(input.charAt(i));
            }
        }
        return maxPath;
    }
}