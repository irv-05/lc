class Solution {
    public int lengthLongestPath(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxPath = 0;
        int level = -1;

        int curName = 0;
        int curLength = 0;
        int curLevel = 0;
        boolean isFile = false;
        for(int i = 0; i < input.length()+1; i++) {
            if(i == input.length() || '\n' == input.charAt(i)) {
                if(curLevel < level) {
                    int toPop = level - curLevel;

                    for(int j = 0; j < toPop; j++) {
                        int dir = stack.pop();
                        curLength -= dir;
                    }
                } 

                if(isFile) {
                    if(curLength + curName > maxPath) {
                        maxPath = curLength + curName;
                    }
                    level = curLevel;
                } else {
                    stack.push(curName+1);
                    curLength += curName+1;
                    level = curLevel+1;     
                }
                
                curLevel = 0;
                curName = 0;
                isFile = false;
            } else if('\t' == input.charAt(i)) {
                curLevel++;
            } else {
                if(input.charAt(i) == '.') {
                    isFile = true;
                }
                curName++;
            }
        }
        return maxPath;
    }
}