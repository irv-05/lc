class Solution {
    public static Map<Character, Integer> map = new HashMap<>();
    static {
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        int num = 0;
        for(int i = 0; i < s.length(); i++) {
            int curVal = map.get(s.charAt(i));
            if(i+1 < s.length() && curVal < map.get(s.charAt(i+1))) {
                num -= curVal;
            } else {
                num += curVal;
            }
        }
        return num;
    }
}