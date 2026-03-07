// 1 -> ()
// 2 -> ()(), (()), 
// 3 -> (()()), ()()(), (())(), ()(()), ((())) -> (()(()))
// if we compute all of the legal parenthesis for i-1, then we can insert one more '(' and one more ')' into these legal parenthesis to form a solution of i. 
// if we find all legal insertions on the set of these, then at each step we are adding only one parenthesis. 

// There is actually only three operations we need to do on the set of valide parenthesis of i-1 to get i. We add () at the beginning, we add () at the end, or we wrap around.
// This is because if we rephrase the problem to say we are building a valid parenthesis string of length x, then the next valid parenthesis string will be x+1. But lets say
// you add some ')' somewhere in the middle. This is unecessary because then the last ')' in the string becomes the newly added ')', which we know will always be the last character
// [can't have '( at the end')]. So then all you did was re-arrange the order of the inner string, but we didn't need to do this because we already have ALL valid string of length x. 
// the same concept applies to adding '(' somewhere in the middle. 
class Solution {
    public List<String> generateParenthesis(int n) {
        Set<LinkedList<Character>> valid = new HashSet<>();

        //base case
        LinkedList<Character> base = new LinkedList<>();
        base.addLast('(');
        base.addLast(')');
        valid.add(base);

        //illegal base case
        base = new LinkedList<>();
        base.addLast(')');
        base.addLast('(');
        valid.add(base);

        base = new LinkedList<>();
        base.addLast(')');
        base.addLast(')');
        valid.add(base);

        base = new LinkedList<>();
        base.addLast('(');
        base.addLast('(');
        valid.add(base);


        for(int i = 1; i < n; i++) {
            Set<LinkedList<Character>> cur = new HashSet<>();
            for(LinkedList old : valid) {
                LinkedList perm = new LinkedList(old);
                perm.addLast('(');
                perm.addLast(')');
                cur.add(perm);                
                
                perm = new LinkedList(old);
                perm.addFirst(')');
                perm.addFirst('(');
                cur.add(perm);
                
                perm = new LinkedList(old);
                perm.addFirst('(');
                perm.addLast(')');
                cur.add(perm);

                //also add illegal perms
                perm = new LinkedList(old);
                perm.addFirst('(');
                perm.addFirst(')');
                cur.add(perm);
                
                perm = new LinkedList(old);
                perm.addLast(')');
                perm.addLast('(');
                cur.add(perm);

                perm = new LinkedList(old);
                perm.addFirst(')');
                perm.addLast('(');
                cur.add(perm);

                perm = new LinkedList(old);
                perm.addFirst(')');
                perm.addFirst(')');
                cur.add(perm);

                perm = new LinkedList(old);
                perm.addLast('(');
                perm.addLast('(');
                cur.add(perm);
            }

            valid = cur;
        }

        List<String> ret = new ArrayList<>();
        for(LinkedList<Character> cur : valid) {
            boolean validString = true;
            int balance = 0;
            StringBuilder sb = new StringBuilder();
            for(Character c : cur) {
                if(c == ')') {
                    balance--;
                } else {
                    balance++;
                }

                if(balance < 0) {
                    validString = false;
                    break;
                }
                sb.append(c);
            }

            if(validString && balance == 0) {
                ret.add(sb.toString());
            }
        }

        System.out.print(ret.size());
        return ret;
    }
}