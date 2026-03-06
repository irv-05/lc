class Solution {
    private class State {
        public int end;
        public StringBuilder str;

        public State(int end, StringBuilder str) {
            this.end = end;
            this.str = str;
        }
    }

    public String decodeString(String s) {
        return decodeString(s, 0, s.length()).str.toString();
    }

    public State decodeString(String s, int start, int end) {
        StringBuilder decoded = new StringBuilder();
        int num = 0; 
        for(int i = start; i < end; i++) {
            char cur = s.charAt(i);
            if(cur >= '0' && cur <= '9') {
                num = (num*10) + (cur - '0');
            } else if (cur >= 'a' && cur <= 'z') {
                decoded.append(cur);
            } else if(cur == '[') {
                State inner = decodeString(s, i+1, end);
                for(int j = 0; j < num; j++) {
                    decoded.append(inner.str);
                }
                num = 0;
                i = inner.end;
            } else {
                return new State(i, decoded);
            }
        }

        return new State(end, decoded);
    }
}