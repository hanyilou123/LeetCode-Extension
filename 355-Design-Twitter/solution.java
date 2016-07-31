public class Twitter {
    class TwitterNode{
        int userId;
        int twitterId;
        TwitterNode(int userId, int twitterId){
            this.userId = userId;
            this.twitterId = twitterId;
        }
    }

    List<TwitterNode> twitterList;
    Map<Integer, Set> userManager;
    /** Initialize your data structure here. */
    public Twitter() {
        twitterList = new LinkedList<TwitterNode>();
        userManager = new HashMap<Integer, Set>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!userManager.containsKey(userId))
        {
            Set<Integer> tmp = new HashSet<Integer>();
            tmp.add(userId);
            userManager.put(userId, tmp);
        }
        TwitterNode node = new TwitterNode(userId, tweetId);
        twitterList.add(0, node);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<Integer>();
        if(!userManager.containsKey(userId))
        {
            Set<Integer> followers = userManager.get(userId);
            int count=0;
            for(TwitterNode curNode: twitterList)
            {
                if(count==10)
                    break;
                if(followers.contains(curNode.userId))
                {
                    res.add(curNode);
                    count++;
                }
            }
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        Set<Integer> focusSet;
        if(!userManager.containsKey(followeeId))
        {
            focusSet = new HashSet<Integer>();
            focusSet.add(followeeId);
            userManager.put(followeeId, focusSet);
        }
        if(!userManager.containsKey(followerId))
        {
            focusSet = new HashSet<Integer>();
            focusSet.add(followerId);
            userManager.put(followerId, focusSet);
        }
        userManager.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followerId!=followeeId && userManager.containsKey(followerId))
        {
            if(userManager.get(followerId).contains(followeeId))
            {
                userManager.get(followerId).remove(followeeId);
            }
        }
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