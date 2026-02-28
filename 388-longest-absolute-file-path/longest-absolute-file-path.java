class Solution {
    public int lengthLongestPath(String input) {
        Deque<String> stack = new ArrayDeque<>();

        int maxPath = 0;
        int level = -1;
        input = input + '\n';
        StringBuilder curName = new StringBuilder();
        int curLength = 0;
        StringBuilder curPath = new StringBuilder();
        int curLevel = 0;
        for(int i = 0; i < input.length(); i++) {
            if('\t' == input.charAt(i)) {
                curLevel++;
            } else if('\n' == input.charAt(i)) {
                if(curLevel < level) {
                    int toPop = level - curLevel;

                    for(int j = 0; j < toPop; j++) {
                        String dir = stack.pop();
                        curLength -= dir.length();
                    }
                } 

                if(curName.toString().contains(".")) {
                    if(curLength + curName.length() > maxPath) {
                        maxPath = curLength + curName.length();
                    }
                    level = curLevel;
                } else {
                    curName.append("/");
                    stack.push(curName.toString());
                    curLength += curName.length();
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