class Solution {
    public String longestCommonPrefix(String[] strs) {
        //find the smallest word first
        int minSize = strs[0].length();
        for(String str : strs) {
            int curSize = str.length();
            if(str.length() < minSize) {
                minSize = curSize;
            }
        }

        StringBuilder common = new StringBuilder();
        for(int i = 0; i < minSize; i++) {
            char curChar = strs[0].charAt(i);
            for(String str : strs) {
                if(curChar != str.charAt(i)) {
                    return common.toString();
                }
            }
            common.append(curChar);
        }

        return common.toString();
    }
}