class Object
{
    ArrayList<Integer> list;
    int index;
    
    public Object(ArrayList<Integer> list, int index){
        this.list=list;
        this.index=index;
    }
}


class Twitter {
    
    /** Initialize your data structure here. */
    
    HashMap<Integer, HashSet<Integer>> followlist;
    HashMap<Integer, ArrayList<Integer>> tweetlist; 
    HashMap<Integer, Integer> orderlist;
    int order;
    
    public Twitter() {
        followlist = new HashMap<Integer, HashSet<Integer>>();
        tweetlist = new HashMap<Integer, ArrayList<Integer>>();
        orderlist = new HashMap<Integer, Integer>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        ArrayList<Integer> list = tweetlist.get(userId);
        if(list == null)
        {
            list = new ArrayList<Integer>();
            tweetlist.put(userId, list);
        }
        list.add(tweetId);
        orderlist.put(tweetId, order++);
        follow(userId, userId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        HashSet<Integer> set = followlist.get(userId);
        if(set==null)
            return new ArrayList<Integer>();
        
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        
        for(int id : set)
        {
            if(tweetlist.get(id)!=null && tweetlist.get(id).size()>0)
                lists.add(tweetlist.get(id));
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        PriorityQueue<Object> queue = new PriorityQueue<Object>(new Comparator<Object>(){
            public int compare(Object a, Object b)
            {
                return orderlist.get(b.list.get(b.index)) - orderlist.get(a.list.get(a.index));
            }
        });
        
        for(ArrayList<Integer> list : lists)
        {
            queue.add(new Object(list, list.size()-1));
        }
        
        while(!queue.isEmpty() && result.size()<10)
        {
            Object x = queue.poll();
            result.add(x.list.get(x.index));
            x.index--;
            if(x.index >= 0)
                queue.add(x);
        }
        
        return result;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        HashSet<Integer> set = followlist.get(followerId);
        if(set == null)
        {
            set = new HashSet<Integer>();
            followlist.put(followerId, set);
        }
        set.add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId)
            return;
        HashSet<Integer> set = followlist.get(followerId);
        if(set == null)
            return;
        set.remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
