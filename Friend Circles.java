class Solution {
    
    public void dfs(int[][] M, int[] visited, int i)
    {
        for(int j = 0; j<M[0].length; j++)
        {
            if(M[i][j] == 1 && visited[j]==0)
            {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
    
    
    public int findCircleNum(int[][] M) {
        int len = M.length;
        int[] visited = new int[len];
        int count = 0;
        for(int i = 0; i<len; i++)
        {
            if(visited[i] == 0)
            {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
}
