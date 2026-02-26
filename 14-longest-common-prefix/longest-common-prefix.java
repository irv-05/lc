class Solution {
    public String longestCommonPrefix(String[] strs) {
        String common = strs[0];

        for(int i = 1; i < strs.length; i++) {
            String cur = strs[i];
            if(common.length() > cur.length()) {
                cur = common;
                common = strs[i];
            }

            StringBuilder curCommon = new StringBuilder();
            for(int j = 0; j < common.length(); j++) {
                if(common.charAt(j) == cur.charAt(j)) {
                    curCommon.append(common.charAt(j));
                } else {
                    break;
                }
            }

            common = curCommon.toString();
        }
        return common;
    }
}