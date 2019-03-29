class Solution {
    public int totalFruit(int[] tree) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int result = 0;
        for(int j = 0; j<tree.length; ++j)
        {
            if(map.containsKey(tree[j]))
                map.put(tree[j], map.get(tree[j])+1);
            else
                map.put(tree[j], 1);
            
            while(map.size()>2)
            {
                map.put(tree[i], map.get(tree[i])-1);
                if(map.get(tree[i])==0)
                    map.remove(tree[i]);
                i++;
            }
            
            result = Math.max(result, j-i+1);
            
        }
        return result;
        
    }
}
