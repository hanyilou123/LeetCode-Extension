public class RandomizedCollection {
    List<Integer> nums;
    Map<Integer, Set<Integer>> locs;
    Random rd = new Random();

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        nums = new ArrayList<Integer>();
        locs = new HashMap<Integer, Set<Integer>>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean flag = false;
        if(!locs.containsKey(val))
        {
            flag = true;
            locs.put(val, new HashSet<Integer>());
        }
        locs.get(val).add(nums.size());
        nums.add(val);
        return flag;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!locs.containsKey(val))
            return false;
        int loc = locs.get(val).iterator().next();
        locs.get(val).remove(loc);
        if(loc!=nums.size()-1)
        {
            int lastOne = nums.get(nums.size()-1);
            nums.set(loc, lastOne);
            locs.get(lastOne).remove(nums.size()-1);
            locs.get(lastOne).add(loc);
        }
        nums.remove(nums.size()-1);
        if(locs.get(val).isEmpty())
            locs.remove(val);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(rd.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */