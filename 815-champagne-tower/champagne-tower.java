class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] cur = new double[1];
        cur[0] = poured;
        for(int i = 1; i <= query_row; i++) {
            double[] next = new double[i+1];
            for(int j = 0; j < i; j++) {
                double curPoured = cur[j] < 1.0 ? 0.0 : (cur[j] - 1) / 2;
                next[j] = next[j] + curPoured;
                next[j+1] = curPoured;
            }

            cur = next;
        }

        return Math.min(cur[query_glass], 1.0);
    }
}