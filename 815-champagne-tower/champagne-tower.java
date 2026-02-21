class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        List<Double> cur = new ArrayList<>();
        cur.add(0.0 + poured);
        for(int i = 1; i <= query_row; i++) {
            List<Double> next = new ArrayList<>();
            next.add(0.0);
            for(int j = 0; j < cur.size(); j++) {
                Double curPoured = cur.get(j) < 1.0 ? 0 : (cur.get(j) - 1) / 2;
                
                next.set(j, next.get(j) + curPoured);
                next.add(curPoured);
            }

            cur = next;
        }

        return Math.min(cur.get(query_glass), 1.0);
    }
}