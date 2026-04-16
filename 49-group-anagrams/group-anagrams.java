class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> dict = new HashMap<>();

        for(String s : strs) {
            int[] curWord = new int[26];
            for(int i = 0; i < s.length(); i++) {
                curWord[s.charAt(i)-'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for(int val : curWord) {
                sb.append('-');
                sb.append(val);
            }

            String wordCount = sb.toString();

            if(dict.containsKey(wordCount)) {
                dict.get(wordCount).add(s);
            } else {
                List<String> curList = new ArrayList<>();
                curList.add(s);
                dict.put(wordCount, curList);
            }
        }
        
        List<List<String>> ret = new ArrayList();
        ret.addAll(dict.values());
        return ret;
    }
}