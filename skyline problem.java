class Solution {
    class Edge {
        int x;
        int height;
        boolean isStart;
        
        public Edge(int x, int height, boolean isStart)
        {
            this.x = x;
            this.height = height;
            this.isStart = isStart;
        }
    }
    
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<int[]>();
        
        if(buildings == null||buildings.length == 0 ||buildings[0].length == 0)
            return result;
        
        List<Edge> edges = new ArrayList<Edge>();
        
        for(int[] building : buildings)
        {
            Edge startEdge = new Edge(building[0], building[2], true);
            edges.add(startEdge);
            Edge endEdge = new Edge(building[1], building[2], false);
            edges.add(endEdge);
        }
        
        Collections.sort(edges, new Comparator<Edge>(){
           public int compare(Edge a, Edge b){
               if(a.x != b.x)
                   return Integer.compare(a.x, b.x);
               if(a.isStart && b.isStart)
                   return Integer.compare(b.height, a.height);
               if(!a.isStart && !b.isStart)
                   return Integer.compare(a.height, b.height);
               return a.isStart ? -1:1;
           } 
        });
        
        PriorityQueue<Integer> map = new PriorityQueue<Integer>(10, Collections.reverseOrder());
        for(Edge edge: edges)
        {
            if(edge.isStart)
            {
                if(map.isEmpty() || edge.height > map.peek()) {
                    result.add(new int[] {
                        edge.x, edge.height
                    });
                }
                map.add(edge.height);
            }
            else
            {
                map.remove(edge.height);
                
                if(map.isEmpty()) {
                    result.add(new int[] {edge.x, 0});
                }
                else if(edge.height > map.peek())
                {
                    result.add(new int[] {edge.x, map.peek()});
                }
            }
        }
        return result;
    }
}
