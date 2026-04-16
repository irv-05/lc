class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> dict = new HashMap<>();

        for(String s : strs) {
            int[] curWord = new int[26];
            for(int i = 0; i < s.length(); i++) {
                curWord[s.charAt(i)-'a']++;
            }

            if(dict.containsKey(java.util.Arrays.hashCode(curWord))) {
                dict.get(java.util.Arrays.hashCode(curWord)).add(s);
            } else {
                List<String> curList = new ArrayList<>();
                curList.add(s);
                dict.put(java.util.Arrays.hashCode(curWord), curList);
            }
        }
        
        List<List<String>> ret = new ArrayList();
        ret.addAll(dict.values());
        return ret;
    }
}