class Solution {
    public int lengthLongestPath(String input) {
        String maxPath = "";
        int level = -1;
        input = input + '\n';
        StringBuilder curName = new StringBuilder();
        StringBuilder curPath = new StringBuilder();
        int curLevel = 0;
        for(int i = 0; i < input.length(); i++) {
            if('\t' == input.charAt(i)) {
                curLevel++;
            } else if('\n' == input.charAt(i)) {
                if(curLevel < level) {
                    int toPop = level - curLevel;

                    for(int j = 0; j < toPop; j++) {
                        if(curPath.length() !=0) {
                            curPath.deleteCharAt(curPath.length() - 1);
                        }

                        while(curPath.length() != 0 && curPath.charAt(curPath.length() - 1) != '/') {
                            curPath.deleteCharAt(curPath.length() - 1);
                        }
                    }
                } 

                if(curName.toString().contains(".")) {
                    if(curPath.length() + curName.length() > maxPath.length()) {
                        maxPath = curPath.toString() + curName.toString();
                    }
                    level = curLevel;
                } else {
                    curPath.append(curName.toString());
                    curPath.append("/");
                    level = curLevel+1;     
                }
                
                curLevel = 0;
                curName = new StringBuilder();
            } else {
                curName.append(input.charAt(i));
            }
        }
        return maxPath.length();
    }
}