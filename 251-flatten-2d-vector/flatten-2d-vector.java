class Vector2D {
    private int x;
    private int y;
    private int[][] vec;

    public Vector2D(int[][] vec) {
        this.x = 0;
        this.y = 0;
        this.vec = vec;  

        findNextValid();  
    }
    
    public int next() {
        int cur = vec[y][x];
        x++;
        findNextValid();
        return cur;
    }
    
    public boolean hasNext() {
        return vec.length > y && vec[y].length > x;
    }

    private void findNextValid() {
        while (vec.length > y && vec[y].length == x) {
            x = 0;
            y++;
        }
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */