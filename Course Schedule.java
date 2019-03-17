class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> map =new HashMap<Integer, ArrayList<Integer>>();
        int[] visited = new int[numCourses];
        
        if(prerequisites == null || numCourses == 0)
            return true;
        for(int a[] : prerequisites)
        {
            if(map.containsKey(a[1]))
            {
                map.get(a[1]).add(a[0]);
            }
            else {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(a[0]);
                map.put(a[1], list);
            }
        }
        
        for(int i = 0; i<numCourses; i++)
        {
            if(!helperFunc(i, map, visited))
            {
                return false;
            }
        }
        return true;
    }
    static boolean helperFunc(int i, HashMap<Integer, ArrayList<Integer>> map, int[] visited)
    {
        if(visited[i] == -1)
            return false;
        if(visited[i] == 1)
            return true;
        visited[i] = -1;
        if(map.containsKey(i)) {
        for(int j : map.get(i))
        {
            if(!helperFunc(j, map, visited))
            {
                return false;
            }
        }
        }
        visited[i] = 1;
        return true;
    }
    
}
