class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid[0].length; i++) {
            for(int j = 0; j < grid.length; j++) {
                if(grid[j][i] == '1') {
                    count++;
                    traverseRec(grid, j, i);
                }
            }
        }
        return count;
    }

    public void traverse(char[][] grid, int x, int y) {
        Pair<Integer, Integer> coord = new Pair<>(x, y);
        Deque<Pair<Integer,Integer>> stack = new ArrayDeque<>();
        stack.push(coord);
        while(!stack.isEmpty()) {
            Pair<Integer,Integer> cur = stack.pop();
            x = cur.getKey();
            y = cur.getValue();
            grid[x][y] = 'v';

            if(x - 1 >= 0 && grid[x-1][y] == '1') {
                stack.push(new Pair<>(x-1, y));
            }

            if(x + 1 < grid.length && grid[x+1][y] == '1') {
                stack.push(new Pair<>(x+1, y));
            }

            if(y - 1 >= 0 && grid[x][y-1] == '1') {
                stack.push(new Pair<>(x, y - 1));
            }

            if(y + 1 < grid[0].length && grid[x][y+1] == '1') {
                stack.push(new Pair<>(x, y + 1));
            }
        }
    }

    public void traverseRec(char[][] grid, int x , int y) {
            grid[x][y] = 'v';
            if(x - 1 >= 0 && grid[x-1][y] == '1') {
                traverseRec(grid, x-1, y);
            }

            if(x + 1 < grid.length && grid[x+1][y] == '1') {
                traverseRec(grid, x+1, y);
            }

            if(y - 1 >= 0 && grid[x][y-1] == '1') {
                traverseRec(grid, x, y - 1);
            }

            if(y + 1 < grid[0].length && grid[x][y+1] == '1') {
                traverseRec(grid, x, y + 1);
            }
    }
}