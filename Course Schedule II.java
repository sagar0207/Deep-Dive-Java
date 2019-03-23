class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int[] indegree = new int[numCourses];
        int[] result = new int[numCourses];
        
        for(int i = 0; i < prerequisites.length; i++)
        {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> lst = map.getOrDefault(src, new ArrayList<Integer>());
            lst.add(dest);
            map.put(src, lst);
            
            indegree[dest] +=1;
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0 ; i<numCourses; i++)
        {
            if(indegree[i] == 0)
            {
                q.add(i);
            }
        }
        int i = 0;
        while(!q.isEmpty())
        {
            int node = q.remove();
            result[i++] = node;
            
            if(map.containsKey(node))
            {
                for(Integer n : map.get(node))
                {
                    indegree[n]--;
                    
                    if(indegree[n] == 0)
                        q.add(n);
                    
                }
            }
        }
        
        if(i == numCourses)
            return result;
        
        return new int[0];
    }
}
