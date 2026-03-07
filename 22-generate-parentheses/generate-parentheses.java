// 1 -> ()
// 2 -> ()(), (()), 
// 3 -> (()()), ()()(), (())(), ()(()), ((()))  :  (())(()) : ()(
// if we compute all of the legal parenthesis for i-1, then we can insert one more '(' and one more ')' into these legal parenthesis to form a solution of i. 
// if we find all legal insertions on the set of these, then at each step we are adding only one parenthesis. 

// There is actually only three operations we need to do on the set of valide parenthesis of i-1 to get i. We add () at the beginning, we add () at the end, or we wrap around.
// This is because if we rephrase the problem to say we are building a valid parenthesis string of length x, then the next valid parenthesis string will be x+1. But lets say
// you add some ')' somewhere in the middle. This is unecessary because then the last ')' in the string becomes the newly added ')', which we know will always be the last character
// [can't have '( at the end')]. So then all you did was re-arrange the order of the inner string, but we didn't need to do this because we already have ALL valid string of length x. 
// the same concept applies to adding '(' somewhere in the middle. 
class Solution {
    public List<String> generateParenthesis(int n) {
        HashMap<LinkedList<Character>, Integer> valid = new HashMap<>();

        //base case
        LinkedList<Character> base = new LinkedList<>();
        base.addLast('(');
        valid.put(base, 1);

        int length = n*2; 
        for(int i = 1; i < length; i++) {
            HashMap<LinkedList<Character>, Integer> cur = new HashMap<>();
            for(LinkedList old : valid.keySet()) {
                LinkedList<Character> perm = new LinkedList(old);
                if(valid.get(old) > 0) {
                    perm.addLast(')');
                    cur.put(perm, valid.get(old) - 1);
                    perm = new LinkedList(old);
                }

                if(valid.get(old) < (length - i)) {
                    perm.addLast('(');
                    cur.put(perm, valid.get(old) + 1);
                }   
            }

            valid = cur;
        }

        List<String> ret = new ArrayList<>();
        for(LinkedList<Character> cur : valid.keySet()) {
            StringBuilder sb = new StringBuilder();
            for(Character c : cur) {
                sb.append(c);
            }
            ret.add(sb.toString());       
        }
        return ret;
    }
}