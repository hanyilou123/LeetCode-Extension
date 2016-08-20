public class RandomizedSet {
    List<Integer> nums;
    Map<Integer, Integer> locaHash;
    Random rd = new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        locaHash = new HashMap<Integer, Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(locaHash.containsKey(val))
            return false;
        locaHash.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!locaHash.containsKey(val))
            return false;
        int loc = locaHash.get(val);
        if(loc!=nums.size()-1)
        {
            int lastOne = nums.get(nums.size()-1);
            nums.set(loc, lastOne);
            locaHash.put(lastOne, loc);
        }
        nums.remove(nums.size()-1);
        locaHash.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rd.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */