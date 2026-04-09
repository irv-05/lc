import java.util.NoSuchElementException;

class Vector2D {
    private Iterator<int[]> vec;
    private Iterator<Integer> it;

    public Vector2D(int[][] vec) {
        this.vec = Arrays.stream(vec).iterator();
        findNextValid();  
    }
    
    public int next() {
        if(!it.hasNext()) {
            throw new NoSuchElementException();
        }

        int cur = it.next();
        findNextValid();

        return cur;
    }
    
    public boolean hasNext() {
        return it != null && (vec.hasNext() || it.hasNext());
    }

    private void findNextValid() {
        while(vec.hasNext() && (it == null || !it.hasNext())) {
            int[] cur = vec.next();
            if(cur.length != 0) {
                it = Arrays.stream(cur).iterator();
            }
        }
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */