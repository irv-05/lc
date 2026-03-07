class Solution {
    public List<String> generateParenthesis(int n) {
        HashMap<StringBuilder, Integer> valid = new HashMap<>();

        //base case
        StringBuilder base = new StringBuilder();
        base.append('(');
        valid.put(base, 1);

        int length = n*2; 
        for(int i = 1; i < length; i++) {
            HashMap<StringBuilder, Integer> cur = new HashMap<>();
            for(StringBuilder old : valid.keySet()) {
                StringBuilder perm = new StringBuilder(old);
                int balance = valid.get(old);
                if(balance > 0) {
                    perm.append(')');
                    cur.put(perm, balance - 1);
                    perm = new StringBuilder(old);
                }

                if(balance < (length - i)) {
                    perm.append('(');
                    cur.put(perm, balance + 1);
                }   
            }

            valid = cur;
        }

        List<String> ret = new ArrayList<>();
        for(StringBuilder cur : valid.keySet()) {
            ret.add(cur.toString());       
        }
        return ret;
    }
}