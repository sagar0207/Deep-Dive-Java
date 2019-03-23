class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        
        int R = grid.length;
        int C = grid[0].length;
        
        if(grid[0][0] == 1)
            return 0;
        
        grid[0][0] = 1;
        
        for(int i = 1; i<R; i++)
        {
            grid[i][0] = (grid[i][0] == 0 && grid[i-1][0] == 1)? 1: 0;
        }
        
        for (int i = 1; i < C; i++) {
            grid[0][i] = (grid[0][i] == 0 && grid[0][i - 1] == 1) ? 1 : 0;
        }
        
        for(int i = 1; i<R; i++)
        {
            for(int j = 1; j<C; j++)
            {
                if(grid[i][j] == 0)
                    grid[i][j] = grid[i-1][j] + grid[i][j-1];
                else
                    grid[i][j] = 0;
            }
        }
        return grid[R-1][C-1];
    }
} 
